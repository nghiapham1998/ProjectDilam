package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.ConnectDb;
import dto.MstCustomerDTO;
import dto.MstUserDTO;

public class MstCustomerDAO {

	static Connection con = null;
	static PreparedStatement pre = null;
	static ResultSet rs = null;
    static Statement stm = null;
	public static List<MstCustomerDTO> findAll() {
		List<MstCustomerDTO> customer = new ArrayList();
		int status = 0;
		String sql = "select * from MstCustomer where  DELETE_YMD IS NULL";
		try {
			con = ConnectDb.getConnect();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				MstCustomerDTO customerDTO = new MstCustomerDTO();
				customerDTO.setCUSTOMER_PCD_ID(rs.getFloat(1));
				customerDTO.setCustomerName(rs.getString(2));
				customerDTO.setAddress(rs.getString(3));
				customerDTO.setEmail(rs.getString(4));
				customerDTO.setGender(rs.getString(5));
				customer.add(customerDTO);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;

	}

	public static int delete(float[] customer) throws SQLException, ClassNotFoundException {

		List<Float> ids = new ArrayList<>();
        for(int i = 0 ; i < customer.length;i++) {
        	ids.add(customer[i]);
        }
	
		String sql = createQuery(ids.size());
			con = ConnectDb.getConnect();  
			pre = con.prepareStatement(sql);
			int parameterIndex = 1;
			for (Iterator<Float> iterator = ids.iterator(); iterator.hasNext();) {
				Float id = (Float) iterator.next();
				System.out.println(id);
				pre.setString(parameterIndex++,id.toString());
			}
		    return pre.executeUpdate();
	}

	private static String createQuery(int length) {
		String query = "UPDATE MstCustomer SET DELETE_YMD = GETDATE() where CUSTOMER_PCD_ID IN(";
		StringBuilder queryBuilder = new StringBuilder(query);
		for (int i = 0; i < length; i++) {
			queryBuilder.append(" ?");
			if (i != length - 1)
				queryBuilder.append(",");
		}
		queryBuilder.append(")");
		return queryBuilder.toString();
	}

	public static List<MstCustomerDTO> pagingMstCustomer(int index){
		List<MstCustomerDTO> cus = new ArrayList<>();
		String sql = "SELECT * FROM MstCustomer WHERE DELETE_YMD IS NULL ORDER BY CUSTOMER_PCD_ID OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY; ";
		try {
			con = ConnectDb.getConnect();
			pre = con.prepareStatement(sql);
			pre.setInt(1, (index - 1) *15);
			rs = pre.executeQuery();
			while(rs.next()) {
				MstCustomerDTO customer = new MstCustomerDTO();
				customer.setCUSTOMER_PCD_ID(rs.getFloat(1));
				customer.setCustomerName(rs.getString(2));
				customer.setAddress(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setGender(rs.getString(5));
				cus.add(customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cus;
	}
	
	// DEM SO LUONG Customer TRONG DATABASE 
	public static int getTotalCustomer()  {
		try {
			con = ConnectDb.getConnect();  
			String sql = "select COUNT(*) from MstCustomer where  DELETE_YMD IS NULL";
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
