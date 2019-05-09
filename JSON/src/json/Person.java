package json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author: 杨欢
 * @created: 2019-05-09 23:16
 * @description:
 */
public class Person {
	private String name;
	private int age;
	private String gender;

//	@JsonIgnore // 忽略该属性
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date birthday;

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + ", birthday=" + birthday + '}';
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
