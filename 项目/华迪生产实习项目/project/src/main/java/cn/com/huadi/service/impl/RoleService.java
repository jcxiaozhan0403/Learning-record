package cn.com.huadi.service.impl;

import cn.com.huadi.entity.Role;
import cn.com.huadi.mapper.RoleMapper;
import cn.com.huadi.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
