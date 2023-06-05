package cn.ct.service.impl;

import cn.ct.common.result.Result;
import cn.ct.common.result.ResultEnum;
import cn.ct.common.result.ResultUtils;
import cn.ct.common.util.DateUtils;
import cn.ct.common.util.EmptyUtils;
import cn.ct.dao.ScheduleMapper;
import cn.ct.model.dto.ScheduleDto;
import cn.ct.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;


    @Override
    public Result<List<ScheduleDto>> getDoctorList(Long departmentId, Integer sign) throws Exception {
        if( EmptyUtils.isEmpty(departmentId) || EmptyUtils.isEmpty(sign)){
            return ResultUtils.returnResult(ResultEnum.SCHEDULE_PARAM_EMPTY);
        }

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("departmentId",departmentId);
        param.put("sign",sign);
        List<ScheduleDto> scheduleList = scheduleMapper.getSchedule(param);

        // 判断当前时间等于医生就诊时间和剩余诊断病人数量大于0
        if(!CollectionUtils.isEmpty(scheduleList)){
            // 当前时间
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.YYYY_MM_DD);
            String currentTime = sdf.format(new Date());
            for (int i = 0; i < scheduleList.size(); i++){
                // 目前系统仅支持挂当天的号
                if( scheduleList.get(i).getRemainingQuantity() < 1 || currentTime.compareTo(scheduleList.get(i).getInquiryTime()) != 0 ){
                    scheduleList.remove(i);
                    // 索引要减1，不然会报错java.util.ConcurrentModificationException
                    i--;
                }
            }
        }

        if(CollectionUtils.isEmpty(scheduleList)){
            return ResultUtils.returnResult(ResultEnum.SCHEDULE_DOCTOR_EMPTY);
        }

        return ResultUtils.returnDataSuccess(scheduleList);
    }
}
