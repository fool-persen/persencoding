package com.persen.beijing.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by lijy on 2017/11/2.
 */
public class ProduceMain {
	public static void main(String[] args) {
		Properties props = new Properties();

		props.put("bootstrap.servers", "172.168.1.217:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

		// 发送消息
		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<String, String>("abc", Integer.toString(i), Integer.toString(i)), new Callback() {
				@Override
				public void onCompletion(RecordMetadata recordMetadata, Exception e) {
					if (e == null) {
						System.out.printf("offset = %d ,partition = %d \n", recordMetadata.offset(), recordMetadata.partition());
					} else {
						System.out.println("send error !" + e);
					}
				}
			});
		}
		producer.flush();
		producer.close();
	}
}
