package com.item.study.service;

import com.item.study.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 设备服务
 */
@Service
public class TimerService {
    @Autowired
    TokenMapper tokenMapper;

    /**
     * 每日凌晨0点，重置一次过期token
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void onResetTokens() {
        System.out.println("------> reset token 0");
    }

    /**
     * 整分执行一次
     */
//    @Scheduled(cron = "0 * * * * ?")
//    public void taskMinuteHandler() {
//        System.out.println("------> minute handler");
//    }

    /**
     * 每隔5分钟执行一次
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void taskMinuteHandler5() {
        System.out.println("------> minute handler 5");
    }

    /**
     * 每隔20分钟执行一次
     */
    @Scheduled(cron = "0 0/20 * * * ?")
    public void taskMinuteHandler20() {
        System.out.println("------> minute handler 20");
    }

    /**
     * 整点执行一次
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void taskHourHandler() {
        System.out.println("------> hour handler");
    }

    /**
     * 每隔1小时执行一次
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void taskHourHandler1() {
        System.out.println("------> hour handler 1");
    }

    /**
     * 每隔6小时执行一次
     */
    @Scheduled(cron = "0 0 0/6 * * ?")
    public void taskHourHandler6() {
        System.out.println("------> hour handler 6");
    }
}
