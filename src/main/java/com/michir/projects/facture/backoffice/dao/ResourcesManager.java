package com.michir.projects.facture.backoffice.dao;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import javax.xml.bind.JAXB;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.michir.projects.facture.backoffice.data.MonthCalendar;
import com.michir.projects.facture.backoffice.data.MonthEntry;

public class ResourcesManager {

	private static ResourcesManager instance;
	private Properties properties;
	
	private static final String DATA_FILENAME_FORMAT = "month-%d-%d.xml";
	private static final String JSON_FILENAME_FORMAT = "entry-%d-%d.json";
	
	public synchronized static ResourcesManager getInstance() throws Exception {
		if (instance == null) {
			instance = new ResourcesManager();
		}
		return instance;
	}
	
	private ResourcesManager() throws Exception {
		this.properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/application.properties"));
	}

	public File getDataStore() {
		File store = new File(properties.getProperty("month.store"));
		if (! store.exists()) {
			synchronized (this) {
				if (! store.exists()) {
					store.mkdirs();
				}
			}
		}
		return store;
	}
	
	public File getJsonStore() {
		File store = new File(properties.getProperty("json.store"));
		if (! store.exists()) {
			synchronized (this) {
				if (! store.exists()) {
					store.mkdirs();
				}
			}
		}
		return store;
	}
	
	public String getFilenameFor(MonthCalendar calendar) {
		return String.format(DATA_FILENAME_FORMAT, calendar.getYear(), calendar.getMonth().getMonthOfYear());
	}

	public String getFilenameFor(MonthEntry entry) {
		return String.format(JSON_FILENAME_FORMAT, entry.getYear(), entry.getMonth());
	}

	public Collection<File> listDataStore() {
		File[] files = getDataStore().listFiles(fileFilter);
		if (files == null) {
			return Collections.emptyList();
		} else {
			return Arrays.asList(files);
		}
	}

	public Collection<File> listEntries() {
		File[] files = getJsonStore().listFiles(jsonFileFilter);
		if (files == null) {
			return Collections.emptyList();
		} else {
			return Arrays.asList(files);
		}
	}
	
	public File loadFile(Integer year, Integer month) {
		File[] files = getDataStore().listFiles(new MonthYearFileFilter(year, month));
		if (files == null || files.length == 0) {
			return null;
		} else if (files.length > 1) {
			throw new IllegalArgumentException("No single result");
		} else {
			return files[0];
		}
	}
	
	public File save(MonthCalendar calendar) {
		File file = new File(getDataStore(), getFilenameFor(calendar));
		JAXB.marshal(calendar, file);
		return file;
	}

	public File save(MonthEntry entry) throws JsonGenerationException, JsonMappingException, IOException {
		File file = new File(getJsonStore(), getFilenameFor(entry));
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, entry);
		return file;
	}
	
	private FilenameFilter fileFilter = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			return name.matches("^month-\\d{4}-\\d{1,2}\\.xml$");
		}
	};

	private FilenameFilter jsonFileFilter = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			return name.matches("^entry-\\d{4}-\\d{1,2}\\.json$");
		}
	};

	private class MonthYearFileFilter implements FilenameFilter {

		private Integer year;
		private Integer month;

		public MonthYearFileFilter(Integer year, Integer month) {
			this.year = year;
			this.month = month;
		}
		
		@Override
		public boolean accept(File dir, String name) {
			return name.equals(String.format(DATA_FILENAME_FORMAT, year, month));
		}
		
	}
	
}
