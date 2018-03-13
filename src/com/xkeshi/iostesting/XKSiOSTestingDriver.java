package com.xkeshi.iostesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.xkeshi.iostesting.capability.XKSiOSTestingCapability;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class XKSiOSTestingDriver {
	private IOSDriver<IOSElement> driver = null;
	
	private XKSiOSTestingDriver() {
		XKSiOSTestingCapability iosCapability = new XKSiOSTestingCapability();
		DesiredCapabilities capability = iosCapability.getCapabilities();
		
		try {
			driver = new IOSDriver<IOSElement>(new URL(iosCapability.getUrl()), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	private static class XKSDriverLoader {
		private static final XKSiOSTestingDriver instance = new XKSiOSTestingDriver();
	}
	
	public static final XKSiOSTestingDriver getInstance() {
		return XKSDriverLoader.instance;
	}
	
	public IOSDriver<IOSElement> getDriver() {
		return this.driver;
	}
}
