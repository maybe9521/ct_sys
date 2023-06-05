package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.RegistryDto;
import cn.ct.model.req.RegistryReq;

import java.util.Map;

/**
 * @author ct.team
 * @Description
 * Version 1.0
*/
public interface RegistryService {
    /**
     * 更新挂号单信息
     * @param id
     * @return
     */
    Integer updateRegister(Long id);
    /**
     * 生成挂号费
     * @param sign
     * @return
     * @throws Exception
     */
    Result<Map<String, Object>> createFee(String sign) throws Exception;
    /**
     * 挂号
     * @param registry
     * @return
     * @throws Exception
     */
    Integer register(RegistryReq registry) throws Exception;
    /**
     * 查询挂号信息列表
     * @param registry
     * @return
     * @throws Exception
     */
    Page<RegistryDto> getRegisterList(RegistryReq registry) throws Exception;
    /**
     * 查询挂号信息
     * @param id
     * @return
     * @throws Exception
     */
    RegistryDto getRegister(Long id) throws Exception;
}
