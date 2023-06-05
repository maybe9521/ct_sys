package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.PatientDto;
import cn.ct.model.req.PatientReq;

/**
 * @author ct.team
 * @Description
 * Version 1.0
*/
public interface PatientService {
    /**
     * 创建就诊卡
     * @param patient
     * @return
     * @throws Exception
     */
    Integer createVisitCard(PatientReq patient) throws Exception;
    /**
     * 根据身份证号查询就诊卡信息
     * @param idCard
     * @return
     * @throws Exception
     */
    Result<PatientDto> getPatientByIdCard(String idCard) throws Exception;
    /**
     * 根据医保卡号查询就诊卡信息
     * @param idMedicare
     * @return
     * @throws Exception
     */
    Result<PatientDto> getPatientByIdMedicare(String idMedicare) throws Exception;
}
