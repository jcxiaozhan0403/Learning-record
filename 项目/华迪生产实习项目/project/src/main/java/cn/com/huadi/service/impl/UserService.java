package cn.com.huadi.service.impl;

import cn.com.huadi.entity.User;
import cn.com.huadi.mapper.UserMapper;
import cn.com.huadi.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuan点
 * @since 2021-11-06
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
