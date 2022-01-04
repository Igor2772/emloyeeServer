package telran.view;

public class ExitItem implements Item
{

	@Override
	public String displayName()
	{
		return "Exit";
	}

	@Override
	public void perform()
	{

	}

	public boolean isExit()
	{
		return true;
	}

}
