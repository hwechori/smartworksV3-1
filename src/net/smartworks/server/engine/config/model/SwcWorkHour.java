/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 16.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwcWorkHour extends MisObject {

	public SwcWorkHour() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	protected static final String PREFIX = "Sww";

	private static Log logger = LogFactory.getLog(SwcWorkHour.class);
	private static final String NAME = CommonUtil.toName(SwcWorkHour.class, PREFIX);

	public static final String A_TYPE = "type";//타입
	public static final String A_STARTDAYOFWEEK = "startDayOfWeek";//주시작요일
	public static final String A_WORKINGDAYS = "workingDays";//주근무일수
	public static final String A_VALIDFROMDATE = "validFromDate";//적용시작일
	public static final String A_VALIDTODATE = "validToDate";//적용종료일
	
	public static final String A_SEARCHFROMDATE = "searchFromDate";
	public static final String A_SEARCHTODATE = "searchToDate";
	
	public static final String A_MONSTARTTIME = "monStartTime";
	public static final String A_MONENDTIME = "monEndTime";
	
	public static final String A_TUESTARTTIME = "tueStartTime";
	public static final String A_TUEENDTIME = "tueEndTime";
	
	public static final String A_WEDSTARTTIME = "wedStartTime";
	public static final String A_WEDENDTIME = "wedEndTime";
	
	public static final String A_THUSTARTTIME = "thuStartTime";
	public static final String A_THUENDTIME = "thuEndTime";
	
	public static final String A_FRISTARTTIME = "friStartTime";
	public static final String A_FRIENDTIME = "friEndTime";
	
	public static final String A_SATSTARTTIME = "satStartTime";
	public static final String A_SATENDTIME = "satEndTime";
	
	public static final String A_SUNSTARTTIME = "sunStartTime";
	public static final String A_SUNENDTIME = "sunEndTime";
	
	private String type;
	private String startDayOfWeek;
	private int workingDays;
	private Date validFromDate;	
	private Date validToDate;
	private Date searchFromDate;
	private Date searchToDate;
	private Date monStartTime;
	private Date monEndTime;
	private Date tueStartTime;
	private Date tueEndTime;
	private Date wedStartTime;
	private Date wedEndTime;
	private Date thuStartTime;
	private Date thuEndTime;
	private Date friStartTime;
	private Date friEndTime;
	private Date satStartTime;
	private Date satEndTime;
	private Date sunStartTime;
	private Date sunEndTime;
	
	public String toString(String name, String tab) {
		if( name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteStirng(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_STARTDAYOFWEEK, startDayOfWeek, buf);
		appendAttributeString(A_WORKINGDAYS, workingDays, buf);
		appendAttributeString(A_VALIDFROMDATE, validFromDate, buf);
		appendAttributeString(A_VALIDTODATE, validToDate, buf);
		appendAttributeString(A_SEARCHFROMDATE, searchFromDate, buf);
		appendAttributeString(A_SEARCHTODATE, searchToDate, buf);
		appendAttributeString(A_MONSTARTTIME, monStartTime, buf);
		appendAttributeString(A_MONENDTIME, monEndTime, buf);
		appendAttributeString(A_TUESTARTTIME, tueStartTime, buf);
		appendAttributeString(A_TUEENDTIME, tueEndTime, buf);
		appendAttributeString(A_WEDSTARTTIME, wedStartTime, buf);
		appendAttributeString(A_WEDENDTIME, wedEndTime, buf);
		appendAttributeString(A_THUSTARTTIME, thuStartTime, buf);
		appendAttributeString(A_THUENDTIME, thuEndTime, buf);
		appendAttributeString(A_FRISTARTTIME, friStartTime, buf);
		appendAttributeString(A_FRIENDTIME, friEndTime, buf);
		appendAttributeString(A_SATSTARTTIME, satStartTime, buf);
		appendAttributeString(A_SATENDTIME, satEndTime, buf);
		appendAttributeString(A_SUNSTARTTIME, sunStartTime, buf);
		appendAttributeString(A_SUNENDTIME, sunEndTime, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite){
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		SwcWorkHour obj = null;
		if (baseObj == null || !(baseObj instanceof SwcWorkHour))
			obj = new SwcWorkHour();
		else
			obj = (SwcWorkHour)baseObj;
		
		// 부모 attributres, elements 값 설정
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node startDayOfWeek = attrMap.getNamedItem(A_STARTDAYOFWEEK); 
			Node workingDays = attrMap.getNamedItem(A_WORKINGDAYS);
			Node validFromDate = attrMap.getNamedItem(A_VALIDFROMDATE);
			Node validToDate = attrMap.getNamedItem(A_VALIDTODATE);
			Node searchFromDate = attrMap.getNamedItem(A_SEARCHFROMDATE);
			Node searchToDate = attrMap.getNamedItem(A_SEARCHTODATE);
			Node monStartTime = attrMap.getNamedItem(A_MONSTARTTIME);
			Node monEndTime = attrMap.getNamedItem(A_MONENDTIME);
			Node tueStartTime = attrMap.getNamedItem(A_TUESTARTTIME);
			Node tueEndTime = attrMap.getNamedItem(A_TUEENDTIME);
			Node wedStartTime = attrMap.getNamedItem(A_WEDSTARTTIME);
			Node wedEndTime = attrMap.getNamedItem(A_WEDENDTIME);
			Node thuStartTime = attrMap.getNamedItem(A_THUSTARTTIME);
			Node thuEndTime = attrMap.getNamedItem(A_THUENDTIME);
			Node friStartTime = attrMap.getNamedItem(A_FRISTARTTIME);
			Node friEndTime = attrMap.getNamedItem(A_FRIENDTIME);
			Node satStartTime = attrMap.getNamedItem(A_SATSTARTTIME);
			Node satEndTime = attrMap.getNamedItem(A_SATENDTIME);
			Node sunStartTime = attrMap.getNamedItem(A_SUNSTARTTIME);
			Node sunEndTime = attrMap.getNamedItem(A_SUNENDTIME);
			if (type != null)
			obj.setType(type.getNodeValue());
			if (startDayOfWeek != null)
				obj.setStartDayOfWeek(startDayOfWeek.getNodeValue());
			if (workingDays != null)
				obj.setWorkingDays(CommonUtil.toInt(workingDays.getNodeValue()));
			if (validFromDate != null)
				obj.setValidFromDate(DateUtil.toDate(validFromDate.getNodeValue()));
			if (validToDate != null)
				obj.setValidToDate(DateUtil.toDate(validToDate.getNodeValue()));
			if (searchFromDate != null)
				obj.setSearchFromDate(DateUtil.toDate(searchFromDate.getNodeValue()));
			if (searchToDate != null)
				obj.setSearchToDate(DateUtil.toDate(searchToDate.getNodeValue()));
			if (monStartTime != null)
				obj.setMonStartTime(DateUtil.toDate(monStartTime.getNodeValue()));
			if (monEndTime != null)
				obj.setMonEndTime(DateUtil.toDate(monEndTime.getNodeValue()));
			if (tueStartTime != null)
				obj.setTueStartTime(DateUtil.toDate(tueStartTime.getNodeValue()));
			if (tueEndTime != null)
				obj.setTueEndTime(DateUtil.toDate(tueEndTime.getNodeValue()));
			if (wedStartTime != null)
				obj.setWedStartTime(DateUtil.toDate(wedStartTime.getNodeValue()));
			if (wedEndTime != null)
				obj.setWedEndTime(DateUtil.toDate(wedEndTime.getNodeValue()));
			if (thuStartTime != null)
				obj.setThuStartTime(DateUtil.toDate(thuStartTime.getNodeValue()));
			if (thuEndTime != null)
				obj.setThuEndTime(DateUtil.toDate(thuEndTime.getNodeValue()));
			if (friStartTime != null)
				obj.setFriStartTime(DateUtil.toDate(friStartTime.getNodeValue()));
			if (friEndTime != null)
				obj.setFriEndTime(DateUtil.toDate(friEndTime.getNodeValue()));
			if (satStartTime != null)
				obj.setSatStartTime(DateUtil.toDate(satStartTime.getNodeValue()));
			if (satEndTime != null)
				obj.setSatEndTime(DateUtil.toDate(satEndTime.getNodeValue()));	
			if (sunStartTime != null)
				obj.setSunStartTime(DateUtil.toDate(sunStartTime.getNodeValue()));
			if (sunEndTime != null)
				obj.setSunEndTime(DateUtil.toDate(sunEndTime.getNodeValue()));
		}
		// elements 값 설정
		return obj;
	}
	public static BaseObject toObject(String str) throws Exception {
		if (str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if (doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static SwcWorkHour[] add(SwcWorkHour[] objs, SwcWorkHour obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwcWorkHour[] newObjs = new SwcWorkHour[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwcWorkHour[] remove(SwcWorkHour[] objs, SwcWorkHour obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwcWorkHour[] newObjs = new SwcWorkHour[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwcWorkHour[] left(SwcWorkHour[] objs, SwcWorkHour obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		SwcWorkHour[] newObjs = new SwcWorkHour[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx-1];
				continue;
			} else if (i == idx-1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public static SwcWorkHour[] right(SwcWorkHour[] objs, SwcWorkHour obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		SwcWorkHour[] newObjs = new SwcWorkHour[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			} else if (i == idx+1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartDayOfWeek() {
		return startDayOfWeek;
	}
	public void setStartDayOfWeek(String startDayOfWeek) {
		this.startDayOfWeek = startDayOfWeek;
	}
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public Date getValidFromDate() {
		return validFromDate;
	}
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}
	public Date getValidToDate() {
		return validToDate;
	}
	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}
	public Date getMonStartTime() {
		return monStartTime;
	}
	public void setMonStartTime(Date monStartTime) {
		this.monStartTime = monStartTime;
	}
	public Date getMonEndTime() {
		return monEndTime;
	}
	public void setMonEndTime(Date monEndTime) {
		this.monEndTime = monEndTime;
	}
	public Date getTueStartTime() {
		return tueStartTime;
	}
	public void setTueStartTime(Date tueStartTime) {
		this.tueStartTime = tueStartTime;
	}
	public Date getTueEndTime() {
		return tueEndTime;
	}
	public void setTueEndTime(Date tueEndTime) {
		this.tueEndTime = tueEndTime;
	}
	public Date getWedStartTime() {
		return wedStartTime;
	}
	public void setWedStartTime(Date wedStartTime) {
		this.wedStartTime = wedStartTime;
	}
	public Date getWedEndTime() {
		return wedEndTime;
	}
	public void setWedEndTime(Date wedEndTime) {
		this.wedEndTime = wedEndTime;
	}
	public Date getThuStartTime() {
		return thuStartTime;
	}
	public void setThuStartTime(Date thuStartTime) {
		this.thuStartTime = thuStartTime;
	}
	public Date getThuEndTime() {
		return thuEndTime;
	}
	public void setThuEndTime(Date thuEndTime) {
		this.thuEndTime = thuEndTime;
	}
	public Date getFriStartTime() {
		return friStartTime;
	}
	public void setFriStartTime(Date friStartTime) {
		this.friStartTime = friStartTime;
	}
	public Date getFriEndTime() {
		return friEndTime;
	}
	public void setFriEndTime(Date friEndTime) {
		this.friEndTime = friEndTime;
	}
	public Date getSatStartTime() {
		return satStartTime;
	}
	public void setSatStartTime(Date satStartTime) {
		this.satStartTime = satStartTime;
	}
	public Date getSatEndTime() {
		return satEndTime;
	}
	public void setSatEndTime(Date satEndTime) {
		this.satEndTime = satEndTime;
	}
	public Date getSunStartTime() {
		return sunStartTime;
	}
	public void setSunStartTime(Date sunStartTime) {
		this.sunStartTime = sunStartTime;
	}
	public Date getSunEndTime() {
		return sunEndTime;
	}
	public void setSunEndTime(Date sunEndTime) {
		this.sunEndTime = sunEndTime;
	}
	public Date getSearchFromDate() {
		return searchFromDate;
	}
	public void setSearchFromDate(Date searchFromDate) {
		this.searchFromDate = searchFromDate;
	}
	public Date getSearchToDate() {
		return searchToDate;
	}
	public void setSearchToDate(Date searchToDate) {
		this.searchToDate = searchToDate;
	}

}