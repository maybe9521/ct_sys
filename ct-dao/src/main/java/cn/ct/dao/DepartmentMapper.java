package cn.ct.dao;
import cn.ct.model.dto.DepartmentDto;

import java.util.List;
import java.util.Map;
/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface DepartmentMapper {
	/**
	 * 查询就诊科室列表
	 * @param param
	 * @return
	 */
	List<DepartmentDto> getDepartmentList(Map<String,Object> param);
}
