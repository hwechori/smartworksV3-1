/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util.id;

public class IDCreator {

	/**
	 * prefix를 앞에 붙인 후 아이디를 생성한다.
	 * 
	 * @param prefix
	 * @return
	 */
	public static String createId(String prefix) {
		return prefix + "_" + UUID.randomUUID().toStringWithoutDash();
	}
	public static String createShortId(String prefix) {
		return prefix + "_" + IDGenerator.getInstanceId();
	}
}
