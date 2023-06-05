package cn.ct.service.impl;

import cn.ct.common.enums.UserEnum;
import cn.ct.common.result.Result;
import cn.ct.common.result.ResultEnum;
import cn.ct.common.result.ResultUtils;
import cn.ct.common.util.Constants;
import cn.ct.common.util.EmptyUtils;
import cn.ct.common.util.PasswordUtil;
import cn.ct.dao.SysRolesMapper;
import cn.ct.dao.SysUsersMapper;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.SysRoleDto;
import cn.ct.model.dto.SysUserDto;
import cn.ct.model.req.SysUserReq;
import cn.ct.service.SysUsersService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class SysUsersServiceImpl implements SysUsersService {

    private Logger logger = LoggerFactory.getLogger(SysUsersServiceImpl.class);

    @Autowired
    SysUsersMapper sysUsersMapper;

    @Autowired
    SysRolesMapper rolesMapper;

    @Value("${windowsFilePath}")
    private String windowsFilePath;
    @Value("${linuxFilePath}")
    private String linuxFilePath;

    @Override
    public Result<List<SysUserDto>> getDoctorList(Long departmentId) throws Exception {
        if(EmptyUtils.isEmpty(departmentId)){
            return ResultUtils.returnResult(ResultEnum.REGISTER_DEPARTMENT_ID_EMPTY);
        }
        // 根据就诊科室ID查询就诊医师列表
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("departmentId",departmentId);
        param.put("userType", UserEnum.USER_TYPE_DOCTER.getCode());
        List<SysUserDto> doctorList = sysUsersMapper.getDoctorList(param);
        String msg = "成功";
        if(CollectionUtils.isEmpty(doctorList)){
            msg = "该就诊科室下无就诊医师";
        }
        return ResultUtils.returnSuccess(msg,doctorList);
    }

    @Override
    public Page<SysUserDto> list(SysUserReq sysUserReq) throws Exception {
        Integer total = sysUsersMapper.getUsersCount(sysUserReq);
        // 设置默认页码和页长
        Integer pageNo = sysUserReq.getPageNo();
        Integer pageSize = sysUserReq.getPageSize();
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page<SysUserDto> page = new Page<SysUserDto>(pageNo,pageSize,total);
        sysUserReq.setBeginPos(page.getBeginPos());
        sysUserReq.setPageSize(pageSize);

        List<SysUserDto> usersDtoList = sysUsersMapper.getUsersListOne(sysUserReq);
        List<SysRoleDto> roleList = rolesMapper.getRolesList();
        for(int i=0;i<usersDtoList.size();i++){
            String typeName = roleList.get(usersDtoList.get(i).getUserType()).getRoleName();
            usersDtoList.get(i).setUserTypeName(typeName);
        }
        page.setList(usersDtoList);
        return page;
    }

    @Override
    public Result addUser(SysUserReq sysUserReq, MultipartFile file) throws Exception {
        if(file == null || file.isEmpty()){
            return ResultUtils.returnResult(ResultEnum.FAIL_FILE_EMPTY);
        }
        // 文件大小不得超过50k
        if(file.getSize() > Constants.FILE_SIZE){
            return ResultUtils.returnResult(ResultEnum.FAIL_FILE_SIZE_ERROR);
        }

        // 根据Windows和Linux配置不同的头像保存路径
        String OSName = System.getProperty("os.name");
        String filePath = OSName.toLowerCase().startsWith("win") ? windowsFilePath : linuxFilePath;

        String originalFilename = file.getOriginalFilename();
        String suffix = FilenameUtils.getExtension(originalFilename);
        // 校验上传文件的格式
        if(!(Constants.FILE_JPG.equalsIgnoreCase(suffix) || Constants.FILE_PNG.equalsIgnoreCase(suffix) ||
                Constants.FILE_JEPG.equalsIgnoreCase(suffix) || Constants.FILE_PNEG.equalsIgnoreCase(suffix) ||
                Constants.FILE_JPEG.equalsIgnoreCase(suffix) )){
            return ResultUtils.returnResult(ResultEnum.FAIL_FILE_SUFFIX_ERROR);
        }

        String fileName = filePath + System.currentTimeMillis() + "-" + originalFilename;
        logger.info("fileName : " + fileName);

        // 上传文件
        uploadFile(filePath,fileName,file);
        sysUserReq.setHeadUrl(fileName);

        // 加密密码
        String salt = PasswordUtil.salt();
        sysUserReq.setSalt(salt);
        sysUserReq.setPassword(PasswordUtil.encode(sysUserReq.getPassword(),salt));
        Integer reult = sysUsersMapper.addUser(sysUserReq);
        if(reult == 0 ){
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_ADD_ERROR);
        }
        return ResultUtils.returnSuccess();
    }

    private void uploadFile(String filePath, String fileName, MultipartFile file){
        BufferedOutputStream out = null;
        try {
            File folder = new File(filePath);
            if(!folder.exists()){
                folder.mkdirs();
            }
            out = new BufferedOutputStream(new FileOutputStream(fileName));
            // 写入新文件
            out.write(file.getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Result accountExit(String account) throws Exception {
        SysUserDto sysUser = sysUsersMapper.getUserByAccount(account);
        if(sysUser != null){
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_ACCOUNT_EXIST);
        }
        return ResultUtils.returnSuccess();
    }

    @Override
    public String getHeadUrl(Long userId) {
        SysUserDto sysUser = sysUsersMapper.getUserById(userId);
        return sysUser.getHeadUrl();
    }

}
