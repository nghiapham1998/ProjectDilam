package dto;

import java.sql.Date;

public class MstUserDTO {
    public float USER_PCD_ID;
    
    private String USERID;
    
    private String PASSWORD;
    
    private String USERNAME;
    
    private Date DELETE_YMD;
    
    private Date INSERT_YMD;

	public MstUserDTO(float uSER_PCD_ID, String uSERID, String pASSWORD, String uSERNAME, Date dELETE_YMD,
			Date iNSERT_YMD) {
		super();
		USER_PCD_ID = uSER_PCD_ID;
		USERID = uSERID;
		PASSWORD = pASSWORD;
		USERNAME = uSERNAME;
		DELETE_YMD = dELETE_YMD;
		INSERT_YMD = iNSERT_YMD;
	}

	public MstUserDTO() {
		super();
	}

	public float getUSER_PCD_ID() {
		return USER_PCD_ID;
	}

	public void setUSER_PCD_ID(float uSER_PCD_ID) {
		USER_PCD_ID = uSER_PCD_ID;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public Date getDELETE_YMD() {
		return DELETE_YMD;
	}

	public void setDELETE_YMD(Date dELETE_YMD) {
		DELETE_YMD = dELETE_YMD;
	}

	public Date getINSERT_YMD() {
		return INSERT_YMD;
	}

	public void setINSERT_YMD(Date iNSERT_YMD) {
		INSERT_YMD = iNSERT_YMD;
	}

	@Override
	public String toString() {
		return "MstUserDTO [USER_PCD_ID=" + USER_PCD_ID + ", USERID=" + USERID + ", PASSWORD=" + PASSWORD
				+ ", USERNAME=" + USERNAME + ", DELETE_YMD=" + DELETE_YMD + ", INSERT_YMD=" + INSERT_YMD + "]";
	}
    
    
    
}
