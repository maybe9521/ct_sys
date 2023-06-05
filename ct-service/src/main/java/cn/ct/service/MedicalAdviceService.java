package cn.ct.service;

import cn.ct.model.dto.MedicalAdviceDto;

/**
 * @author ct.team
 * @Description
 * Version 1.0
*/
public interface MedicalAdviceService {
    /**
     * 根据挂号单编号查询医嘱信息
     * @param registryId
     * @return
     */
    MedicalAdviceDto getMedicalAdvice(Long registryId);
}
