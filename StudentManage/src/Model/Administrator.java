package Model;
 
public class Administrator {
	private String tcId;		//教师编号
	private String tcName;		//教师姓名
	private String tcClassId;	//班级编号
	private String tcSex;		//教师性别
	private String tcPassword;	//教师密码
	
	public void setTcId(String tcId){
		this.tcId = tcId;
	}
	
	public void setTcName(String tcName){
		this.tcName = tcName;
	}
	
	public void setTcClassId(String tcClassId){
		this.tcClassId = tcClassId;
	}
	
	public void setTcSex(String tcSex){
		this.tcSex = tcSex;
	}
	
	public void setTcPassword(String tcPassWord){
		this.tcPassword = tcPassWord;
	}
	
	public String getTcId(){
		return tcId;
	}
	
	public String getTcName(){
		return tcName;
	}
	
	public String getTcClassId(){
		return tcClassId;
	}
	
	public String getTcSex(){
		return tcSex;
	}
	
	public String getTcPassword(){
		return tcPassword;
	}
}