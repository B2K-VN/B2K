package b2k.help;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgeCalculation {

	public static final int DAY_OF_DATE = 0;
	public static final int MONTH_OF_DATE = 1;
	public static final int YEAR_OF_DATE = 2;

	/**
	 * 
	 * @param date
	 * @return trả về tuổi theo quy ước tăng 1 nếu vượt qua 1 ngày
	 */
	public static int getAgeByBirthDay(Date date) {
		if (date == null)
			return -1;

		Calendar cd = Calendar.getInstance();

		Calendar bd = Calendar.getInstance();
		bd.setTime(date);
		if (cd.before(bd))
			return -1;
		Date d = new Date(cd.getTimeInMillis());
		int day = getPartOfDate(date, "d"), month = getPartOfDate(date, "M") - 1, year = getPartOfDate(
				date, "YYYY");
		int nowday = getPartOfDate(d, "d"), nowmonth = getPartOfDate(d, "M") - 1, nowyear = getPartOfDate(
				d, "yyyy");

		int ageYears = nowyear - year, ageMonths = nowmonth - month, ageDays = nowday
				- day;

		if (ageDays < 0) {
			ageMonths = ageMonths - 1;
		}

		if (ageMonths < 0) {
			ageMonths = 12 - ageMonths;
			ageYears--;
		}

		return ageYears;
	}

	public static int getMonthByBirthDay(Date date) {
		if (date == null)
			return -1;

		Calendar cd = Calendar.getInstance();

		Calendar bd = Calendar.getInstance();
		bd.setTime(date);
		if (cd.before(bd))
			return -1;

		Date d = new Date(cd.getTimeInMillis());
		int day = getPartOfDate(date, "d"), month = getPartOfDate(date, "M") - 1, year = getPartOfDate(
				date, "YYYY");

		int nowday = getPartOfDate(d, "d"), nowmonth = getPartOfDate(d, "M") - 1, nowyear = getPartOfDate(
				d, "YYYY");

		int ageYears = nowyear - year, ageMonths = nowmonth - month, ageDays = nowday
				- day;
		if (ageDays < 0) {
			ageMonths = ageMonths - 1;
		}
		if (ageMonths < 0) {
			ageYears = ageYears - 1;
			ageMonths = 12 + ageMonths;

		}

		ageMonths += ageYears * 12;

		ageMonths = ageMonths < 0 ? -1 : ageMonths;

		return ageMonths;
	}

	public static Date getBirthDayFromAge(int age, Date compareDate) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -age * 12);

		int iday;
		int imonth;

		iday = 1;
		imonth = 1;
		int iyear = cal.get(Calendar.YEAR);

		Calendar bd = new GregorianCalendar(iyear, imonth - 1, iday);

		int ageByBirthDay = getAgeByBirthDay(new Date(bd.getTimeInMillis()));
		bd.add(Calendar.YEAR, ageByBirthDay - age);

		if (cal.before(bd)) {
			return new Date(cal.getTimeInMillis());
		}

		return new Date(bd.getTimeInMillis());
	}

	public static int getPartOfDate(Date date, String type) {

		if (date != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(type);
			String format = dateFormat.format(date);
			return Integer.parseInt(format);
		}

		return 0;
	}

}