package net.smartworks.model.calendar;

import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class CompanyCalendar {
	
	private LocalDate date;
	private CompanyEvent[] companyEvents;
	private WorkHour workHour;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public CompanyEvent[] getCompanyEvents() {
		return companyEvents;
	}
	public void setCompanyEvents(CompanyEvent[] companyEvents) {
		this.companyEvents = companyEvents;
	}
	public WorkHour getWorkHour() {
		return workHour;
	}
	public void setWorkHour(WorkHour workHour) {
		this.workHour = workHour;
	}
	
	public CompanyCalendar(){
		super();
	}
	
	public CompanyCalendar(LocalDate date, CompanyEvent[] companyEvents, WorkHour workHour){
		super();
		this.date = date;
		this.companyEvents = companyEvents;
		this.workHour = workHour;
	}

	public boolean isHoliday(){
		if(companyEvents==null) return false;
		for(CompanyEvent ce : companyEvents){
			if(ce.isHoliday()) return true;
		}
		return false;
	}
	
	public String toCompanyEventsString(){
		String eventsString = "";
		if(!SmartUtil.isBlankObject(this.companyEvents)){
			for(int i=0; i<this.companyEvents.length; i++){
				if(i==0) eventsString = eventsString+"(";
				eventsString = eventsString + this.companyEvents[i].getName();
				if(i==this.companyEvents.length-1) eventsString = eventsString + ")";
				else eventsString = eventsString + ", ";
			}
		}
		return eventsString;
	}
}
