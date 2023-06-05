package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.model.req.MedicalAdviceReq;

/**
 * @author ct.team
 * @Description
 * Version 1.0
*/
public interface ConsultationService {
    /**
     * 问诊
     * @param medicalAdvice
     * @return
     * @throws Exception
     */
    Integer addConsultation(MedicalAdviceReq medicalAdvice) throws Exception;

    /**
     * 添加医嘱(一个挂号单只能对应一条医嘱)
     * @param medicalAdvice
     * @return
     * @throws Exception
     */
    Result<MedicalAdviceDto> addMedicalAdvice(MedicalAdviceReq medicalAdvice) throws Exception;
}
