package com.earth.work.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class A1Dao2 {

	@Autowired
	DataSource ds;

	public int insert(int key, int value) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			//conn= ds.getConnection();			
			conn= DataSourceUtils.getConnection(ds);
			System.out.println("conn = " + conn);
			
			pstmt = conn.prepareStatement("insert into a1 values (?, ?)");
			pstmt.setInt(1, key);
			pstmt.setInt(2, value);
			
			return pstmt.executeUpdate();			
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			close(pstmt);
			// 트랜잭션 매니저가 판단하여 close 여부를 결정
			DataSourceUtils.releaseConnection(conn, ds);
			
		}
		
		return 0;
	}

	private void close(AutoCloseable... closeables) {
		for (AutoCloseable autoCloseable : closeables) {
			if (autoCloseable != null)
				try {autoCloseable.close();} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public void deleteAll() throws SQLException {
		// Tx와 별개로 동작해야 하므로 아래처럼 conn 생성됨
		Connection conn = ds.getConnection();
		String sql = "delete from a1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		close(pstmt, conn);
	}
}
