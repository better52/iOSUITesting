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
 * @see HY_020用例
 *
 */
public class XKSMemberInputViewTest extends XKSiOSTest {

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
		logger.info("HY_020用例执行开始");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("进入会员模块");
		
		// 获取文本框
		List<IOSElement> texts = driver.findElementsByClassName("XCUIElementTypeTextField");
		IOSElement phoneNumberText = texts.get(0);
		logger.trace("获取手机号文本框");
		
		// 随机数，然后点击对应的数字
		String randomNumber = String.valueOf((int)(Math.random() * 100000));
		logger.trace("输入随机数字：" + randomNumber);
		for (char c : randomNumber.toCharArray()) {
			IOSElement keyboard = driver.findElementByAccessibilityId(String.valueOf(c));
			logger.trace("查找按钮" + c);
			keyboard.click();
		}
		
		// 检测文本框里内容是否与期望一致
		String value = phoneNumberText.getText();
		assertTrue(value.equals(randomNumber));
		
		// 获取清空按钮
		IOSElement searchTopElement = XKSMemberTestingHelper.findMemberSearchTopElement(driver);
		IOSElement clearButton = (IOSElement) searchTopElement.findElementByXPath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton");
		logger.trace("获取清空按钮");
		assertTrue(clearButton != null);
		
		// 清空输入内容
		clearButton.click();
		value = phoneNumberText.getText();
		assertTrue(value.equals("请输入手机号"));
		
		logger.info("HY_020用例执行完毕");
	}

}
