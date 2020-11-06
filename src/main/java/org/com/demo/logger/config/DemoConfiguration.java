package org.com.demo.logger.config;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;

public abstract class DemoConfiguration implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public abstract String getProperty(final String property);

}
