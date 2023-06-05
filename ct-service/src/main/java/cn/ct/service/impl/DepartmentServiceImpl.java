package cn.ct.service.impl;

import cn.ct.common.result.Result;
import cn.ct.common.result.ResultUtils;
import cn.ct.dao.DepartmentMapper;
import cn.ct.model.dto.DepartmentDto;
import cn.ct.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Result<List<DepartmentDto>> getDepartmentList() {
        Map<String,Object> param = new HashMap<String,Object>();
        List<DepartmentDto> departmentList = departmentMapper.getDepartmentList(param);
        return ResultUtils.returnDataSuccess(departmentList);
    }
}
