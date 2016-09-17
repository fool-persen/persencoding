package com.persen.beijing.spEl;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpringSpelMain {

	public static void main(String[] args) {
		String greetingExp = "Hello, #{ #user }";
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("user", "Gangyou");

		Expression expression = parser.parseExpression(greetingExp,
				new TemplateParserContext());
		System.out.println(expression.getValue(context, String.class));
	}
}
