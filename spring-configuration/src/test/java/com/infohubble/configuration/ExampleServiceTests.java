package com.infohubble.configuration;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.infohubble.configuration.ExampleService;
import junit.framework.TestCase;

public class ExampleServiceTests extends TestCase {

	// under test
	private ExampleService service;

	@Before
	public void setUp() {
		service = new ExampleService();
		Properties props = new Properties();
		props.put("message", "Hello world!");
		service.setProps(props);
	}

	@Test
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", service.getMessage());
	}

}
