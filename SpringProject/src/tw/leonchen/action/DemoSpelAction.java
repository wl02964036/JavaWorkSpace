package tw.leonchen.action;

import java.util.ArrayList;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import tw.leonchen.model.TruckBean;

public class DemoSpelAction {

	public static void main(String[] args) {

		ExpressionParser parser = new SpelExpressionParser();
		Expression express = parser.parseExpression("'hola' + ' amigo'");
		String result = express.getValue().toString();
		System.out.println("result: " + result);
		
		System.out.println("--------------------------------------");
		
		EvaluationContext ctx = new StandardEvaluationContext();
		
		TruckBean truck1 = new TruckBean(1001, "ferrari");
		TruckBean truck2 = new TruckBean(1002, "ford");
		
		ArrayList<TruckBean> trucks = new ArrayList<TruckBean>();
		trucks.add(truck1);
		trucks.add(truck2);
		
		ctx.setVariable("trucks", trucks);
		
		String brand1 = parser.parseExpression("#trucks[0].brand").getValue(ctx, String.class);
		System.out.println("brand: " + brand1);
		
		String brand2 = parser.parseExpression("#trucks[1].brand").getValue(ctx, String.class);
		System.out.println("brand: " + brand2);
	}

}
