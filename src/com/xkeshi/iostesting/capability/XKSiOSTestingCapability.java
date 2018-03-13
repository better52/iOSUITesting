package com.xkeshi.iostesting.capability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class XKSiOSTestingCapability {
	private static final String automationNameKey = "automationName";
	private static final String platformNameKey = "platformName";
	private static final String platformVersionKey = "platformVersion";
	private static final String deviceNameKey = "devcieName";
	private static final String udidKey = "udid";
	private static final String appKey = "app";
	private static final String urlKey = "url";
	
	private String automationName = "XCUITest";
	private String platformName = "iOS";
	private String platformVersion = "11.0.0";
	private String deviceName = "iPad Air";
	private String udid = "";
	private String app = "com.xkeshi.coffee.cashier";
	private String url = "http://127.0.0.1:4723/wd/hub";
	
	public XKSiOSTestingCapability() {
		Properties properties = new Properties();
		String propertyFile = "resource" + File.separator + "config.properties";
		FileInputStream in = null;
		try {
			in = new FileInputStream(propertyFile);
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		automationName = properties.getProperty(automationNameKey, automationName);
		platformName = properties.getProperty(platformNameKey, platformName);
		platformVersion = properties.getProperty(platformVersionKey, platformVersion);
		deviceName = properties.getProperty(deviceNameKey, deviceName);
		udid = properties.getProperty(udidKey, udid);
		app = properties.getProperty(appKey, app);
		url = properties.getProperty(urlKey, url);
	}
	
	public DesiredCapabilities getCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, this.app);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, this.automationName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, this.platformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, this.platformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
		capabilities.setCapability(MobileCapabilityType.UDID, this.udid);
		
		return capabilities;
	}
	
	public String getUrl() {
		return this.url;
	}
}
