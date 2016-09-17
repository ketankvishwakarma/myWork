package com.quartz.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.QuartzJob;

@WebListener
public class QuartzListners implements ServletContextListener{

	 Scheduler scheduler = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Context Destroyed");
        try 
        {
                scheduler.shutdown();
        } 
        catch (SchedulerException e) 
        {
                e.printStackTrace();
        }

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("Context Initialized");
         
         try {
                 // Setup the Job class and the Job group
                 JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity(
                                 "CronQuartzJob", "Group").build();

                 // Create a Trigger that fires every 5 minutes.
                 Trigger trigger = TriggerBuilder.newTrigger().withIdentity("TriggerName", "Group")
                 .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                 .build();

                 // Setup the Job and Trigger with Scheduler & schedule jobs
                 scheduler = new StdSchedulerFactory().getScheduler();
                 scheduler.start();
                 scheduler.scheduleJob(job, trigger);
         }
         catch (SchedulerException e) {
                 e.printStackTrace();
         }

	}

}
