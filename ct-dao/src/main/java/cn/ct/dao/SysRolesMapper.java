package cn.ct.dao;

import cn.ct.model.dto.SysRoleDto;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface SysRolesMapper {
    /**
     * 获取角色列表
     * @return
     */
    List<SysRoleDto> getRolesList();
}
