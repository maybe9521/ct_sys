package cn.ct.dao;

import cn.ct.model.dto.SysUserDto;
import cn.ct.model.req.SysUserReq;

import java.util.List;
import java.util.Map;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface SysUsersMapper {
    /**
     * 根据就诊科室ID查询就诊医师列表
     * @param param
     * @return
     */
    List<SysUserDto> getDoctorList(Map<String, Object> param);
    /**
     * 查询用户数量
     * @param sysUserReq
     * @return
     */
    Integer getUsersCount(SysUserReq sysUserReq);
    /**
     * 查询用户列表
     * @param sysUserReq
     * @return
     */
    List<SysUserDto> getUsersList(SysUserReq sysUserReq);
    /**
     * 添加用户
     * @param sysUserReq
     * @return
     */
    Integer addUser(SysUserReq sysUserReq);
    /**
     * 根据用户名查询用户信息
     * @param account
     * @return
     */
    SysUserDto getUserByAccount(String account);

    /**
     * 根据用户名查询用户信息
     * @param account
     * @return
     */
    SysUserDto getUserByAccountOne(String account);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    SysUserDto getUserById(Long id);

    /**
     * 查询用户列表
     * @param sysUserReq
     * @return
     */
    List<SysUserDto> getUsersListOne(SysUserReq sysUserReq);
}
