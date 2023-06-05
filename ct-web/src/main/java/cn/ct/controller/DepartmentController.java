package cn.ct.controller;

import cn.ct.common.result.Result;
import cn.ct.model.dto.DepartmentDto;
import cn.ct.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
@RequestMapping("/api/department")
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/getDepartmentList.json", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<DepartmentDto>> departmentList() throws Exception {
        logger.info("[departmentList]：获取就诊科室列表");
        return departmentService.getDepartmentList();
    }

}
