package cn.com.scitc.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2021/10/23 15:35
 * @Description:
 */
@Service
public class AsyncService {
    @Async
    public void test() {
        try {
            // 线程睡眠3秒，模拟邮件发送过程
            System.out.println("邮件发送中");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("邮件发送完成");
    }
}
