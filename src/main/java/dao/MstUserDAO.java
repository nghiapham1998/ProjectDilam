package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.ConnectDb;
import dto.MstUserDTO;

public class MstUserDAO {
    
	 static Connection con = null;
	 static PreparedStatement pre = null ;
	 static ResultSet rs = null;
	
	  public static int checkLogin(String userId,String password){
		  List<MstUserDTO> user = new ArrayList();
		  int status = 0;
		  String sql = "select COUNT(*) from MstUser where userId = ? AND password = ? AND DELETE_YMD IS NULL";
		  try {
			 con = ConnectDb.getConnect();
			 pre = con.prepareStatement(sql);
			 pre.setString(1, userId);
			 pre.setString(2, password);
			 rs = pre.executeQuery();
			 while(rs.next()){
				 status = rs.getInt(1);

			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  return status;
	  }
	  
	  public static MstUserDTO getUser(String userId) {
		  MstUserDTO user = new MstUserDTO();
		  String sql = "select * from MstUser where userId = ? ";
		  try {
			con = ConnectDb.getConnect();
			pre = con.prepareStatement(sql);
			 pre.setString(1, userId);
			rs = pre.executeQuery();
			while(rs.next()) {
				user.setUSER_PCD_ID(rs.getInt(1));
				user.setUSERID(rs.getString(2));
				user.setPASSWORD(rs.getString(3));
				user.setUSERNAME(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  System.out.println(user);
		  return user;
	  }
	
}
