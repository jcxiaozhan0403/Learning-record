package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2023/7/20 10:58
 * @Description:
 */
@Component
@RefreshScope
public class CommonConfig {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int nage;

    public String getName() {
        return name;
    }

    public int getNage() {
        return nage;
    }
}
