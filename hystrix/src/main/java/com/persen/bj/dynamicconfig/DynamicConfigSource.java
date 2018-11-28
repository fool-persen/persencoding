package com.persen.bj.dynamicconfig;

import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lijianyu on 2018/11/28.
 */
@Component
public class DynamicConfigSource implements PolledConfigurationSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicConfigSource.class);

    @Override
    public PollResult poll(boolean initial, Object checkPoint) throws Exception {
        Map<String, Object> complete = new HashMap<String, Object>();

        /**
         * 配置中心配置了对应的key/value。其中commandKey是我指定的具体接口。
         */
//        complete.put("hystrix.command.stringCommand.execution.isolation.thread.timeoutInMilliseconds",
//                "1002");
//        complete.put("hystrix.threadpool.stringCommand.coreSize",
//                "32");
        complete.putAll(loadPProperties());

        logger.debug("poll:{}", complete);

        return PollResult.createFull(complete);
    }

    private Map<String, String> loadPProperties() {
        Map<String, String> retMap = new HashMap<>();
        try {
            Properties prop = new Properties();
            InputStream in = new BufferedInputStream(new FileInputStream("/Users/persenlee/Documents/github/persencoding/hystrix/src/main/resources/config.properties"));

            prop.load(in);

            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                retMap.put(key, prop.getProperty(key));
            }

            in.close();
        } catch (IOException e) {
            logger.error("{}", e);
            System.exit(-1);
        }
        return retMap;
    }
}

