package com.greenapex.email.scheduling.app.Jobs;

import com.greenapex.email.scheduling.app.utils.EmailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class Job2 implements Job {
    public void execute(JobExecutionContext context) {
        System.out.println("Job2 --->>> Time is " + new Date());
        EmailUtil.sendEmail("<receiver-email>","Email Testing Subject2", "Email Testing Body2");
    }
}
