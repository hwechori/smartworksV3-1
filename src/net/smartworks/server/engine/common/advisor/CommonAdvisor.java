/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class CommonAdvisor {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		
		for (int i = 0; i < joinPoint.getArgs().length; i++) {//파라미터정보
			Object obj = joinPoint.getArgs();
			System.out.println("arg " + i + " = " + obj.toString());
		}
		
		
		String signatureString = joinPoint.getSignature().toShortString();
		
		System.out.println(joinPoint.getSignature().getName());//메소드명
		
		System.out.println(signatureString + "시작");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
			
		} finally {
		
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString = "실행시간 : " + (finish - start) + "ms");
			
		}
	}
	
}
