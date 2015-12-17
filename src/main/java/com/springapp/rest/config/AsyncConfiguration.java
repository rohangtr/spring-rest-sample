package com.springapp.rest.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Rohan Kushwaha
 *
 */

@Configuration
@EnableAsync
@PropertySource("classpath:config.properties")
public class AsyncConfiguration implements AsyncConfigurer {
	
	@Autowired
	Environment env;
	
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(Utilities.getIntValue(env.getProperty("async.poolSze")));
        taskExecutor.setMaxPoolSize(Utilities.getIntValue(env.getProperty("async.maxPoolSze")));
        taskExecutor.setQueueCapacity(Utilities.getIntValue(env.getProperty("async.qCapacity")));
        taskExecutor.initialize();
        return taskExecutor;
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}
