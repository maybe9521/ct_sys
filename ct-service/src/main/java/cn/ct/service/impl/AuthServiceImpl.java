package cn.ct.service.impl;

import cn.ct.common.result.Result;
import cn.ct.common.result.ResultEnum;
import cn.ct.common.result.ResultUtils;
import cn.ct.common.util.PasswordUtil;
import cn.ct.dao.SysMenusMapper;
import cn.ct.dao.SysUsersMapper;
import cn.ct.model.dto.SysMenuDto;
import cn.ct.model.dto.SysRoleDto;
import cn.ct.model.dto.SysUserDto;
import cn.ct.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class AuthServiceImpl implements AuthService {
    @Autowired
    private SysUsersMapper sysUsersMapper;
    @Autowired
    private SysMenusMapper sysMenusMapper;
    @Autowired
    private cn.ct.dao.SysRolesMapper sysRolesMapper;

    @Override
    public SysUserDto doLogin(String account, String password) throws Exception{
        SysUserDto sysUser = sysUsersMapper.getUserByAccount(account);
        if(sysUser == null) {
            return null;
        }
        // 校验密码
        boolean result = PasswordUtil.match(password, sysUser.getPassword());
        if(!result){
            return null;
        }
        return sysUser;
    }

    @Override
    public Result<List<SysMenuDto>> getMenusList(Long userId) {
        SysUserDto sysUser = sysUsersMapper.getUserById(userId);
        if(sysUser == null) {
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_GET);
        }
        List<SysMenuDto> menusList = sysMenusMapper.getMenusList(sysUser.getUserType());
        return ResultUtils.returnDataSuccess(menusList);
    }

    @Override
    public Result<List<SysRoleDto>> getRolesList() throws Exception {
        List<SysRoleDto> rolesList = sysRolesMapper.getRolesList();
        return ResultUtils.returnDataSuccess(rolesList);
    }
}
