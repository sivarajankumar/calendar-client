package com.michir.projects.facture.backoffice.dao;

import java.io.File;
import java.io.FilenameFilter;

import javax.xml.bind.JAXB;

import com.michir.projects.facture.backoffice.data.MonthCalendar;

public class MonthDao {

	private static final String MONTH_FILENAME_FORMAT = "month-%d-%d.xml";

	public MonthCalendar load(final Integer year, final Integer month) throws Exception {
		File file = ResourcesManager.getInstance().getDataStore();
		File[] files = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.equals(String.format(MONTH_FILENAME_FORMAT, year, month));
			}
		});
		if (files.length == 1) {
			// load
			return JAXB.unmarshal(files[0], MonthCalendar.class);
		} else {
			return null;
		}
	}
	
	public void save(MonthCalendar calendar) throws Exception {
		File store = ResourcesManager.getInstance().getDataStore();
		File file = new File(store, String.format(MONTH_FILENAME_FORMAT, calendar.getYear(), calendar.getMonth().getMonthOfYear()));
		JAXB.marshal(calendar, file);
	}
	
}
