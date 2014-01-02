package com.michir.projects.facture.backoffice.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Month implements Iterable<Week> {

	private List<Week> weeks;
	
	private Integer monthOfYear;
	
	public Month(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		monthOfYear = calendar.get(Calendar.MONTH);

		int weekStart = 1;
		this.weeks = new ArrayList<Week>(6);
		while (calendar.get(Calendar.MONTH) == month) {
			Week week = new Week(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), weekStart);
			weeks.add(week);
			weekStart++;
			calendar.add(Calendar.DAY_OF_MONTH, week.getDays().size());
		}
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

	@Override
	public Iterator<Week> iterator() {
		return weeks.iterator();
	}

	public List<Week> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<Week> weeks) {
		this.weeks = weeks;
	}
	
	@JsonIgnore
	public List<Day> getDays() {
		List<Day> days = new ArrayList<Day>();
		for (Week week : weeks) {
			days.addAll(week.getDays());
		}
		return days;
	}
}
