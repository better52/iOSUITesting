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
 * ����Ŷο��Ե�¼
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
		logger.info("����Ŷβ�ѯ����ִ�п�ʼ");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("�����Աģ��");
		
		// ����25924161135
		String input = "25924161135";
		XKSMemberTestingHelper.setMemberPhoneNo(driver, input);
		logger.trace("���������ֻ���");
		
		IOSElement searchButton = driver.findElementByAccessibilityId("��ѯ");
		logger.trace("���Ҳ�ѯ��ť");
		searchButton.click();
		
		IOSElement modifyPwdButton = driver.findElementByAccessibilityId("�޸�֧������");
		logger.trace("�����޸�֧�����밴ť");
		assertTrue(modifyPwdButton != null);
		
		logger.info("����Ŷβ�ѯ����ִ�����");
		
	}

}
