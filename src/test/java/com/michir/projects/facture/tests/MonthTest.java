package com.michir.projects.facture.tests;

import org.junit.Assert;
import org.junit.Test;

import com.michir.projects.facture.backoffice.data.Month;

public class MonthTest {

	@Test
	public void getWeeks() {
		
		Month month = new Month(2013, 10);
		Assert.assertEquals(5, month.getWeeks().size());
		Assert.assertEquals(30, month.getDays().size());
		
	}

	@Test
	public void getWeeksOctober() {
		
		Month month = new Month(2013, 9);
		Assert.assertEquals(5, month.getWeeks().size());
		Assert.assertEquals(31, month.getDays().size());
		
	}
	@Test
	public void getWeeksDecembder() {
		
		Month month = new Month(2013, 11);
		Assert.assertEquals(6, month.getWeeks().size());
		Assert.assertEquals(31, month.getDays().size());
		
	}
	
}
