package com.michir.projects.facture.backoffice.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Month {

	private List<Day> days;
	
	private Integer monthOfYear;
	
	public Month(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		monthOfYear = calendar.get(Calendar.MONTH);

		days = new ArrayList<Day>(31);
		while (calendar.get(Calendar.MONTH) == month) {
			Day day = new Day(year, month, calendar.get(Calendar.DAY_OF_MONTH));
			days.add(day);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

	}

	/**
	 * @return the days
	 */
	public List<Day> getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(List<Day> days) {
		this.days = days;
	}

	/**
	 * @return the monthOfYear
	 */
	public Integer getMonthOfYear() {
		return monthOfYear;
	}

	/**
	 * @param monthOfYear the monthOfYear to set
	 */
	public void setMonthOfYear(Integer monthOfYear) {
		this.monthOfYear = monthOfYear;
	}
}
