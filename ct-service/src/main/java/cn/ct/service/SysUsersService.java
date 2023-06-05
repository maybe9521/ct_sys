package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.SysUserDto;
import cn.ct.model.req.SysUserReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface SysUsersService {
    /**
     * 根据就诊科室ID查询就诊医师列表
     * @param departmentId
     * @return
     * @throws Exception
     */
    Result<List<SysUserDto>> getDoctorList(Long departmentId) throws Exception;
    /**
     * 查询用户列表
     * @param sysUserReq
     * @return
     * @throws Exception
     */
    Page<SysUserDto> list(SysUserReq sysUserReq) throws Exception;
    /**
     * 添加用户
     * @param sysUserReq
     * @param file
     * @return
     * @throws Exception
     */
    Result addUser(SysUserReq sysUserReq, MultipartFile file) throws Exception;
    /**
     * 校验用户账号是否重复
     * @param account
     * @return
     * @throws Exception
     */
    Result accountExit(String account) throws Exception;
    /**
     * 查询用户头像Url
     * @param userId
     * @return
     */
    String getHeadUrl(Long userId);

}
