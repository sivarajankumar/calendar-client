package com.michir.projects.facture.backoffice.dao;

import java.io.File;
import java.util.Collection;

import javax.xml.bind.JAXB;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.michir.projects.facture.backoffice.data.MonthCalendar;
import com.michir.projects.facture.backoffice.data.MonthEntry;

public class MonthDao {

	public MonthCalendar load(final Integer year, final Integer month) throws Exception {
		File file = ResourcesManager.getInstance().loadFile(year, month);
		if (file == null) {
			return null;
		}
		return JAXB.unmarshal(file, MonthCalendar.class);
	}

	public Collection<MonthEntry> loadAll(Integer start, Integer maxResults) throws Exception {
		Collection<File> entries = ResourcesManager.getInstance().listEntries();
		return Collections2.transform(entries, new Function<File, MonthEntry>() {
			@Override
			public MonthEntry apply(File input) {
				ObjectMapper mapper = new ObjectMapper();
				try {
					return mapper.readValue(input, MonthEntry.class);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	public void save(MonthCalendar calendar) throws Exception {
		File file = ResourcesManager.getInstance().save(calendar);
		MonthEntry entry = new MonthEntry();
		entry.setFilename(file.getName());
		entry.setMonthCalendar(calendar);
		
		ResourcesManager.getInstance().save(entry);
	}
}
