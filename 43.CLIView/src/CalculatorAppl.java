
import telran.view.*;

public class CalculatorAppl
{
	static InputOutput inputOutput = new ConsoleInputOutput();

	public static void main(String[] args)
	{
		Item[] items = { new CalculatorItem(inputOutput), new ExitItem() };

		Menu menu = new Menu(items, inputOutput);
		menu.runMenu();
	}

}
