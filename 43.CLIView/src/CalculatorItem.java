import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BinaryOperator;

import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item
{

	InputOutput inputOutput;
	static HashMap<String, BinaryOperator<Integer>> map;
	static
	{
		map = new HashMap<>();
		map.put("+", (a, b) -> a + b);
		map.put("-", (a, b) -> a - b);
		map.put("*", (a, b) -> a * b);
		map.put("/", (a, b) -> a / b);
	}

	public CalculatorItem(InputOutput inputOutput)
	{
		super();
		this.inputOutput = inputOutput;
	}

	@Override
	public String displayName()
	{
		return "Integer numbers calculator";
	}

	@Override
	public void perform()
	{
		Integer op1 = inputOutput.inputInteger("Enter first number");
		if (op1 == null)
			return;

		Integer op2 = inputOutput.inputInteger("Enter second number");
		if (op2 == null)
			return;

		ArrayList<String> list = new ArrayList<>(map.keySet());
		String operator = inputOutput.inputString("Enter operator " + map.keySet(), list);
		if (operator == null)
			return;

		inputOutput.output(map.get(operator).apply(op1, op2));

	}

}
