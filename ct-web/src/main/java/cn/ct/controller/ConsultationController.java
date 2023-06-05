package cn.ct.controller;

import cn.ct.common.result.Result;
import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.model.dto.RegistryDto;
import cn.ct.model.req.MedicalAdviceReq;
import cn.ct.service.ConsultationService;
import cn.ct.service.MedicalAdviceService;
import cn.ct.service.RegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
@RequestMapping("/api/consultation")
public class ConsultationController {

    private Logger logger = LoggerFactory.getLogger(SysUsersController.class);

    @Autowired
    private RegistryService registryService;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private MedicalAdviceService medicalAdviceService;

    /**
     * 跳转到问诊页面
     * @param id 挂号单编号
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/consultationAdd")
    public String consultationAdd(Integer id, Model model) throws Exception {
        RegistryDto register = registryService.getRegister(Long.valueOf(id));
        model.addAttribute("register",register);
        // 更新挂号单状态和就诊时间
        registryService.updateRegister(id.longValue());
        // 查询医嘱信息
        MedicalAdviceDto medicalAdvice = medicalAdviceService.getMedicalAdvice(Long.valueOf(id));
        model.addAttribute("medicalAdvice",medicalAdvice);
        return "consultationAdd";
    }

    /**
     * 问诊
     * @param medicalAdvice
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/consultationEnd")
    public String consultationAdd(MedicalAdviceReq medicalAdvice) throws Exception {
        consultationService.addConsultation(medicalAdvice);
        return "redirect:/api/register/registerInfoList";
    }

    /**
     * 添加医嘱
     * @param medicalAdvice
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/medicalAdviceAdd.json")
    @ResponseBody
    public Result<MedicalAdviceDto> medicalAdviceAdd(MedicalAdviceReq medicalAdvice) throws Exception {
        return consultationService.addMedicalAdvice(medicalAdvice);
    }

}
