package cn.ct.service;
import cn.ct.common.result.Result;
import cn.ct.model.dto.DepartmentDto;

import java.util.List;
/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface DepartmentService {

    /**
     * 获取就诊科室列表
     * @return
     * @throws Exception
     */
    Result<List<DepartmentDto>> getDepartmentList() throws Exception;

}
