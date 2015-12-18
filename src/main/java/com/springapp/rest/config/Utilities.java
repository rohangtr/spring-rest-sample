package com.springapp.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {

	private static final Logger log = LoggerFactory.getLogger(Utilities.class);

	public static Integer getIntValue(String intStr) {
		try {
			return new Integer(intStr);
		} catch (NumberFormatException ex) {
			log.error(ex.getMessage());
		}
		return 1;
	}

}
