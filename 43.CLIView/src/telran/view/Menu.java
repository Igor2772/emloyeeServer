package telran.view;

public class Menu
{
	Item[] items;
	InputOutput inputOutput;

	public Menu(Item[] items, InputOutput inputOutput)
	{
		super();
		this.items = items;
		this.inputOutput = inputOutput;
	}

	public void runMenu()
	{
		while (true)
		{
			for (int i = 0; i < items.length; i++)
			{
				inputOutput.outputLine((i + 1) + ". " + items[i].displayName());
			}

			Integer res = inputOutput.inputInteger("Type item number", 1, items.length);
			if (res == null)
				return;
			
			try
			{
				items[res - 1].perform();
			} catch (Exception e)
			{
				inputOutput.outputLine(e.getMessage());
			}
			
			if (items[res - 1].isExit())
				return;

		}
	}
}
