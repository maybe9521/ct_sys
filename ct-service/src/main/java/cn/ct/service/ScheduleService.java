package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.ScheduleDto;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
*/
public interface ScheduleService {
    /**
     * 根据就诊科室ID和值班时间段查询就诊医生列表
     * @param departmentId
     * @param sign
     * @return
     * @throws Exception
     */
    Result<List<ScheduleDto>> getDoctorList(Long departmentId,Integer sign) throws Exception;

}
