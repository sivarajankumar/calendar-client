package com.michir.projects.facture.backoffice.dao;

import java.io.File;
import java.util.Properties;

public class ResourcesManager {

	private static ResourcesManager instance;
	private Properties properties;
	
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
	
}
