package net.smartworks.model.calendar;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.Community;
import net.smartworks.util.LocalDate;

public class CompanyEvent extends BaseObject {

	public static final String EVENT_TYPE_HOLIDAY = "1";
	public static final String EVENT_TYPE_EVENTDAY = "2";

	private Boolean 		isHoliday;
	private Community[]		relatedUsers;
	private LocalDate		plannedStart;
	private LocalDate		plannedEnd;

	public Boolean getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public Community[] getRelatedUsers() {
		return relatedUsers;
	}
	public void setRelatedUsers(Community[] relatedUsers) {
		this.relatedUsers = relatedUsers;
	}
	public LocalDate getPlannedStart() {
		return plannedStart;
	}
	public void setPlannedStart(LocalDate plannedStart) {
		this.plannedStart = plannedStart;
	}
	public LocalDate getPlannedEnd() {
		return plannedEnd;
	}
	public void setPlannedEnd(LocalDate plannedEnd) {
		this.plannedEnd = plannedEnd;
	}

	public CompanyEvent(){
		super();
	}

	public CompanyEvent(String id, String name){
		super(id, name);
	}
}