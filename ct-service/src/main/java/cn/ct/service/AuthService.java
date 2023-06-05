package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.SysMenuDto;
import cn.ct.model.dto.SysRoleDto;
import cn.ct.model.dto.SysUserDto;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface AuthService {
    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return
     * @throws Exception
     */
    SysUserDto doLogin(String account, String password) throws Exception;
    /**
     * 获取菜单列表
     * @param userId
     * @return
     * @throws Exception
     */
    Result<List<SysMenuDto>> getMenusList(Long userId) throws Exception;
    /**
     * 获取角色列表
     * @return
     * @throws Exception
     */
    Result<List<SysRoleDto>> getRolesList() throws Exception;

}
