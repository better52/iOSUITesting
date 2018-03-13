/**
 * 
 */
package com.xkeshi.iostesting.cashier.member;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xkeshi.iostesting.XKSiOSTest;
import com.xkeshi.iostesting.util.XKSCashierTestingHelper;

import io.appium.java_client.ios.IOSElement;

/**
 * @author huyang
 * @see HY_023, HY_024, HY_025, HY_026
 *
 */
public class XKSMemberInvalidSearchTest extends XKSiOSTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		XKSCashierTestingHelper.login(driver);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		XKSCashierTestingHelper.logout(driver);
	}

	@Test
	public void test() {
		logger.info("HY_023, HY_024, HY_025, HY_026用例执行开始");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("进入会员模块 ");
		
		/*
		 * 测试用例HY_023
		 */
		logger.info("HY_023用例执行开始");
		
		String phoneNumber = "18356969629";
		XKSMemberTestingHelper.setMemberPhoneNo(driver, phoneNumber);
		logger.trace("输入测试手机号");
		
		IOSElement searchButton = driver.findElementByAccessibilityId("查询");
		logger.trace("查找查询按钮");
		searchButton.click();
		
		IOSElement alertTitle = driver.findElementByAccessibilityId("会员不存在，是否注册？");
		logger.trace("查找提示框");
		assertTrue(alertTitle != null);
		
		IOSElement cancelButton = driver.findElementByAccessibilityId("取消");
		logger.trace("查找取消按钮");
		cancelButton.click();
		
		boolean isDisplayed = XKSCashierTestingHelper.isElementDisplayed(alertTitle);
		logger.trace("查看提示框是否还显示");
		assertFalse(isDisplayed);

		// 获取清空按钮
		IOSElement searchTopElement = XKSMemberTestingHelper.findMemberSearchTopElement(driver);
		IOSElement clearButton = (IOSElement) searchTopElement.findElementByXPath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton");
		logger.trace("查找清空按钮");
		clearButton.click();
		
		logger.info("HY_023测试用例执行完毕");
		
		/*
		 * 测试用例HY_024
		 */
		logger.info("HY_024用例执行开始");
		
		phoneNumber = "12345678912";
		XKSMemberTestingHelper.setMemberPhoneNo(driver, phoneNumber);
		logger.trace("输入测试手机号");
		searchButton.click();
		
		alertTitle = driver.findElementByAccessibilityId("会员不存在，是否注册？");
		logger.trace("查找提示框");
		assertTrue(alertTitle != null);
		
		cancelButton = driver.findElementByAccessibilityId("取消");
		logger.trace("查找取消按钮");
		cancelButton.click();
		clearButton.click();

		logger.info("HY_024测试用例执行完毕");
		
		/*
		 * 测试用例HY_025
		 */
		logger.info("HY_025用例执行开始");
		
		phoneNumber = "123";
		XKSMemberTestingHelper.setMemberPhoneNo(driver, phoneNumber);
		logger.trace("输入测试手机号");
		searchButton.click();
		
		alertTitle = driver.findElementByAccessibilityId("手机号位数不正确！");
		logger.trace("查找提示框");
		assertTrue(alertTitle != null);
		
		IOSElement okButton = driver.findElementByAccessibilityId("确定");
		logger.trace("查找确定按钮");
		okButton.click();
		clearButton.click();
		
		logger.info("HY_025测试用例执行完毕");
		
		/*
		 * 测试用例HY_026
		 */
		logger.info("HY_026用例执行开始");
		
		searchButton.click();
		
		alertTitle = driver.findElementByAccessibilityId("请输入手机号码");
		logger.trace("查找提示框");
		assertTrue(alertTitle != null);
		
		okButton = driver.findElementByAccessibilityId("确定");
		logger.trace("查找确定按钮");
		okButton.click();
		
		logger.info("HY_026测试用例执行完毕");
		
		logger.info("HY_023, HY_024, HY_025, HY_026用例执行完毕");
	}

}
