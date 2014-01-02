package com.michir.projects.facture.backoffice.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;


public class Day {

	private Integer dayOfMonth;

	private Boolean off = Boolean.FALSE;

	private Integer dayOfWeek;

	private Integer dayOfYear;
	
	private Calendar calendar;
	
	private String name;
	
	public Day(Calendar calendar) {
		initializeFromCalendar(calendar);
	}

	public Day(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		initializeFromCalendar(instance);
	}

	public Day(Integer year, Integer month, Integer day) {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, day);
		instance.set(Calendar.MONTH, month);
		instance.set(Calendar.YEAR, year);
		initializeFromCalendar(instance);
	}

	private void initializeFromCalendar(Calendar calendar) {
		this.calendar = calendar;
		this.dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		this.dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		this.name = new SimpleDateFormat("EEE").format(calendar.getTime());
	}
	
	/**
	 * @return the dayOfMonth
	 */
	public Integer getDayOfMonth() {
		return dayOfMonth;
	}

	/**
	 * @param dayOfMonth the dayOfMonth to set
	 */
	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	/**
	 * @return the off
	 */
	public Boolean getOff() {
		return off;
	}

	/**
	 * @param off the off to set
	 */
	public void setOff(Boolean off) {
		this.off = off;
	}

	/**
	 * @return the dayOfWeek
	 */
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the dayOfYear
	 */
	public Integer getDayOfYear() {
		return dayOfYear;
	}

	/**
	 * @param dayOfYear the dayOfYear to set
	 */
	public void setDayOfYear(Integer dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	/**
	 * @return the calendar
	 */
	@JsonIgnore
	public Calendar getCalendar() {
		return calendar;
	}
	
	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

