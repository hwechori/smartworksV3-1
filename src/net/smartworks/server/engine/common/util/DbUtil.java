/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

	public DbUtil() {
		super();
	}
	
	public static void execute(String className, String url, String username, String password, String query) throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(className);
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			stmt.execute(query);
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.close(null, stmt);
			ConnectionUtil.close(con);
		}
	}
	
	public static List getFieldNameList(String table, String idField, Connection con) throws Exception {
		if (table == null || idField == null || con == null)
			return null;

		List list = null;
		StringBuffer buf = new StringBuffer("select * from ").append(table).append(" where ").append(idField).append(" is null");
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData md = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(buf.toString());
			md = rs.getMetaData();
			list = new ArrayList();
			for (int i=0; i<md.getColumnCount();) {
				i++;
				list.add(md.getColumnName(i));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.close(rs, stmt);
		}
		return list;
	}

}