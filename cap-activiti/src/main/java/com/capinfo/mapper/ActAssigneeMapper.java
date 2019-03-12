package com.capinfo.mapper;

import com.capinfo.base.BaseMapper;
import com.capinfo.entity.ActAssignee;
import tk.mybatis.mapper.common.Mapper;

public interface ActAssigneeMapper extends BaseMapper<ActAssignee,String> {
    int deleteByNodeId(String nodeId);
}