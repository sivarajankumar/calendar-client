package com.michir.projects.facture.backoffice.data;

import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

public class MonthEntry {

	@JsonIgnore
	private MonthCalendar monthCalendar;

	private String filename;
	
	private Integer year;
	
	private Integer month;
	
	private Date modificationDate;

	public MonthEntry() {
		modificationDate = Calendar.getInstance().getTime();
	}
	
	/**
	 * @return the monthCalendar
	 */
	public MonthCalendar getMonthCalendar() {
		return monthCalendar;
	}

	/**
	 * @param monthCalendar the monthCalendar to set
	 */
	public void setMonthCalendar(MonthCalendar monthCalendar) {
		this.monthCalendar = monthCalendar;
		this.setYear(monthCalendar.getYear());
		this.setMonth(monthCalendar.getMonth().getMonthOfYear());
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
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

	/**
	 * @return the month
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
}
