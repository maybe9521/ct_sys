package cn.ct.service.impl;

import cn.ct.common.enums.PatientEnum;
import cn.ct.common.result.Result;
import cn.ct.common.result.ResultEnum;
import cn.ct.common.result.ResultUtils;
import cn.ct.dao.PatientMapper;
import cn.ct.model.dto.PatientDto;
import cn.ct.model.req.PatientReq;
import cn.ct.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Integer createVisitCard(PatientReq patient) throws Exception {
        if(!StringUtils.isEmpty(patient.getIdMedicare())){
            patient.setIsMedicare(PatientEnum.PATIENT_MEDICARE.getCode());
        } else {
            patient.setIsMedicare(PatientEnum.PATIENT_NO_MEDICARE.getCode());
        }
        return patientMapper.addPatient(patient);
    }

    @Override
    public Result<PatientDto> getPatientByIdCard(String idCard) throws Exception {
        if(StringUtils.isEmpty(idCard)){
            return ResultUtils.returnResult(ResultEnum.PATIENT_ID_CARD_EMPTY);
        }
        PatientDto patient = patientMapper.getPatientByIdCard(idCard);
        if(patient == null){
            return ResultUtils.returnResult(ResultEnum.PATIENT_NULL);
        }
        return ResultUtils.returnDataSuccess(patient);
    }

    @Override
    public Result<PatientDto> getPatientByIdMedicare(String idMedicare) throws Exception {
        if(StringUtils.isEmpty(idMedicare)){
            return ResultUtils.returnResult(ResultEnum.PATIENT_ID_MEDICARE_EMPTY);
        }
        PatientDto patient = patientMapper.getPatientByIdMedicare(idMedicare);
        if(patient == null){
            return ResultUtils.returnResult(ResultEnum.PATIENT_NULL);
        }
        return ResultUtils.returnDataSuccess(patient);
    }
}
