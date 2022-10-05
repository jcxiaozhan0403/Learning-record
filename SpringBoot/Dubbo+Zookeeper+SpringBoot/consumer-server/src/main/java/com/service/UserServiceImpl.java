package com.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2022/10/5 18:30
 * @Description:
 */
@Service
public class UserServiceImpl {
    @DubboReference
    TicketService ticketService;

    public String bugTicket(){
        return ticketService.getTicket();
    }
}
