package cn.ct.service.impl;

import cn.ct.dao.MedicalAdviceMapper;
import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.service.MedicalAdviceService;
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
public class MedicalAdviceServiceImpl implements MedicalAdviceService {

    @Autowired
    private MedicalAdviceMapper medicalAdviceMapper;


    @Override
    public MedicalAdviceDto getMedicalAdvice(Long registryId) {
        return medicalAdviceMapper.getMedicalAdvice(registryId);
    }
}
