package com.infohubble.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {

	@Autowired
	private Properties props;

	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return props.getProperty("message");
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}
