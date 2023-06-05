package cn.ct.service.impl;

import cn.ct.common.enums.PatientEnum;
import cn.ct.common.enums.RegistryEnum;
import cn.ct.common.result.Result;
import cn.ct.common.result.ResultUtils;
import cn.ct.common.util.Constants;
import cn.ct.common.util.EmptyUtils;
import cn.ct.dao.PatientMapper;
import cn.ct.dao.RegistryMapper;
import cn.ct.dao.ScheduleMapper;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.RegistryDto;
import cn.ct.model.pojo.Schedule;
import cn.ct.model.req.PatientReq;
import cn.ct.model.req.RegistryReq;
import cn.ct.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
public class RegistryServiceImpl implements RegistryService {

    @Autowired
    private RegistryMapper registryMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private ScheduleMapper scheduleMapper;


    @Override
    public Integer updateRegister(Long id) {
        // 更新挂号单状态和就诊时间
        RegistryReq registry = new RegistryReq();
        registry.setId(id);
        registry.setConsultationTime(new Date());
        registry.setStatus(RegistryEnum.STATUS_BEING_CONSULTED.getCode());
        return registryMapper.updateRegistry(registry);
    }

    @Override
    public Result<Map<String, Object>> createFee(String sign) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>(6);
        // 挂号总金额
        Integer fee = Constants.REGISTRY_FEE;
        result.put("fee", fee);
        // 是否使用医保-医保报销额
        Integer medicareFee = Constants.REGISTRY_NO_MEDICARE_FEE;
        if(Constants.SIGN_MEDICARE.equals(sign)){
            medicareFee = Constants.REGISTRY_MEDICARE_FEE;
        }
        result.put("medicareFee",medicareFee);
        // 实际应支付金额
        Integer payFee = fee - medicareFee;
        result.put("payFee", payFee);
        return ResultUtils.returnDataSuccess(result);
    }

    @Override
    public Integer register(RegistryReq registry) throws Exception {
        // 若新输入医保卡号，保存到病人表(就诊卡)中
        if(!StringUtils.isEmpty(registry.getIdMedicare())){
            PatientReq patient = new PatientReq();
            patient.setIdCard(registry.getIdCard());
            patient.setIsMedicare(PatientEnum.PATIENT_MEDICARE.getCode());
            patient.setIdMedicare(registry.getIdMedicare());
            patientMapper.updatePatient(patient);
        }
        Integer result = registryMapper.addRegistry(registry);
        if(result == 1){
            if(registry.getScheduleId() != null) {
                Schedule scheduleById = scheduleMapper.getScheduleById(registry.getScheduleId());
                if (scheduleById != null) {
                    // 挂号成功后更新门诊医师的剩余诊断病人数量
                    Schedule schedule = new Schedule();
                    schedule.setId(registry.getScheduleId());
                    schedule.setRemainingQuantity(scheduleById.getRemainingQuantity() - 1);
                    scheduleMapper.updateSchedule(schedule);
                }
            }
        }
        return result;
    }

    @Override
    public Page<RegistryDto> getRegisterList(RegistryReq registry) throws Exception {
        Integer total = registryMapper.getRegisterCount(registry);
        // 设置默认页码和页长
        Integer pageNo = registry.getPageNo();
        Integer pageSize = registry.getPageSize();
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page<RegistryDto> page = new Page<RegistryDto>(pageNo,pageSize,total);

        registry.setBeginPos(page.getBeginPos());
        registry.setPageSize(pageSize);
        List<RegistryDto> registerList = registryMapper.getRegisterList(registry);
        formatRegisterList(registerList);
        page.setList(registerList);

        return page;
    }

    @Override
    public RegistryDto getRegister(Long id) throws Exception {
        RegistryDto register = registryMapper.getRegistryById(id);
        formatRegister(register);
        return register;
    }

    private void formatRegisterList(List<RegistryDto> registerList){
        if(!CollectionUtils.isEmpty(registerList)){
            for(RegistryDto registry : registerList){
                formatRegister(registry);
            }
        }
    }
    private void formatRegister(RegistryDto registry){
        if(registry != null){
            // 病人性别
            if (registry.getPatientSex().equals(PatientEnum.PATIENT_SEX_WOMAN.getCode())) {
              registry.setPatientSexName(PatientEnum.PATIENT_SEX_WOMAN.getMsg());
            } else {
              registry.setPatientSexName(PatientEnum.PATIENT_SEX_MAN.getMsg());
            }

            // 挂号单状态
            if(registry.getStatus() != null) {
                switch (registry.getStatus()) {
                    case 1:
                        registry.setStatusName(RegistryEnum.STATUS_NO_CONSULTATION.getMsg());
                        break;
                    case 2:
                        registry.setStatusName(RegistryEnum.STATUS_BEING_CONSULTED.getMsg());
                        break;
                    case 3:
                        registry.setStatusName(RegistryEnum.STATUS_END_CONSULTATION.getMsg());
                        break;
                }
            }
        }
    }
}
