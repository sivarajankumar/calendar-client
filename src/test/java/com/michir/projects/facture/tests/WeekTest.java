package com.michir.projects.facture.tests;

import org.junit.Assert;
import org.junit.Test;

import com.michir.projects.facture.backoffice.data.Week;

public class WeekTest {

	@Test
	public void getDays() {
		Week week = new Week(2013, 10, 2);
		Assert.assertEquals(7, week.getDays().size());
	}
	
	@Test
	public void getDaysWeek1() {
		Week week = new Week(2013, 10, 1);
		Assert.assertEquals(3, week.getDays().size());
	}
	
}
