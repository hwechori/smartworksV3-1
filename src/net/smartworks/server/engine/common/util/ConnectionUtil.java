/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectionUtil {

	private static Log logger = LogFactory.getLog(ConnectionUtil.class);

	public ConnectionUtil() {
		super();
	}
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		close(rs, stmt);
		close(con);
	}
	public static void close(ResultSet[] rss, Statement[] stmts, Connection con) {
		close(rss, stmts);
		close(con);
	}
	public static void close(Connection con) {
		if (con == null)
			return;
		try {
			con.close();
		} catch (Exception e) {
			logger.warn(e, e);
		}
	}
	public static void close(ResultSet rs, Statement stmt) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				logger.warn(e, e);
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				logger.warn(e, e);
			}
		}
	}
	public static void close(ResultSet[] rss, Statement[] stmts) {
		if (rss != null) {
			for (int i=0; i<rss.length; i++) {
				if (rss[i] == null)
					continue;
				try {
					rss[i].close();
				} catch (Exception e) {
					logger.warn(e, e);
				}
			}
		}
		if (stmts != null) {
			for (int i=0; i<stmts.length; i++) {
				if (stmts[i] == null)
					continue;
				try {
					stmts[i].close();
				} catch (Exception e) {
					logger.warn(e, e);
				}
			}
		}
	}

}