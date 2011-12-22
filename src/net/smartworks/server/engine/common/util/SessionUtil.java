/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 12.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	protected HttpSession session;
	public String mb_name;
	public String mb_code;
	public String mb_grade;
	public String mb_admin;

	/**
	 * SessionDao 생성자
	 * 
	 * @param request
	 * @param response
	 */
	public SessionUtil(HttpServletRequest request, HttpServletResponse response) {
		try {
			req = request;
			res = response;
			session = req.getSession();
			mb_name = null;
			mb_code = null;
			mb_grade = null;
			mb_admin = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 세션 저장
	 * 
	 * @param key
	 * @param value
	 */
	public void setSessionValue(String key, Object value) {
		try {
			session.setAttribute(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 세션 값 반환
	 * 
	 * @param key
	 * @return
	 */
	public Object getSessionValue(String key) {
		Object obj = null;
		try {
			obj = session.getAttribute(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 세션 삭제
	 */
	public void delAllSession() {
		try {
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 세션값을 Map으로 리턴
	 * 
	 * @return
	 */
	public Map getSessionMap() {
		// StringBuffer sessionAll = null;
		Enumeration enumer = null;
		Map sessionAll = new HashMap();
		try {
			enumer = session.getAttributeNames();
			while (enumer.hasMoreElements()) {
				String key = (String) enumer.nextElement();
				sessionAll.put(key, session.getAttribute(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionAll;
	}

	/**
	 * mb_name 세션 저장
	 * 
	 * @param mb_name
	 */
	public void setMbName(String mb_name) {
		try {
			session.setAttribute("Member_Name", mb_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * mb_code 세션저장
	 * 
	 * @param mb_code
	 */
	public void setMbCode(String mb_code) {
		try {
			session.setAttribute("Member_Code", mb_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * mb_grade 세션 저장
	 * 
	 * @param mb_grade
	 */
	public void setMbGrade(String mb_grade) {
		try {
			session.setAttribute("Member_Grade", mb_grade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * mb_admin 세션 저장
	 * 
	 * @param mb_admin
	 */
	public void setMbAdmin(String mb_admin) {
		try {
			session.setAttribute("Member_Admin", mb_admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMbName() {
		Object obj = null;
		try {
			obj = session.getAttribute("Member_Name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) obj;
	}

	public String getMbCode() {
		Object obj = null;
		try {
			obj = session.getAttribute("Member_Code");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) obj;
	}

	public String getMbGrade() {
		Object obj = null;
		try {
			obj = session.getAttribute("Member_Grade");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) obj;
	}

	public String getMbAdmin() {
		Object obj = null;
		try {
			obj = session.getAttribute("Member_Admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) obj;
	}

	/**
	 * 저장 되어잇는 모든 세션값 보기
	 * 
	 * @return sessionAll
	 */
	public String viewSession() {
		StringBuffer sessionAll = new StringBuffer();
		Enumeration enumer = null;
		try {
			enumer = session.getAttributeNames();
			sessionAll.append("=================  session Start ===================");
			while (enumer.hasMoreElements()) {
				String key = (String) enumer.nextElement();
				sessionAll.append("\n " + key + " : " + (String) session.getAttribute(key));
			}
			sessionAll.append("=================  session End ===================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionAll.toString();
	}
}
