package ordercombination;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

public class TimeUtility {

	//method to get difference in minutes between two orders
	public static int getMinutesDifference(DateTime dateTimeOne,DateTime dateTimeTwo){
		
		int minutesBetween= Minutes.minutesBetween(dateTimeOne, dateTimeTwo).getMinutes();
		int difference=Math.abs(minutesBetween);
		return difference;
	}
}
