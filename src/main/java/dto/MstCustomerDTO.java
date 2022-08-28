package dto;

import java.sql.Date;

public class MstCustomerDTO {
    
	private float CUSTOMER_PCD_ID;
	
	private String CustomerName;
	
	private String Address;
	
	private String Email;
	
	private String 	Gender;
	
	private Date Delete_Ymd;
	
	private Date Insert_Ymd;

	public float getCUSTOMER_PCD_ID() {
		return CUSTOMER_PCD_ID;
	}

	public void setCUSTOMER_PCD_ID(float cUSTOMER_PCD_ID) {
		CUSTOMER_PCD_ID = cUSTOMER_PCD_ID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getDelete_Ymd() {
		return Delete_Ymd;
	}

	public void setDelete_Ymd(Date delete_Ymd) {
		Delete_Ymd = delete_Ymd;
	}

	public Date getInsert_Ymd() {
		return Insert_Ymd;
	}

	public void setInsert_Ymd(Date insert_Ymd) {
		Insert_Ymd = insert_Ymd;
	}
	
	
	
}
