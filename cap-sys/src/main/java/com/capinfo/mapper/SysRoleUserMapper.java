package com.capinfo.mapper;

import com.capinfo.base.BaseMapper;
import com.capinfo.entity.SysRoleUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleUserMapper extends BaseMapper<SysRoleUser,String> {

    List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser);

    int selectCountByCondition(SysRoleUser sysRoleUser);
}