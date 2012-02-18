package net.smartworks.server.engine.resource.util.id;

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
