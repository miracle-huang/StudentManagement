package Model;
 
public class Course {
	private String courseId;		//课程编号
	private String courseTime;		//课时
	private int credit;		//课程学分
	private String courseName;		//课程名
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public void setCourseTime(String courseTime){
		this.courseTime = courseTime;
	}
	
	public void setCredit(int credit){
		this.credit = credit;
	}
	
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	
	public String getCourseId(){
		return courseId;
	}
	
	public String getCourseTime(){
		return courseTime;
	}
	
	public int getCredit(){
		return credit;
	}
	
	public String getCourseName(){
		return courseName;
	}
}