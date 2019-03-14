package com.capinfo.mappers;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * 创建自定义方法所用到的SQL语句
 * @ClassName MyBatchUpdateProvider
 * @Description
 * @Author 86150
 * @Date 2019/3/14 13:43
 **/
public class MyBatchUpdateProvider extends MapperTemplate {

    public MyBatchUpdateProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String batchUpdate(MappedStatement statement){
        //创建StringBuilder用于拼接sql语句的各个组成部分
        StringBuilder builder = new StringBuilder();
        //拼接foreach
        builder.append("<foreach collection=\"list\" item=\"item\" separator=\";\">  ");
        //获取实体类对应的class对象
        Class<?> entityClass = super.getEntityClass(statement);
        //获取实体类在数据库中对应的表名
        String tableName = super.tableName(entityClass);
        //生成update子句
        String updateClause = SqlHelper.updateTable(entityClass, tableName);

        builder.append(updateClause);

        builder.append("<set>");
        //获取所有字段信息
        Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);

        String idcolum = null;
        String idHolder = null;
        for (EntityColumn entityColumn : columns) {

            boolean isPrimaryKey = entityColumn.isId();
            //判断向前字段是否为主键
            if (isPrimaryKey) {
                //缓存主键的字段名和字段值
                idcolum = entityColumn.getColumn();
                //返回格式如：#{item.age,jdbcType=NUMBERIC,typeHandler = MyTypeHandler}
                idHolder = entityColumn.getColumnHolder("item");
            }else{
                //使用非主键字段拼接set子句
                String column = entityColumn.getColumn();
                String columnHolder = entityColumn.getColumnHolder("item");

                builder.append(column).append("=").append(columnHolder).append(",");
            }

        }

        builder.append("</set>");
        //使用前面缓存的主键名、主键值去拼接where子句
        builder.append(" where ");

        builder.append(idcolum).append("=").append(idHolder).append(";");

        builder.append("</foreach>  ");
        //拼接好的字符串返回
        return builder.toString();
    }
}
