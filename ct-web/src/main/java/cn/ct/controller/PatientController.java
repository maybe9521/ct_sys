package cn.ct.controller;

import cn.ct.common.result.Result;
import cn.ct.model.dto.PatientDto;
import cn.ct.model.req.PatientReq;
import cn.ct.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
@RequestMapping("/api/patient")
public class PatientController {

    private Logger logger = LoggerFactory.getLogger(SysUsersController.class);

    @Autowired
    private PatientService patientService;

    /**
     * 创建就诊卡页面跳转
     * @return
     */
    @RequestMapping(value="/patientAdd")
    public String addPatient2Html(){
        logger.info("[addPatient2Html]：创建就诊卡页面跳转");
        return "patientAdd";
    }

    /**
     * 根据医保卡号查询就诊卡信息
     * @param idMedicare
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getPatientByIdMedicare.json", method = RequestMethod.POST)
    @ResponseBody
    public Result<PatientDto> getPatientByIdMedicare(@RequestParam("idMedicare") String idMedicare) throws Exception {
        return patientService.getPatientByIdMedicare(idMedicare);
    }
    /**
     * 创建就诊卡
     * @param patient
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createVisitCard", method = RequestMethod.POST)
    public String createVisitCard(PatientReq patient) throws Exception {
        Integer result = patientService.createVisitCard(patient);
        if(result == 0){
            return "patientAdd";
        }
        return "redirect:/api/users/index";
    }
    /**
     * 根据身份证号查询就诊卡信息
     * @param idCard
     * @return
     */
    @RequestMapping(value = "/getPatientByIdCard.json", method = RequestMethod.POST)
    @ResponseBody
    public Result<PatientDto> getPatientByIdCard(@RequestParam("idCard") String idCard) throws Exception {
        return patientService.getPatientByIdCard(idCard);
    }


}
