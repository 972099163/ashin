package com.ashin.service.scheduler;//package com.debug.springboot.server.scheduler;/**
// * Created by Administrator on 2019/9/7.
// */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * spring task-定时任务调度
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/7 11:05
 **/
@Component
@EnableAsync
public class CommonScheduler {

    private static final Logger log= LoggerFactory.getLogger(CommonScheduler.class);

  /*  //定时任务1
    @Scheduled(cron = "0/5 * * * * *")
    @Async("taskExecutor")
    public void schedulerOne(){
        log.info("---执行定时任务1---");
    }

    //定时任务2
    @Scheduled(cron = "0/6 * * * * *")
    @Async("taskExecutor")
    public void schedulerTwo(){
        log.info("---执行定时任务2---");

        try {
            //模拟当前定时任务每次执行业务逻辑时需要花费的时间 3s
            Thread.sleep(3000);
        }catch (Exception e){e.printStackTrace();}
    }

    //定时任务3
    @Scheduled(cron = "0/7 * * * * *")
    @Async("taskExecutor")
    public void schedulerThree(){
        log.info("---执行定时任务3---");

        try {
            //模拟当前定时任务每次执行业务逻辑时需要花费的时间 4s
            Thread.sleep(4000);
        }catch (Exception e){e.printStackTrace();}
    }*/
}

































