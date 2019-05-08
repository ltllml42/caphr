package com.capinfo.dyn.sql.reader;

import schemacrawler.schemacrawler.InclusionRule;
import schemacrawler.schemacrawler.SchemaCrawlerOptionsBuilder;
import schemacrawler.schemacrawler.SchemaInfoLevel;
import schemacrawler.schemacrawler.SchemaInfoLevelBuilder;
import schemacrawler.tools.databaseconnector.DatabaseConnectionOptions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    private static Connection getConnection()
            throws SQLException
    {
        final String connectionUrl = "jdbc:mysql://localhost:3306/lenos?useUnicode=true&characterEncoding=UTF-8";
        final DataSource dataSource = new DatabaseConnectionOptions(connectionUrl);
        return dataSource.getConnection("root", "root");
    }



    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        System.out.println(conn);
        /**
         * 设置Schema信息的等级
         *     standard :  标准的
         *     minimum :   最小的
         *     detailed : 详细的
         *     maximum :  最大的
         *
         */

        /**
         *
         *         this.title = "";
         *         this.schemaInclusionRule = new IncludeAll();
         *         this.synonymInclusionRule = new ExcludeAll();
         *         this.sequenceInclusionRule = new ExcludeAll();
         *         this.tableTypes = Optional.of(defaultTableTypes());
         *         this.tableInclusionRule = new IncludeAll();
         *         this.columnInclusionRule = new IncludeAll();
         *         this.routineTypes = Optional.of(allRoutineTypes());
         *         this.routineInclusionRule = new ExcludeAll();
         *         this.routineColumnInclusionRule = new ExcludeAll();
         *         this.grepColumnInclusionRule = Optional.empty();
         *         this.grepRoutineColumnInclusionRule = Optional.empty();
         *         this.grepDefinitionInclusionRule = Optional.empty();
         *
         *       Builder 里面 通过构造器  来初始化参数
         *        通过 this自身来进行配置的更改。
         *
         */
        SchemaCrawlerOptionsBuilder optionsBuilder = SchemaCrawlerOptionsBuilder
                .builder().withSchemaInfoLevel(SchemaInfoLevelBuilder.standard())
                .title("配置参数");
                ;


    }



}
