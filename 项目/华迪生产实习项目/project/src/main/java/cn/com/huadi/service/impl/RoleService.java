package cn.com.huadi.service.impl;

import cn.com.huadi.entity.Role;
import cn.com.huadi.mapper.RoleMapper;
import cn.com.huadi.service.IRoleService;
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
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
