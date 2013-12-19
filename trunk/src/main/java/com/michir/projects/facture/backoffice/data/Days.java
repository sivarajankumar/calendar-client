package com.michir.projects.facture.backoffice.data;

import java.util.ArrayList;
import java.util.List;


public class Days {
	
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
