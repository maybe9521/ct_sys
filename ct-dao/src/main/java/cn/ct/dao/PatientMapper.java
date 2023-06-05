package cn.ct.dao;

import cn.ct.model.dto.PatientDto;
import cn.ct.model.req.PatientReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ct.team
 * @Description
 */
public interface PatientMapper {
	/**
	 * 创建就诊卡
	 * @param patient
	 * @return
	 */
	Integer addPatient(PatientReq patient);
	/**
	 * 根据身份证号查询就诊卡信息
	 * @param idCard
	 * @return
	 */
	PatientDto getPatientByIdCard(@Param(value = "idCard") String idCard);
	/**
	 * 根据身份证号更新就诊卡信息
	 * @param patient
	 * @return
	 */
	Integer updatePatient(PatientReq patient);
	/**
	 * 根据医保卡号查询就诊卡信息
	 * @param idMedicare
	 * @return
	 */
	PatientDto getPatientByIdMedicare(@Param(value = "idMedicare") String idMedicare);


	/**
	 * 查询病人信息表集合
	 * @return
	 */
	List<PatientDto> getPatientList();
}
