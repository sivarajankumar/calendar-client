package com.michir.projects.facture.tests;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.michir.projects.facture.backoffice.data.Day;
import com.michir.projects.facture.backoffice.data.DaysFilter;

public class DaysFilterTest {

	@Test
	public void offDay() {

		Day day1 = new Day(2014, Calendar.MAY, 1);
		Day day2 = new Day(2014, Calendar.JULY, 14);
		Day day3 = new Day(2014, Calendar.AUGUST, 15);
		Day day4 = new Day(2014, Calendar.NOVEMBER, 1);
		Day day5 = new Day(2014, Calendar.NOVEMBER, 11);

		List<Day> days = Arrays.asList(day1, day2, day3, day4, day5);
		new DaysFilter().filter(days);

		for (Day day : days) {
			System.out.println(day.getDayOfYear()+"<>"+day.hashCode());
			Assert.assertEquals(Day.Type.off, day.getType());
		}
	}

}
