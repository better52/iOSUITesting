package com.xkeshi.iostesting.cashier.member;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class XKSMemberTestingHelper {
	// 切换到会员模块
	public static void switchToMember(IOSDriver<IOSElement> driver) {
		IOSElement memberButton = driver.findElementByAccessibilityId("会员");
		memberButton.click();
	}
	
	// 会员查询右侧顶级视图
	public static IOSElement findMemberSearchTopElement(IOSDriver<IOSElement> driver) {
		return driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"开发版\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");
	}
	
	// 设置会员手机号
	public static void setMemberPhoneNo(IOSDriver<IOSElement> driver, String phoneNumber) {
		for (char c : phoneNumber.toCharArray()) {
			IOSElement numberButton = driver.findElementByAccessibilityId(String.valueOf(c));
			numberButton.click();
		}
	}
}
