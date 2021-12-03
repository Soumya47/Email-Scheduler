package com.greenapex.email.scheduling.app.Jobs;

import com.greenapex.email.scheduling.app.utils.EmailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class Job1 implements Job {
    public void execute(JobExecutionContext context) {
        System.out.println("Job1 --->>> Time is " + new Date());
        EmailUtil.sendEmail("<receiver-email>","Email Testing Subject1", "Email Testing Body1");
    }
}
