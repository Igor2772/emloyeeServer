package telran.view;

public class SubMenuItem implements Item
{
	String displayedName;
	InputOutput inputOutput;
	Item[] items;

	public SubMenuItem(String displayedName, InputOutput inputOutput, Item[] items)
	{
		super();
		this.displayedName = displayedName;
		this.inputOutput = inputOutput;
		this.items = items;
	}

	@Override
	public String displayName()
	{
		return displayedName;
	}

	@Override
	public void perform()
	{
		Menu menu = new Menu(items, inputOutput);
		menu.runMenu();
	}
}
