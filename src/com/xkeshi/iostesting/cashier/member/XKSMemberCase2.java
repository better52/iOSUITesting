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
 * ��������Ŷ��޷�ע��
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
		logger.info("ZT_002����ִ�п�ʼ");
		
		XKSMemberTestingHelper.switchToMember(driver);
		logger.trace("�����Աģ��");
		
		IOSElement registerButton = driver.findElementByAccessibilityId("ע���»�Ա");
		logger.trace("��ȡע���»�Ա��ť");
		registerButton.click();
		
		List<IOSElement> cells = driver.findElementsByClassName("XCUIElementTypeCell");
		logger.trace("��ȡע��ҳ��������б�Ԫ����Ԫ������Ϊ" + cells.size());
		
		// �ֻ�����������Ŷ�
		IOSElement phoneNumberCell = cells.get(0);
		IOSElement phoneNumberText = (IOSElement)phoneNumberCell.findElementByClassName("XCUIElementTypeTextField");
		logger.trace("��ȡ�ֻ��������");
		phoneNumberText.sendKeys("25924161135");
		boolean contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(phoneNumberCell, "EnableTouch");
		logger.trace("�ֻ����������Ƿ���������ť");
		assertTrue(contains);
		driver.hideKeyboard();
		
		// ��Ա����
		IOSElement memberNameCell = cells.get(1);
		IOSElement memberNameText = (IOSElement)memberNameCell.findElementByClassName("XCUIElementTypeTextField");
		logger.trace("��ȡ��Ա���������");
		memberNameText.sendKeys("123");
		contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(memberNameCell, "EnableTouch");
		logger.trace("��Ա�����������Ƿ���������ť");
		assertTrue(contains);
		driver.hideKeyboard();
		
		// �ǳ�
		IOSElement nickNameCell = cells.get(6);
		IOSElement nickNameText = (IOSElement)nickNameCell.findElementByClassName("XCUIElementTypeTextField");
		logger.trace("��ȡ�ǳ������");
		nickNameText.sendKeys("123");
		contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(nickNameCell, "EnableTouch");
		logger.trace("�ǳ��������Ƿ���������ť");
		assertTrue(contains);
		driver.hideKeyboard();
		
		for (int i = 7; i < cells.size(); i++) {
			IOSElement cell = cells.get(i);
			logger.trace("��ȡ��" + i +"����Ԫ��");
			// ��ѯ�Ƿ������ť���а�ť�ĳ����Ǵ��ڵ�ѡ��
			boolean containsButton = XKSCashierTestingHelper.containsElementUsingXPath(cell, "//XCUIElementTypeOther/XCUIElementTypeButton");
			logger.trace("��Ԫ���Ƿ������ť�ؼ���" + containsButton);
			if (containsButton) {
				continue;
			}
			
			// ��ѯ�Ƿ������ͷ���м�ͷ�ĳ����Ǵ�������ѡ��������������ʽѡ���
			boolean containsArrow = XKSCashierTestingHelper.containsElementUsingAccessibilityId(cell, "//XCUIElementTypeOther/XCUIElementTypeImage");
			logger.trace("��Ԫ���Ƿ������ͷ��" + containsArrow);
			if (containsArrow) {
				continue;
			}
			
			IOSElement text = (IOSElement)cell.findElementByClassName("XCUIElementTypeTextField");
			logger.trace("��ȡ��Ԫ�����ı������");
			text.sendKeys("123");
			contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(cell, "EnableTouch");
			logger.trace("�������Ƿ���������ť");
			assertTrue(contains);
			driver.hideKeyboard();
			logger.trace("��" + i + "����Ԫ��ִ�н���");
		}
		
		IOSElement searchButton = driver.findElementByAccessibilityId("ע��");
		logger.trace("��������Ŷλ�Աע��");
		searchButton.click();
		
		IOSElement modifyPwdButton = driver.findElementByAccessibilityId("ע��");
		logger.trace("����ҳ���Ƿ���ע�ᰴť");
		assertTrue(modifyPwdButton != null);
		
		logger.info("ZT_002����ִ�����");
	}

}
