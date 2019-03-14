package com.capinfo.mappers;


import com.capinfo.base.BaseMapper;

/**
 * 继承自己的mapper
 * 此类不能放在xxxMapper.java放在同一个 包下，这个是自定义的
 * qjh
 * @param <T>
 */
//二级缓存  使用这个需要开启
//@CacheNamespace
public interface MyBaseMapper<T> extends BaseMapper<T,String>,MyBatchUpdateMapper<T> {

}
