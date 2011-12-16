/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtil {
	
	public static Map<String, Object> getMapByJsonString(String jsonString) throws Exception {
		if (CommonUtil.isEmpty(jsonString))
			return null;
		Map<String, Object> resultMap = null;
		try {
			resultMap = new ObjectMapper().readValue(jsonString, new TypeReference<Map<String, Object>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
			throw e;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return resultMap;
	}
	public static String getJsonStringByMap(Map<String, Object> map) throws Exception {
		if (CommonUtil.isEmpty(map))
			return null;
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(map); 
	}
	
}
