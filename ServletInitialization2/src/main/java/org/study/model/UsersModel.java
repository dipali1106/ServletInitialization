package org.study.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.study.entity.UserEntity;

public class UsersModel {

	@Resource(name ="jdbc/project")
	private DataSource dataSource;
	
	private int Userid;
	
	public List<UserEntity> listUsers(DataSource dataSource) {
		List<UserEntity> userslist = new ArrayList<UserEntity>();
		Connection connect =null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			connect = dataSource.getConnection();
			String query ="Select * from z_entities";
			stmt = connect.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				userslist.add(new UserEntity(rs.getInt("users_id"), rs.getString("username"), rs.getString("email")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connect.close();
				stmt.close();rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return userslist;
	}
	
	public boolean addUser(DataSource dataSource, UserEntity newuser) {
		Connection connect =null;
		PreparedStatement stmt = null;
		try {
			connect = dataSource.getConnection();
			String query ="INSERT INTO `z_entities`( `username`, `email`) VALUES (?, ?)";
			stmt = connect.prepareStatement(query);
			stmt.setString(1,newuser.getUsername());
			stmt.setString(2, newuser.getEmail());
			System.out.println(query);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				connect.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return true;
		
	}
	
	public void updateUser(DataSource dataSource,UserEntity updateduser ) {
		Connection connect =null;
		PreparedStatement stmt = null;
		try {
			connect = dataSource.getConnection();
			String query ="Update `z_entities` set `username` = ? ,  `email` = ? WHERE users_id = ? ";
			stmt = connect.prepareStatement(query);
			stmt.setString(1,updateduser.getUsername());
			stmt.setString(2, updateduser.getEmail());
			stmt.setInt(3, updateduser.getUsers_id());
			System.out.println(query);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connect.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public void deleteUser(DataSource dataSource, int userId) {
		Connection connect =null;
		PreparedStatement stmt = null;
		try {
			connect = dataSource.getConnection();
			String query ="delete from `z_entities`  WHERE users_id = ? ";
			stmt = connect.prepareStatement(query);
			stmt.setInt(1,userId);			
			System.out.println(query);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connect.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
