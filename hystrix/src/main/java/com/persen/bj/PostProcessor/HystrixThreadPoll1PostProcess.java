package com.persen.bj.PostProcessor;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.persen.bj.Proxy.HystrixCommandProxy;
import com.persen.bj.annotation.HystrixThreadPoll1;
import com.persen.bj.annotation.PersonalizeHystrixCommand1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by lijianyu on 2018/11/3.
 */
//@Component
final public class HystrixThreadPoll1PostProcess implements BeanPostProcessor {
    @Value("${hystrix.core.size}")
    private int coreSizeYML;

    private Map getMemberMap(Object object) {
        InvocationHandler h = Proxy.getInvocationHandler(object);
        //获取 AnnotationInvocationHandler 的 memberValues 字段
        Field hField = null;
        Map memberValues = null;
        try {
            hField = h.getClass().getDeclaredField("memberValues");
            // 因为这个字段事 private final 修饰，所以要打开权限
            hField.setAccessible(true);
            // 获取 memberValues
            memberValues = (Map) hField.get(h);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Server start succ" + e);
            return null;
        } finally {
            return memberValues;
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getAnnotation(PersonalizeHystrixCommand1.class) != null) {
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (Method method : methods) {

                HystrixCommand annotationHystrixCommand = method.getAnnotation(HystrixCommand.class);
                if (annotationHystrixCommand == null) {
                    continue;
                }
                Annotation annotationHystrixThreadPoll1 = method.getAnnotation(HystrixThreadPoll1.class);
                if (annotationHystrixThreadPoll1 == null) {
                    continue;
                }

                //获取注解成员
                String threadPoolKey = ((HystrixThreadPoll1) annotationHystrixThreadPoll1).threadPoolKey();
                int coreSize = ((HystrixThreadPoll1) annotationHystrixThreadPoll1).coreSize();
                int maxQueueSize = ((HystrixThreadPoll1) annotationHystrixThreadPoll1).maxQueueSize();

                HystrixCommandProxy proxy = new HystrixCommandProxy();

                Map memberValues = getMemberMap(annotationHystrixCommand);
                memberValues.put("threadPoolKey", threadPoolKey);
                System.out.println(annotationHystrixCommand.threadPoolKey());

                // 修改threadPoolProperties
                HystrixProperty[] hystrixProperties = (HystrixProperty[]) memberValues.get("threadPoolProperties");

                for (HystrixProperty hystrixProperty : hystrixProperties) {
                    Map memberMap = getMemberMap(hystrixProperty);
                    if (("maxQueueSize").equals(memberMap.get("name"))) {
                        memberMap.put("value", String.valueOf(maxQueueSize));
                    }
                    if (("coreSize").equals(memberMap.get("name"))) {
                        memberMap.put("value", String.valueOf(coreSizeYML));
                    }
                }

            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
