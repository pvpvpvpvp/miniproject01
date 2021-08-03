package mini.pack;

import java.util.ArrayList;

public class MiniData {
	private String name;
	private String hp;
	private String tel;
	
	public MiniData(String name,String hp,String tel) {
		setName(name);
		setHp(hp);
		setTel(tel);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	public void listout(int arrayLength) {
		System.out.printf("%d, %s %s %s%n",arrayLength+1,name,hp,tel);
	}
}
