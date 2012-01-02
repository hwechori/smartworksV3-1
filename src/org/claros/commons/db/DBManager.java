package org.claros.commons.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.claros.commons.configuration.PropertyFile;
import org.claros.commons.db.handler.ItemResultSetHandler;
import org.claros.commons.db.handler.ListResultSetHandler;

/**
 * @author Umut Gokbayrak
 *
 */
public class DBManager {
    private static Log log = LogFactory.getLog(DBManager.class);
    private static Configuration sqls = null;
    
    /**
     */
    public static List queryList(String dbId, String sqlKey, Object params[]) throws SQLException {
    	String sql = getSqlFromKey(sqlKey);
    	log.debug("Running List query sql: " + sql + " with params: " + ((params == null) ? null : params.toString()) + " on dbId: " + dbId);
    	QueryRunner run = new QueryRunner(DbConfigList.getDataSourceById(dbId));
        List result = null;
        try {
            result = (List)run.query(sql, params, new ListResultSetHandler());
        } catch (SQLException e) {
            log.error("Error while querying... Key:" + sqlKey + " params: " + params, e);
            throw e;
        }
		log.debug("Sql List query returned " + ((result == null) ? null : result.toString()));
        return result;
    }

    public static HashMap queryItem(String dbId, String sqlKey, Object params[]) throws SQLException {
    	String sql = getSqlFromKey(sqlKey);
    	log.debug("Running Item query sql: " + sql + " with params: " + ((params == null) ? null : params.toString()) + " on dbId: " + dbId);
        QueryRunner run = new QueryRunner(DbConfigList.getDataSourceById(dbId));
        HashMap result = null;
        try {
            result = (HashMap)run.query(sql, params, new ItemResultSetHandler());
        } catch (SQLException e) {
            log.error("Error while querying... Key:" + sqlKey + " params: " + params, e);
            throw e;
        }
		log.debug("Sql Item query returned " + ((result == null) ? null : result.toString()));
        return result;
    }
    
    public static Object queryBean(String dbId, String sqlKey, Object params[], Class clsBean) throws SQLException {
    	String sql = getSqlFromKey(sqlKey);
    	log.debug("Running Bean query sql: " + sql + " with params: " + ((params == null) ? null : params.toString()) + " on dbId: " + dbId + " on bean: " + clsBean);
		QueryRunner run = new QueryRunner(DbConfigList.getDataSourceById(dbId));
		ResultSetHandler h = new BeanHandler(clsBean);
		Object result = run.query(getSqlFromKey(sqlKey), params, h);
		log.debug("Sql Bean query returned " + ((result == null) ? null : result.toString()));
		return result;
    }

    public static void update(String dbId, String sqlKey, Object params[]) throws SQLException {
		String sql = getSqlFromKey(sqlKey);
    	log.debug("Running sql update, sql: " + sql + " with params: " + ((params == null) ? null : params.toString()) + " on dbId: " + dbId);
		QueryRunner run = new QueryRunner(DbConfigList.getDataSourceById(dbId));
		int result = run.update(sql, params);
		log.debug("Sql Update returned Result: " + result);
    }

    public static void delete(String dbId, String sqlKey, Object params[]) throws SQLException {
		String sql = getSqlFromKey(sqlKey);
    	log.debug("Running sql delete, sql: " + sql + " with params: " + ((params == null) ? null : params.toString()) + " on dbId: " + dbId);
		QueryRunner run = new QueryRunner(DbConfigList.getDataSourceById(dbId));
		int result = run.update(sql, params);
		log.debug("Sql Delete returned Result: " + result);
    }

    public static void insert(String dbId, String sqlKey, Object params[]) throws SQLException {
		String sql = getSqlFromKey(sqlKey);
    	log.debug("Running sql insert, sql: " + sql + " with params: " + ((params == null) ? null : params.toString()) + " on dbId: " + dbId);
		QueryRunner run = new QueryRunner(DbConfigList.getDataSourceById(dbId));
		int result = run.update(sql, params);
		log.debug("Sql Insert returned Result: " + result);
    }
    
    private static String getSqlFromKey(String sqlKey) {
        return sqls.getString(sqlKey);
    }

    static {
        try {
            sqls = PropertyFile.getConfiguration("/resources/sql.properties");
        } catch (Exception e) {
            log.fatal("Can not read sql.properties file. Look what is happening. It will crash probably!!!", e);
        }
    }
}
