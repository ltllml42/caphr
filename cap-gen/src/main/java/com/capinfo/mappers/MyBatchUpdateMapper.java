package com.capinfo.mappers;

import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 自定义的批处理更新的mapper
 * @ClassName MyBatchUpdateMapper
 * @Description
 * @Author 86150
 * @Date 2019/3/14 13:42
 **/
public interface MyBatchUpdateMapper<T> {

    /**
     * 根据主键来批量更新所有的字段（只有一个主键的情况下）
     * 注意  该方法名需要和type指定的class中的一个方法名相同，但是2个方法的参数不一样
     * @param list
     */
    @UpdateProvider(type=MyBatchUpdateProvider.class,method = "dynamicSQL")
    void batchUpdate(List<T> list);

}
