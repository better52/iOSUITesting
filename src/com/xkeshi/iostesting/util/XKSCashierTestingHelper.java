package com.xkeshi.iostesting.util;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class XKSCashierTestingHelper {
	public static void login(IOSDriver<IOSElement> driver) {
		IOSElement loginButton = driver.findElementByAccessibilityId("登录");
		loginButton.click();
	}
	
	public static void logout(IOSDriver<IOSElement> driver) {
		// 到交接班页面
		IOSElement shiftButton = driver.findElementByXPath("//XCUIElementTypeButton[@name='light bg']/following::XCUIElementTypeOther[1]/XCUIElementTypeButton");
		shiftButton.click();
		
		IOSElement logoutButton = driver.findElementByAccessibilityId("直接退出");
		logoutButton.click();
	}
	
	public static boolean containsElementUsingXPath(IOSElement parent, String xpath) {
		try {
			@SuppressWarnings("unused")
			IOSElement element = (IOSElement)parent.findElementByXPath(xpath);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static boolean containsElementUsingAccessibilityId(IOSElement parent, String id) {
		try {
			@SuppressWarnings("unused")
			IOSElement element = (IOSElement)parent.findElementByAccessibilityId(id);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static boolean containsElementUsingXPath(IOSDriver<IOSElement> driver, String xpath) {
		try {
			@SuppressWarnings("unused")
			IOSElement element = driver.findElementByXPath(xpath);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static boolean containsElementUsingAccessibilityId(IOSDriver<IOSElement> driver, String id) {
		try {
			@SuppressWarnings("unused")
			IOSElement element = driver.findElementByAccessibilityId(id);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static boolean isElementDisplayed(IOSElement element) {
		try {
			boolean isDisplayed = element.isDisplayed();
			return isDisplayed;
		} catch (Exception ex) {
			return false;
		}
	}
}
