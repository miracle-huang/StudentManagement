package Model;
 
public class Classes {
	private String classId;		//班级编号
	private int stuNum;			//学生数
	private String className;	//班级名
	
	public void setClassId(String classId){
		this.classId = classId;
	}
	
	public void setStuNum(int stuNum){
		this.stuNum = stuNum;
	}
	
	public void setClassName(String className){
		this.className = className;
	}
	
	public String getClassId(){
		return classId;
	}
	
	public int getStuNum(){
		return stuNum;
	}
	
	public String getClassName(){
		return className;
	}
}