package com.michir.projects.facture.backoffice.data;


public class MonthCalendar {

	private Month month;

	private Integer year;

	public MonthCalendar(Integer year, Integer month) {
		this.month = new Month(year, month);
		this.year = year;
		new DaysFilter().filter(this.month.getDays());
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
