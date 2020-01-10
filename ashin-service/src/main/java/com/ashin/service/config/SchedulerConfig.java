package com.ashin.service.config;/**
 * Created by Administrator on 2019/9/7.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 定时任务调度-线程池配置
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/7 11:12
 **/
@Configuration
public class SchedulerConfig {

    //任务调度线程池配置
    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(4);
        //最大核心线程数
        executor.setMaxPoolSize(10);
        //设置队列中等待被调度的任务的数量
        executor.setQueueCapacity(8);
        executor.initialize();
        return executor;
    }

    //任务调度线程池配置
    @Bean("taskDataExecutor")
    public Executor taskDataExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(20);
        //最大核心线程数
        executor.setMaxPoolSize(50);
        //设置队列中等待被调度的任务的数量
        executor.setQueueCapacity(30);
        executor.initialize();
        return executor;
    }
}


















