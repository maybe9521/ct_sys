package cn.ct.dao;

import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.model.req.MedicalAdviceReq;
import org.apache.ibatis.annotations.Param;
/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface MedicalAdviceMapper {
	/**
	 * 添加医嘱
	 * @param medicalAdvice
	 * @return
	 */
	Integer addMedicalAdvice(MedicalAdviceReq medicalAdvice);
	/**
	 * 根据挂号单编号查询医嘱信息
	 * @param registryId
	 * @return
	 */
	MedicalAdviceDto getMedicalAdvice(@Param(value = "registryId") Long registryId);

	Integer updateMedicalAdvice(MedicalAdviceReq medicalAdvice);
}
