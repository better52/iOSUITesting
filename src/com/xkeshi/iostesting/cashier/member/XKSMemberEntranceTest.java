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

/**
 * @author huyang
 * @see HY_001用例
 *
 */
public class XKSMemberEntranceTest extends XKSiOSTest {
	
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
		logger.info("HY_001用例执行开始");
		
		XKSMemberTestingHelper.switchToMember(driver);
		
		logger.trace("进入会员模块");
		
		boolean contains = XKSCashierTestingHelper.containsElementUsingAccessibilityId(driver, "会员查询");
		logger.trace("查询会员查询按钮是否存在");
		assertTrue(contains);
		
		logger.info("HY_001用例执行完毕");
	}
}
