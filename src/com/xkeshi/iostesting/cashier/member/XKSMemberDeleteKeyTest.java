/**
 * 
 */
package com.xkeshi.iostesting.cashier.member;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xkeshi.iostesting.XKSiOSTest;
import com.xkeshi.iostesting.util.XKSCashierTestingHelper;

import io.appium.java_client.ios.IOSElement;

/**
 * @author huyang
 * @see HY_021
 *
 */
public class XKSMemberDeleteKeyTest extends XKSiOSTest {

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
		logger.info("HY_021用例执行开始");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("进入会员模块");
		
		// 获取文本框
		List<IOSElement> texts = driver.findElementsByClassName("XCUIElementTypeTextField");
		IOSElement phoneNumberText = texts.get(0);
		logger.trace("获取手机号文本框");
		
		// 输入1234
		String input = "1234";
		XKSMemberTestingHelper.setMemberPhoneNo(driver, input);
		logger.trace("输入手机号");
		
		IOSElement searchTopElement = XKSMemberTestingHelper.findMemberSearchTopElement(driver);
		IOSElement deleteButton = (IOSElement)searchTopElement.findElementByXPath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton[11]");
		logger.trace("获取删除按钮");
		
		deleteButton.click();
		String value = phoneNumberText.getText();
		assertTrue(value.equals("123"));
		
		deleteButton.click();
		value = phoneNumberText.getText();
		assertTrue(value.equals("12"));
		
		deleteButton.click();
		value = phoneNumberText.getText();
		assertTrue(value.equals("1"));
		
		deleteButton.click();
		value = phoneNumberText.getText();
		assertTrue(value.equals("请输入手机号"));
		
		logger.info("HY_021用例执行完毕");
	}

}
