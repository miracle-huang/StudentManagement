package Model;
 
public class Student {
	private String stuId;		//学生编号
	private String stuName;		//学生姓名
	private String stuSex;		//学生性别
	private String stuClassId;	//班级编号
	private String stuPassword;	//学生密码
	
	public void setStuId(String stuId){
		this.stuId = stuId;
	}
	
	public void setStuName(String stuName){
		this.stuName = stuName;
	}
	
	public void setStuSex(String stuSex){
		this.stuSex = stuSex;
	}
	
	public void setStuClassId(String stuClassId){
		this.stuClassId = stuClassId;
	}
	
	public void setStuPassword(String stuPassword){
		this.stuPassword = stuPassword;
	}
	
	public String getStuId(){
		return stuId;
	}
	
	public String getStuName(){
		return stuName;
	}
	
	public String getStuSex(){
		return stuSex;
	}
	
	public String getStuClassId(){
		return stuClassId;
	}
	
	public String getStuPassword(){
		return stuPassword;
	}
}