package net.smartworks.model.calendar;

import java.util.Calendar;
import java.util.Date;

import net.smartworks.model.BaseObject;
import net.smartworks.util.LocalDate;

public class WorkHourPolicy extends BaseObject{

	public final static WorkHour[] DEFAULT_WORKHOURS = new WorkHour[]{
							new WorkHour(0, 0, 0),
							new WorkHour(9*LocalDate.ONE_HOUR, 18*LocalDate.ONE_HOUR, 9*LocalDate.ONE_HOUR),
							new WorkHour(9*LocalDate.ONE_HOUR, 18*LocalDate.ONE_HOUR, 9*LocalDate.ONE_HOUR),
							new WorkHour(9*LocalDate.ONE_HOUR, 18*LocalDate.ONE_HOUR, 9*LocalDate.ONE_HOUR),
							new WorkHour(9*LocalDate.ONE_HOUR, 18*LocalDate.ONE_HOUR, 9*LocalDate.ONE_HOUR),
							new WorkHour(9*LocalDate.ONE_HOUR, 18*LocalDate.ONE_HOUR, 9*LocalDate.ONE_HOUR),
							new WorkHour(0, 0, 0)};		

	private int firstDayOfWeek = Calendar.MONDAY; // Calendar.SUNDAY = 1, Calendar.MONDAY = 2,...
	private int workingDays = 5;
	private LocalDate validFrom = new LocalDate((new Date(0)).getTime()); 
	private LocalDate validTo;
	private WorkHour[] workHours = DEFAULT_WORKHOURS;
	
	public int getFirstDayOfWeek() {
		return firstDayOfWeek;
	}
	public void setFirstDayOfWeek(int firstDayOfWeek) {
		this.firstDayOfWeek = firstDayOfWeek;
	}
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public LocalDate getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}
	public LocalDate getValidTo() {
		return validTo;
	}
	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}
	public WorkHour[] getWorkHours() {
		return workHours;
	}
	public void setWorkHours(WorkHour[] workHours) {
		if(workHours == null || workHours.length < firstDayOfWeek)
			this.workHours = DEFAULT_WORKHOURS;
		this.workHours = workHours;
	}	
	public WorkHour getWorkHour(int dayOfWeek){
		if(dayOfWeek>=1 && dayOfWeek<=7)
			return workHours[dayOfWeek-1];
		return new WorkHour(0, 0, 0);
	}
	
	public WorkHourPolicy(){
		super();
	}
}
