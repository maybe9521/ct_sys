package cn.ct.controller;/**
 * @author ct.team
 * @Description Version 1.0
 */

import cn.ct.common.result.Result;
import cn.ct.model.dto.ScheduleDto;
import cn.ct.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
@RequestMapping("/api/schedule")
public class ScheduleController {

    private Logger logger = LoggerFactory.getLogger(SysUsersController.class);

    @Autowired
    private ScheduleService scheduleService;

    /**
     * 根据就诊科室ID和值班时间段（排期）查询就诊医生列表
     * @param departmentId 就诊科室ID
     * @param sign 值班时间段
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getDoctorList.json", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<ScheduleDto>> getDoctorList(String departmentId,Integer sign) throws Exception {
        return scheduleService.getDoctorList(Long.valueOf(departmentId),sign);
    }

}
