package com.persen.beijing.spEl;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

public class SpringSpelMain {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();
        //基本表达式
        //字符串
        String str1 = parser.parseExpression("'Hello World!'").getValue(String.class);
        String str2 = parser.parseExpression("\"Hello World!\"").getValue(String.class);
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
        //数字类型
        int int1 = parser.parseExpression("1").getValue(Integer.class);
        long long1 = parser.parseExpression("-1L").getValue(long.class);
        float float1 = parser.parseExpression("1.1").getValue(Float.class);
        double double1 = parser.parseExpression("1.1E+2").getValue(double.class);
        int hex1 = parser.parseExpression("0xa").getValue(Integer.class);
        long hex2 = parser.parseExpression("0xaL").getValue(long.class);
        System.out.println("int" + int1 + " long" + long1 + " float" + float1 + " double" + double1 + " hex1" + hex1 + " hex2" + hex2);
        //布尔类型
        boolean true1 = parser.parseExpression("true").getValue(boolean.class);
        boolean false1 = parser.parseExpression("false").getValue(boolean.class);
        System.out.println("true:" + true1 + " false:" + false1);
        //null类型
        Object null1 = parser.parseExpression("null").getValue(Object.class);
        System.out.println("null:" + null);

        //类类型
        //java.lang包下不需要全限定名，其他包下需要全限定名
        Class<String> result1 = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(result1);
        //其他包下需要全限定名
        Class<Customer> result2 = parser.parseExpression("T(com.persen.beijing.spEl.Customer)").getValue(Class.class);
        System.out.println(result2);
        //类静态字段访问
        int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
        System.out.println(result3);
        //类静态方法调用
        int result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
        System.out.println(result4);

        //类实例化
        String result5 = parser.parseExpression("new String('haha')").getValue(String.class);
        System.out.println(result5);
        Date result6 = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        System.out.println(result6);

        //变量定义及引用
        // EvaluationContext context = new StandardEvaluationContext();
        EvaluationContext context = new StandardEvaluationContext("haha");
        context.setVariable("name", "nana");
        context.setVariable("age", "12");
        String name = parser.parseExpression("#name").getValue(context, String.class);
        System.out.println(name);
        String age = parser.parseExpression("#age").getValue(context, String.class);
        System.out.println(age);


        String root = parser.parseExpression("#root").getValue(context, String.class);
        System.out.println(root);

        String tt = parser.parseExpression("#this").getValue(context, String.class);
        System.out.println(tt);

        User user = new User();
        user.setServiceNumber("199");
        context.setVariable("user", user);
        User user1 = new User();
        user1.setServiceNumber("1999");
        context.setVariable("user1", user1);
        String serviceNumber = parser.parseExpression("#user1.serviceNumber").getValue(context, String.class);
        System.out.println(serviceNumber);

        /*
        String greetingExp = "Hello, #{ #user }";
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("user", "Gangyou");

		Expression expression = parser.parseExpression(greetingExp,
				new TemplateParserContext());
		System.out.println(expression.getValue(context, String.class));
		*/
    }


    public static class User {
        private String serviceNumber;

        public String getServiceNumber() {
            return serviceNumber;
        }

        public void setServiceNumber(String serviceNumber) {
            this.serviceNumber = serviceNumber;
        }
    }
}
