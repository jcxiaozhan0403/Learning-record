package com.jc;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author John.Cena
 * @date 2023/7/18 16:16
 * @Description:
 */
public class Demo {
//    public static void main(String[] args) {
//        try {
//            //拉取配置
//            String serverAddr = "localhost:8848";
//            String dataId = "test";
//            String group = "DEFAULT_GROUP";
//            Properties properties = new Properties();
//            properties.put("serverAddr", serverAddr);
//            ConfigService configService = NacosFactory.createConfigService(properties);
//            String content = configService.getConfig(dataId, group, 5000);
//            System.out.println(content);
//
//            //监听配置
//            configService.addListener(dataId, group, new Listener() {
//                @Override
//                public void receiveConfigInfo(String configInfo) {
//                    System.out.println("recieve1:" + configInfo);
//                }
//                @Override
//                public Executor getExecutor() {
//                    return null;
//                }
//            });
//
//            //程序阻塞
//            System.in.read();
//
//        } catch (NacosException | IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
