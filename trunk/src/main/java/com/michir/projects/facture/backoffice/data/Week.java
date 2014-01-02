package com.michir.projects.facture.backoffice.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Week implements Iterable<Day> {

	private List<Day> days;
	
	private Integer weekOfMonth;
	
	private Integer weekOfYear;
	
	public Week(Integer year, Integer month, Integer week) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		// position to the week number
		int weekNbr = 1;
		while (weekNbr != week) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				weekNbr++;
			}
			continue;
		}
		// week = weekNbr
		weekOfMonth = week;
		weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

		days = new ArrayList<Day>(7);
		while (weekNbr == week) {
			Day day = new Day(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
			days.add(day);

			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if (calendar.get(Calendar.MONTH) != month) {
				break;
			}
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				weekNbr++;
			}
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

	@Override
	public Iterator<Day> iterator() {
		return days.iterator();
	}

	public Integer getWeekOfMonth() {
		return weekOfMonth;
	}

	public void setWeekOfMonth(Integer weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	public Integer getWeekOfYear() {
		return weekOfYear;
	}

	public void setWeekOfYear(Integer weekOfYear) {
		this.weekOfYear = weekOfYear;
	}
}
