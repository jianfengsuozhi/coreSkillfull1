package com.web.TaskTest;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by weideliang on 2016/10/11.
 */
public class TestTask01 extends QuartzJobBean{
    private int timeout;
    private static int i = 0;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时任务执行中......");
    }
}
