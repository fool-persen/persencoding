package com.persen.beijing.google_classpath_explorer;

import com.google.classpath.ClassPathFactory;
import com.google.classpath.ResourceFilter;
import com.google.classpath.ResourceFinder;

import java.lang.reflect.Method;
import java.util.List;

public class ClassPathExplorer {

    static String packageNames[] = {"com.persen.beijing"};

    public static void main(String[] args) {
        // 从JVM中获取类信息
        ClassPathFactory factory = new ClassPathFactory();
        ResourceFinder finder = new ResourceFinder(factory.createFromJVM());
        ResourceFilter filter = new ResourceFilter() {
            @Override
            public boolean match(String path, String name) {
                return name.endsWith(".class");

            }
        };

        for (String packageName : packageNames) {
            //JVM中获取类全名
            String[] resources = finder.findResources(
                    packageName.replace(".", "/"), filter);

            for (String resource : resources) {
                String className = resource.substring(0, resource.length() - 6)
                        .replace("/", ".");
                System.out.println(className);
            }
        }

        Method[] methods = factory.getClass().getMethods();
        System.out.println(methods[0].getName());
    }

}
