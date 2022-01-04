package telran.view;

public interface Item
{
	String displayName();

	void perform();

	default boolean isExit()
	{
		return false;
	}
}
