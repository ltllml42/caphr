package com.capinfo.mapper;

import com.capinfo.base.BaseMapper;
import com.capinfo.entity.SysRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends BaseMapper<SysRole,String> {

    List<SysRole> selectRoleListByUser(Map map);

}