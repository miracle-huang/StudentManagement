package Model;
 
public class User {
	private String username;	//账号
	private String password;	//密码
	private String identity;	//身份
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setIdentity(String identity){
		this.identity = identity;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getIdentity(){
		return identity;
	}
}