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
 * @author zhangtao
 * 虚拟号段可以登录
 */
public class XKSMemberTest extends XKSiOSTest {

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
		logger.info("虚拟号段查询用例执行开始");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("进入会员模块");
		
		// 输入25924161135
		String input = "25924161135";
		XKSMemberTestingHelper.setMemberPhoneNo(driver, input);
		logger.trace("输入虚拟手机号");
		
		IOSElement searchButton = driver.findElementByAccessibilityId("查询");
		logger.trace("查找查询按钮");
		searchButton.click();
		
		IOSElement modifyPwdButton = driver.findElementByAccessibilityId("修改支付密码");
		logger.trace("查找修改支付密码按钮");
		assertTrue(modifyPwdButton != null);
		
		logger.info("虚拟号段查询用例执行完毕");
		
	}

}
