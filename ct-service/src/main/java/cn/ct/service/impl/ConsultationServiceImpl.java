package cn.ct.service.impl;

import cn.ct.common.enums.RegistryEnum;
import cn.ct.common.result.Result;
import cn.ct.common.result.ResultEnum;
import cn.ct.common.result.ResultUtils;
import cn.ct.dao.MedicalAdviceMapper;
import cn.ct.dao.RegistryMapper;
import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.model.req.MedicalAdviceReq;
import cn.ct.model.req.RegistryReq;
import cn.ct.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private MedicalAdviceMapper medicalAdviceMapper;
    @Autowired
    private RegistryMapper registryMapper;

    @Override
    public Integer addConsultation(MedicalAdviceReq medicalAdvice) throws Exception {
        Integer result = 1;
        MedicalAdviceDto medicalAdviceDto = medicalAdviceMapper.getMedicalAdvice(medicalAdvice.getRegistryId());
        // 添加医嘱
        if(medicalAdviceDto == null){
            result = medicalAdviceMapper.addMedicalAdvice(medicalAdvice);
        } else {
            result = medicalAdviceMapper.updateMedicalAdvice(medicalAdvice);
        }
        if(result == 0){
            return result;
        }

        // 修改挂号单状态
        RegistryReq registry = new RegistryReq();
        registry.setId(medicalAdvice.getRegistryId());
        registry.setStatus(RegistryEnum.STATUS_END_CONSULTATION.getCode());
        result = registryMapper.updateRegistry(registry);
        return result;
    }

    @Override
    public Result<MedicalAdviceDto> addMedicalAdvice(MedicalAdviceReq medicalAdvice) throws Exception {
        if(medicalAdvice.getRegistryId() == null){
            return ResultUtils.returnResult(ResultEnum.REGISTRY_ID_EMPTY);
        }
        MedicalAdviceDto medicalAdviceDto = medicalAdviceMapper.getMedicalAdvice(medicalAdvice.getRegistryId());

        Integer result = 1;
        // 添加医嘱
        if(medicalAdviceDto == null){
            result = medicalAdviceMapper.addMedicalAdvice(medicalAdvice);
        } else {
            result = medicalAdviceMapper.updateMedicalAdvice(medicalAdvice);
        }
        if(result == 0){
            return ResultUtils.returnResult(ResultEnum.FAIL_ADD_MEDICAL_ADVICE);
        }

        MedicalAdviceDto medicalAdviceRes = new MedicalAdviceDto();
        medicalAdviceRes.setRegistryId(medicalAdvice.getRegistryId());
        medicalAdviceRes.setChiefComplaint(medicalAdvice.getChiefComplaint());
        medicalAdviceRes.setDiagnosis(medicalAdvice.getDiagnosis());
        return ResultUtils.returnDataSuccess(medicalAdviceRes);
    }
}
