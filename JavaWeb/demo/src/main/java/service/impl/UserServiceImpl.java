package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.User;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 * @author John.Cena
 * @date 2022/8/27 17:45
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
