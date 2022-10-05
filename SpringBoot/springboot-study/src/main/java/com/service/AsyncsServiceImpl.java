package com.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2022/10/5 10:39
 * @Description:
 */
@Service
public class AsyncsServiceImpl {

    @Async
    public void async(){
        try {
            // 线程睡眠3秒，模拟邮件发送过程
            Thread.sleep(3000);
            System.out.println("邮件发送成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
