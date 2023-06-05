package cn.ct.controller;

import cn.ct.common.result.Result;
import cn.ct.common.result.ResultEnum;
import cn.ct.common.util.Constants;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.SysUserDto;
import cn.ct.model.req.SysUserReq;
import cn.ct.service.SysUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
@RequestMapping("/api/users")
public class SysUsersController {

    private Logger logger = LoggerFactory.getLogger(SysUsersController.class);

    @Autowired
    private SysUsersService sysUsersService;

    /**
     * 主页面跳转
     * @return
     */
    @RequestMapping(value="/index")
    public String index2Html(){
        logger.info("[index2Html]：主页面跳转");
        return "main";
    }
    /**
     * 新增用户页面跳转
     * @return
     */
    @GetMapping("/addUser")
    public String addUser2Html(){
        logger.info("[addUser2Html] 新增用户页面跳转");
        return "userAdd";
    }

    /**
     * 根据就诊科室ID查询就诊医师列表
     * @param departmentId 就诊科室ID
     * @return
     */
    @RequestMapping(value = "getDoctorList.json",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<SysUserDto>> getDoctorList(String departmentId) throws Exception {
        return sysUsersService.getDoctorList(Long.valueOf(departmentId));
    }
    /**
     * 查询用户列表
     * @param sysUserReq
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String usersList(SysUserReq sysUserReq, Model model) throws Exception {
        logger.info("[usersList] 查询用户列表");
        Page<SysUserDto> data = sysUsersService.list(sysUserReq);
        List<SysUserDto> usersDtoList = data.getList();
        model.addAttribute("usersDtoList", usersDtoList);
        model.addAttribute("pages", data);
        return "userList";
    }
    /**
     * 添加用户
     * @param sysUserReq
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(SysUserReq sysUserReq, HttpServletRequest request,
                          @RequestParam("userImg") MultipartFile file) throws Exception {
        Result result = sysUsersService.addUser(sysUserReq, file);
        if(result.code.equals(ResultEnum.SUCCESS.getCode())){
            return "redirect:/api/users/list";
        }
        request.setAttribute("fileUploadError",result.msg);
        return "userAdd";
    }
    /**
     * 校验用户账号是否重复
     * @param account
     * @return
     */
    @RequestMapping(value = "/accountExist.json",method = RequestMethod.GET)
    @ResponseBody
    public Result accountExit(@RequestParam("account") String account) throws Exception {
        logger.info("[accountExit]：校验用户账号是否重复");
        return sysUsersService.accountExit(account);
    }
    /**
     * @Description 回显图片
     * @Param [userId, request, response]
     * @return void
     **/
    @RequestMapping("showImg")
    public void showImg(@RequestParam("userId") String userId,HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 查询用户头像Url
        String headUrl = sysUsersService.getHeadUrl(Long.valueOf(userId));
        // 设置默认头像
        if(StringUtils.isEmpty(headUrl)) {
            String courseFile = request.getSession().getServletContext().getRealPath("/");
            headUrl = courseFile + Constants.FILE_DEFAULT_HEAD_PATH;
        }

        // 输出
        FileInputStream fileIs=null;
        fileIs = new FileInputStream(headUrl);
        int i=fileIs.available();
        byte data[]=new byte[i];
        fileIs.read(data);
        response.setContentType("image/*");
        OutputStream outStream=response.getOutputStream();
        outStream.write(data);
        outStream.flush();
        outStream.close();
        fileIs.close();
    }
}
