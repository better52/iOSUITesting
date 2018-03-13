package com.xkeshi.iostesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class XKSiOSTest {
	protected IOSDriver<IOSElement> driver = XKSiOSTestingDriver.getInstance().getDriver();
	protected Logger logger = this.getLogger();
	
	private Logger getLogger() {
		System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY, "resource/log4j2.xml");
    	return LogManager.getLogger(this.getClass());
	}
}
