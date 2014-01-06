package com.michir.projects.facture.backoffice.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Days {
	
	@XmlElement
	private List<Day> days;

	/**
	 * @return the days
	 */
	public List<Day> getDays() {
		if (days == null) {
			days = new ArrayList<Day>();
		}
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(List<Day> days) {
		this.days = days;
	}
	
}
