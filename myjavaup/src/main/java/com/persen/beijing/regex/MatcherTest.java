package com.persen.beijing.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    public static void main(String[] args) throws Exception {
        String input = "Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company";
        //System.out.println(input.substring(0, input.length()));
        //System.out.println(input.substring(1, input.length()));
        // 生成Pattern对象并且编译一个简单的正则表达式"Kelvin"
        Pattern p = Pattern.compile("Kelvin");
		/*
		 String str[] = p.split(input);
		
		for (String s : str) {
			System.out.println(s);
		}
		*/

        //Boolean b = Pattern.matches("Kelvin", "Kelvin");
        //System.out.println(b);

        // 用Pattern类的matcher()方法生成一个Matcher对象
        Matcher m = p
                .matcher(input);


        StringBuffer sb = new StringBuffer();
        int i = 0;
        // 使用find()方法查找第一个匹配的对象
        boolean result = m.find();
        // 使用循环将句子里所有的kelvin找出并替换再将内容加到sb里
        while (result) {
            String s1 = m.group();
            System.out.println("group:" + s1);
            i++;
            m.appendReplacement(sb, "Kevin");
            System.out.println("第" + i + "次匹配后sb的内容是：" + sb);
            sb.delete(0, sb.length());
            // 继续查找下一个匹配对象
            result = m.find();
        }
        // 最后调用appendTail()方法将最后一次匹配后的剩余字符串加到sb里；
        m.appendTail(sb);
        System.out.println("调用m.appendTail(sb)后sb的最终内容是:" + sb.toString());
    }
}