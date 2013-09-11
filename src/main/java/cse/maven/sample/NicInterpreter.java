package cse.maven.sample;
import java.util.Calendar;
import cse.maven.exception.*;

public class NicInterpreter {
	private Initializing init;

	public Initializing getDetails(String nic) throws InvalidNicException {
		if (init == null) {
			init = new Initializing();
		}

		if (nic == null || nic.length() != 10) {
			throw new InvalidNicException(nic);
		}

		String gender = "Male";

		int year = 1900 + Integer.parseInt(nic.substring(0, 2));

		String days = nic.substring(2, 5);

		int days1 = Integer.parseInt(days);

		if (days1 > 500) {
			days1 = days1 - 500;
			gender = "Female";
		}

		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.DAY_OF_YEAR, days1);
		int month = calender.get(Calendar.MONTH) + 1;
		int mydate = calender.get(Calendar.DATE) - 1;
		
		int currentyear =  Calendar.getInstance().get(Calendar.YEAR);
		int currentmonth = Calendar.getInstance().get(Calendar.MONTH);
		int currentday = Calendar.getInstance().get(Calendar.DATE);
		if (year <= currentyear - 18)	{
			if (year == currentyear - 18)	{
				if (month > currentmonth)	{
					init.isVoter(false);
				}
				else if (month == currentmonth)	{
					if (mydate <= currentday )	
						init.isVoter(true);
					else
						init.isVoter(false);
				}
				else
					init.isVoter(true);
			}
			else
				init.isVoter(true);
		}
		else
			init.isVoter(false);
		init.setNicNumber(nic);
		init.setYear(year);
		init.setMonth(month);
		init.setDate(mydate);
		init.setGender(gender);
		return init;
	}
}
