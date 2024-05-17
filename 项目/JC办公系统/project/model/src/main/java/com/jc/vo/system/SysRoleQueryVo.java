//
//
package com.jc.vo.system;

import java.io.Serializable;

/**
 * 角色查询实体
 */
public class SysRoleQueryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

