package com.capinfo.service.impl;

import com.capinfo.base.BaseMapper;
import com.capinfo.base.impl.BaseServiceImpl;
import com.capinfo.entity.JsGenTable;
import com.capinfo.mapper.JsGenTableMapper;
import com.capinfo.service.JsGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JsGenTableServiceImpl
 * @Description
 * @Author QJH
 * @Date 2019/3/14 15:24
 **/
@Service
public class JsGenTableServiceImpl extends BaseServiceImpl<JsGenTable,String> implements JsGenTableService {

    @Autowired
    private JsGenTableMapper jsGenTableMapper;

    @Override
    public BaseMapper<JsGenTable, String> getMappser() {
        return jsGenTableMapper;
    }

    public void test(){
        List<JsGenTable> jsGenTables = jsGenTableMapper.selectAll();
        System.out.println(jsGenTables);
    }
}
