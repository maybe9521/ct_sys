package cn.ct.dao;

import cn.ct.model.dto.RegistryDto;
import cn.ct.model.req.RegistryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author ct.team
 * @Description
 */
public interface RegistryMapper {
	/**
	 * 挂号
	 * @param registry
	 * @return
	 */
	Integer addRegistry(RegistryReq registry);
	/**
	 * 查询挂号信息列表
	 * @param registry
	 * @return
	 */
	List<RegistryDto> getRegisterList(RegistryReq registry);
	/**
	 * 查询挂号信息总数
	 * @param registry
	 * @return
	 */
	Integer getRegisterCount(RegistryReq registry);
	/**
	 * 根据ID查询挂号信息
	 * @param id
	 * @return
	 */
	RegistryDto getRegistryById(@Param(value = "id") Long id);
	/**
	 * 更新挂号单信息
	 * @param registry
	 * @return
	 */
	Integer updateRegistry(RegistryReq registry);
}
