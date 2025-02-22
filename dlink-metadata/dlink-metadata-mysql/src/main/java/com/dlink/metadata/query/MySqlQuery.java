package com.dlink.metadata.query;

import com.dlink.assertion.Asserts;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySqlQuery
 *
 * @author wenmo
 * @since 2021/7/20 14:01
 **/
public class MySqlQuery extends AbstractDBQuery {

    @Override
    public String schemaAllSql() {
        return "show databases";
    }

    @Override
    public String tablesSql(String schemaName) {
        return "select TABLE_NAME AS `NAME`,TABLE_SCHEMA AS `Database`,TABLE_COMMENT AS COMMENT from information_schema.tables" +
                " where TABLE_SCHEMA = '"+schemaName+"'";
    }

    @Override
    public String columnsSql(String schemaName,String tableName) {
        return "show full columns from `"+tableName+"`";
    }

    @Override
    public String schemaName() {
        return "Database";
    }


    @Override
    public String tableName() {
        return "NAME";
    }


    @Override
    public String tableComment() {
        return "COMMENT";
    }


    @Override
    public String columnName() {
        return "FIELD";
    }


    @Override
    public String columnType() {
        return "TYPE";
    }


    @Override
    public String columnComment() {
        return "COMMENT";
    }


    @Override
    public String columnKey() {
        return "KEY";
    }


    @Override
    public boolean isKeyIdentity(ResultSet results) throws SQLException {
        return "auto_increment".equals(results.getString("Extra"));
    }

    @Override
    public String isNotNull() {
        return "NULL";
    }
}
