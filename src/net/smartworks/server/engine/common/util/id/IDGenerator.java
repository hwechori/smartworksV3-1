/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util.id;

public class IDGenerator {

	/**
	 * instanceLock
	 */
	private static int[] instanceLock = new int[0];
	/**
	 * 도메인테이블 sequence
	 */
	private static int seq4Instance = 0;
	/**
	 * FIXME Integer.MAX_VALUE를 넘은 후에 0으로 넘어 온 후 Id가 겹칠 확률이 높다.
	 *  
	 * @return
	 */
	public static String getInstanceId() {
		
		synchronized(instanceLock) {
			if(seq4Instance++ >= Integer.MAX_VALUE)
				seq4Instance = 0;
				
			return (System.currentTimeMillis() + seq4Instance) + "";
		}
	}

}