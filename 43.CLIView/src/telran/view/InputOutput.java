package telran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public interface InputOutput
{
	String inputString(String promt);

	void output(Object obj);

	default void outputLine(Object obj)
	{
		output(obj.toString() + "\n");
	}

	default <R> R inputObject(String promt, String errorPromt, Function<String, R> mapper)
	{
		while (true)
		{
			String text = inputString(promt);
			if (text == null)
				return null;
			R res = mapper.apply(text);
			if (res != null)
				return res;
			output(errorPromt + "\n");
		}
	}

	default Integer inputInteger(String promt)
	{
		return inputObject(promt, "It's not a number", s -> {
			try
			{
				Integer res = Integer.parseInt(s);
				return res;
			} catch (Exception e)
			{
				return null;
			}
		});
	}

	
	default Integer inputInteger(String promt, Integer min, Integer max)
	{
		return inputObject(promt, String.format("It's not a number in range [%d - %d]", min, max), s -> {
			try
			{
				Integer res = Integer.parseInt(s);
				return res >= min && res <= max ? res : null;
			} catch (Exception e)
			{
				return null;
			}
		});
	}

	default String inputString(String promt, List<String> options)
	{
		return inputObject(promt, "String not in option", s -> options.contains(s) ? s : null);
	}

	default LocalDate inputDate(String promt, String format)
	{
		return inputObject(promt, "Date not int format: " + format, s -> {
			try
			{
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
				return LocalDate.parse(s, dtf);
			} catch (Exception e)
			{
				return null;
			}
		});
	}
	
	default Double inputDouble(String promt)
	{
		return inputObject(promt, "It's not a number", s -> {
			try
			{
				Double res = Double.parseDouble(s);
				return res;
			} catch (Exception e)
			{
				return null;
			}
		});
	}

	default Long inputLong(String promt)
	{
		return inputObject(promt, "It's not a number", s -> {
			try
			{
				Long res = Long.parseLong(s);
				return res;
			} catch (Exception e)
			{
				return null;
			}
		});
	}

}
