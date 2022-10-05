package com.service.impl;

import com.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2022/10/5 18:19
 * @Description:
 */
@DubboService
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "拿到了一张票";
    }
}
