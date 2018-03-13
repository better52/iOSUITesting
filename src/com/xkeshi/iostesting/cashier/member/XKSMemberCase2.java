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
 * @author zhangtao
 * 测试虚拟号段无法注册
 */

public class XKSMemberCase2 extends XKSiOSTest {

	@Before
	public void setUp() throws Exception {
		XKSCashierTestingHelper.login(driver);
	}

	@After
	public void tearDown() throws Exception {
		XKSCashierTestingHelper.logout(driver);
	}

	@Test
	public void test() {
		logger.info("ZT_002用例执行开始");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("进入会员模块");
		
		IOSElement registerButton = driver.findElementByAccessibilityId("注册新会员");
		logger.trace("获取注册新会员按钮");
		registerButton.click();
		
		List<IOSElement> cells = driver.findElementsByClassName("XCUIElementTypeCell");
		logger.trace("获取注册页面的所有列表单元，单元格数量为" + cells.size());
		
		// 手机号输入虚拟号段
		IOSElement phoneNumberCell = cells.get(0);
		IOSElement phoneNumberText = (IOSElement)phoneNumberCell.findElementByClassName("XCUIElementTypeTextField");
		logger.trace("获取手机号输入框");
		phoneNumberText.sendKeys("25924161135");
		boolean contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(phoneNumberCell, "EnableTouch");
		logger.trace("手机号输入框后是否包含清除按钮");
		assertTrue(contains);
		driver.hideKeyboard();
		
		// 会员姓名
		IOSElement memberNameCell = cells.get(1);
		IOSElement memberNameText = (IOSElement)memberNameCell.findElementByClassName("XCUIElementTypeTextField");
		logger.trace("获取会员姓名输入框");
		memberNameText.sendKeys("123");
		contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(memberNameCell, "EnableTouch");
		logger.trace("会员姓名输入框后是否包含清除按钮");
		assertTrue(contains);
		driver.hideKeyboard();
		
		// 昵称
		IOSElement nickNameCell = cells.get(6);
		IOSElement nickNameText = (IOSElement)nickNameCell.findElementByClassName("XCUIElementTypeTextField");
		logger.trace("获取昵称输入框");
		nickNameText.sendKeys("123");
		contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(nickNameCell, "EnableTouch");
		logger.trace("昵称输入框后是否包含清除按钮");
		assertTrue(contains);
		driver.hideKeyboard();
		
		for (int i = 7; i < cells.size(); i++) {
			IOSElement cell = cells.get(i);
			logger.trace("获取第" + i +"个单元格");
			// 查询是否包含按钮，有按钮的场景是存在单选框
			boolean containsButton = XKSCashierTestingHelper.containsElementUsingXPath(cell, "//XCUIElementTypeOther/XCUIElementTypeButton");
			logger.trace("单元格是否包含按钮控件：" + containsButton);
			if (containsButton) {
				continue;
			}
			
			// 查询是否包含箭头，有箭头的场景是存在日期选择框或者其他滚轮式选择框
			boolean containsArrow = XKSCashierTestingHelper.containsElementUsingAccessibilityId(cell, "//XCUIElementTypeOther/XCUIElementTypeImage");
			logger.trace("单元格是否包含箭头：" + containsArrow);
			if (containsArrow) {
				continue;
			}
			
			IOSElement text = (IOSElement)cell.findElementByClassName("XCUIElementTypeTextField");
			logger.trace("获取单元格内文本输入框");
			text.sendKeys("123");
			contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(cell, "EnableTouch");
			logger.trace("输入框后是否包含清除按钮");
			assertTrue(contains);
			driver.hideKeyboard();
			logger.trace("第" + i + "个单元格执行结束");
		}
		
		IOSElement searchButton = driver.findElementByAccessibilityId("注册");
		logger.trace("进行虚拟号段会员注册");
		searchButton.click();
		
		IOSElement modifyPwdButton = driver.findElementByAccessibilityId("注册");
		logger.trace("查找页面是否有注册按钮");
		assertTrue(modifyPwdButton != null);
		
		logger.info("ZT_002用例执行完毕");
	}

}
