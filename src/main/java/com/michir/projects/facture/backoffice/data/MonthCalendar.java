package com.michir.projects.facture.backoffice.data;

import java.util.Calendar;

public class MonthCalendar {

	private Month month;
	
	private Integer year;
	
	public MonthCalendar(Integer year, Integer month) {
		this.month = new Month(year, month);
		this.year = year;
		for (Day day : this.month.getDays()) {
			day.setOff(Boolean.FALSE);
			if ((day.getCalendar().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.MAY) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 1)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.MAY) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 8)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.AUGUST) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 15)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.DECEMBER) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 25)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.JANUARY) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 1)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.JULY) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 14)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.NOVEMBER) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 1)) {
				day.setOff(Boolean.TRUE);
			}
			if ((day.getCalendar().get(Calendar.MONTH) == Calendar.NOVEMBER) && (day.getCalendar().get(Calendar.DAY_OF_MONTH) == 11)) {
				day.setOff(Boolean.TRUE);
			}
		}
	}

	/**
	 * @return the month
	 */
	public Month getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(Month month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
}
