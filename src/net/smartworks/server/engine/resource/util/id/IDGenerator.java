package net.smartworks.server.engine.resource.util.id;

/**
 * 각종 (프로세스, 액티비티 ...) 등의 Id를 생성하는 유틸리티 클래스
 * 
 * @author jhnam
 * @version $Id: IDGenerator.java,v 1.1 2011/11/08 03:15:05 kmyu Exp $
 */
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
