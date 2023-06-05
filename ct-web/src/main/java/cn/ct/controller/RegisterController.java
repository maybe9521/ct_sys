package cn.ct.controller;

import cn.ct.common.result.Result;
import cn.ct.common.util.Constants;
import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.RegistryDto;
import cn.ct.model.dto.SysUserDto;
import cn.ct.model.req.RegistryReq;
import cn.ct.service.MedicalAdviceService;
import cn.ct.service.RegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
@RequestMapping("/api/register")
public class RegisterController {

    private Logger logger = LoggerFactory.getLogger(SysUsersController.class);

    @Autowired
    private RegistryService registryService;
    @Autowired
    private MedicalAdviceService medicalAdviceService;

    /**
     * 挂号页面跳转
     * @return
     */
    @RequestMapping(value="/registerAdd")
    public String register2Html(){
        logger.info("[register2Html]：挂号页面跳转");
        return "registerAdd";
    }
    /**
     * 生成挂号费
     * @param sign
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createFee.json", method = RequestMethod.POST)
    @ResponseBody
    public Result<Map<String, Object>> createFee(String sign) throws Exception {
        return registryService.createFee(sign);
    }
    /**
     * 挂号
     * @param registry
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(RegistryReq registry) throws Exception {
        Integer result = registryService.register(registry);
        if(result == 0){
            return "registerAdd";
        }
        return "redirect:/api/users/index";
    }
    /**
     * 查询挂号信息列表-挂号员
     * @param registry
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/registerList")
    public String registerList(RegistryReq registry, Model model) throws Exception {
        Page<RegistryDto> data = registryService.getRegisterList(registry);
        List<RegistryDto> registryList = data.getList();
        model.addAttribute("registryList", registryList);
        model.addAttribute("pages", data);

        // 回显查询条件
        model.addAttribute("queryIdCard", registry.getIdCard());
        model.addAttribute("queryStatus", registry.getStatus());
        model.addAttribute("queryDepartmentId", registry.getDepartmentId());
        model.addAttribute("queryDoctorId", registry.getUserId());
        return "registerList";
    }
    /**
     * 查询挂号信息列表-门诊医师
     * @param registry
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/registerInfoList")
    public String registerInfoList(RegistryReq registry, Model model, HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.USER_SESSION);
        registry.setDepartmentId(sysUser.getDepartmentId());
        Page<RegistryDto> data = registryService.getRegisterList(registry);
        List<RegistryDto> registryList = data.getList();
        model.addAttribute("registryList", registryList);
        model.addAttribute("pages", data);

        // 回显查询条件
        model.addAttribute("queryIdCard", registry.getIdCard());
        model.addAttribute("queryStatus", registry.getStatus());
        model.addAttribute("queryDoctorId", registry.getUserId());
        return "registerInfoList";
    }
    /**
     * 查询挂号信息详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/registerView/{id}", method=RequestMethod.GET)
    public String registerView(@PathVariable String id, Model model) throws Exception {
        // 查询病人信息
        RegistryDto register = registryService.getRegister(Long.valueOf(id));
        model.addAttribute("register",register);
        // 查询医嘱信息
        MedicalAdviceDto medicalAdvice = medicalAdviceService.getMedicalAdvice(Long.valueOf(id));
        model.addAttribute("medicalAdvice",medicalAdvice);
        return "registerView";
    }

}
