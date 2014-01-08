package com.michir.projects.facture.backoffice.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calender")
@XmlAccessorType(XmlAccessType.FIELD)
public class MonthCalendar {

	@XmlElement
	private Month month;

	@XmlAttribute
	private Integer year;

	public MonthCalendar() {
		// TODO Auto-generated constructor stub
	}
	
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
