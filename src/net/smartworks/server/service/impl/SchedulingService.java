/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 12. 20.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.impl;

import net.smartworks.server.engine.scheduling.manager.impl.SchdulingManagerImpl;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

	public void startScheduling(String name) throws Exception {
		try {
			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			sched.start();

			JobDetail jobDetail = new JobDetail(name, SchdulingManagerImpl.class);

			CronTrigger trigger = new CronTrigger(name);
			trigger.setCronExpression("* 0/2 * * * ?");

			sched.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopScheduling() throws Exception {
		try {
			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			String[] grps = sched.getJobGroupNames();
			System.out.println(grps);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//
//	public static void main(String[] args) throws Exception {
//		SchedulingService ss = new SchedulingService();
//		ss.startScheduling(SchdulingManagerImpl.class);
//	}

}