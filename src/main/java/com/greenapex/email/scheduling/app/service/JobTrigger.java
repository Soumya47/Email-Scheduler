package com.greenapex.email.scheduling.app.service;

import com.greenapex.email.scheduling.app.Exceptions.TriggerFailedException;
import com.greenapex.email.scheduling.app.Jobs.Job1;
import com.greenapex.email.scheduling.app.Jobs.Job2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class JobTrigger {

    public void trigger() {

        try{
            JobDetail job1 = JobBuilder.newJob(Job1.class)
                    .withIdentity("job1", "group1").build();

//			min hour dayofthemonth month dayoftheweek year


            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
//					.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 1/1 * ? *"))   //Daily 12:00
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);

            JobDetail job2 = JobBuilder.newJob(Job2.class)
                    .withIdentity("job2", "group2").build();


            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger2", "group2")
//					.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/45 * * * * ?")))
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 ? * MON *")) // Every monday 12:00
                    .build();

            Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
            scheduler2.start();
            scheduler2.scheduleJob(job2, trigger2);

            Thread.sleep(100000);

            scheduler1.shutdown();
            scheduler2.shutdown();
        } catch (TriggerFailedException e) {
            throw new TriggerFailedException("abc"+e);
        } catch (InterruptedException | SchedulerException e) {
            e.printStackTrace();
        }
    }
}
