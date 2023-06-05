package cn.ct.dao;

import cn.ct.model.dto.SysMenuDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface SysMenusMapper {
    /**
     * 获取菜单列表
     * @param roleId
     * @return
     */
    List<SysMenuDto> getMenusList(@Param(value = "roleId") Integer roleId);
}
