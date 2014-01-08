package com.michir.projects.facture.backoffice.data;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class DaysFilter {

	private static Set<Day> offDays;
	static {
		offDays = new HashSet<Day>();
		
		offDays.add(new Day(1970, Calendar.JANUARY, 1));
		offDays.add(new Day(1970, Calendar.MAY, 1));
		offDays.add(new Day(1970, Calendar.MAY, 8));
		offDays.add(new Day(1970, Calendar.JULY, 14));
		offDays.add(new Day(1970, Calendar.AUGUST, 15));
		offDays.add(new Day(1970, Calendar.NOVEMBER, 1));
		offDays.add(new Day(1970, Calendar.NOVEMBER, 11));
		offDays.add(new Day(1970, Calendar.DECEMBER, 25));
	}
	
	public void filter(Week week) {
		filter(week);
	}
	
	public void filter(Iterable<Day> days) {
		for (Day day : days) {
			if (day.isWE() || offDays.contains(day)) {
				day.setType(Type.off);
			} else {
				day.setType(Type.full);
			}
		}
	}

}
