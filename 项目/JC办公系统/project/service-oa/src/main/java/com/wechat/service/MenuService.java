package com.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.wechat.Menu;
import com.jc.vo.wechat.MenuVo;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/4/15 16:14
 * @Description:
 */
public interface MenuService extends IService<Menu> {

    List<MenuVo> findMenuInfo();

    void syncMenu();

    void removeMenu();
}
