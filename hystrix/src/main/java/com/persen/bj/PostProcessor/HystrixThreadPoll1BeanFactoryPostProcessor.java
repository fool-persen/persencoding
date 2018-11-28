package com.persen.bj.PostProcessor;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.persen.bj.Proxy.HystrixCommandProxy;
import com.persen.bj.annotation.HystrixThreadPoll1;
import com.persen.bj.annotation.PersonalizeHystrixCommand1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

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
//@Order(1)
public class HystrixThreadPoll1BeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("******调用了BeanFactoryPostProcessor");

        String[] beanStr = configurableListableBeanFactory
                .getBeanNamesForAnnotation(PersonalizeHystrixCommand1.class);
        for (String beanName : beanStr) {
            Object bean = configurableListableBeanFactory//.getBeanDefinition()
                    .getBean(beanName);
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

                String threadPoolKey = ((HystrixThreadPoll1) annotationHystrixThreadPoll1).threadPoolKey();
                HystrixCommandProxy proxy = new HystrixCommandProxy();

                InvocationHandler h = Proxy.getInvocationHandler(annotationHystrixCommand);
                //获取 AnnotationInvocationHandler 的 memberValues 字段
                Field hField = null;
                try {
                    hField = h.getClass().getDeclaredField("memberValues");
                    // 因为这个字段事 private final 修饰，所以要打开权限
                    hField.setAccessible(true);
                    // 获取 memberValues
                    Map memberValues = null;
                    memberValues = (Map) hField.get(h);
                    // 修改 value 属性值
                    memberValues.put("threadPoolKey", threadPoolKey);
                    System.out.println(annotationHystrixCommand.threadPoolKey());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        }

        System.out.println("******调用了BeanFactoryPostProcessor结束 ");
    }
}