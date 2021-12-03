package com.greenapex.email.scheduling.app;

import com.greenapex.email.scheduling.app.service.JobTrigger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSchedulingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSchedulingAppApplication.class, args);
		JobTrigger trigger = new JobTrigger();
		trigger.trigger();
	}


}
