package lv.java2.user;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;




@XmlRootElement
public class User implements Serializable{

	private int userId;
	private String firstName;
	private String lastName;
	private int age;
	private String nickName;


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "User [First name=" + firstName + ", Last name="+ lastName+", age=" + age + ", NickName="+  nickName+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstName.hashCode();
		result = prime * result + lastName.hashCode();
		result = prime * result + age;
		result = prime * result + nickName.hashCode();


		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}


		User user = (User) obj;
		return  (((firstName == user.firstName )|| (firstName != null && firstName.equals(user.getFirstName())))

				&& ((lastName == user.lastName )|| (lastName != null && lastName.equals(user.getLastName())))

				&& ((age == user.age )|| (age != 0 && age == user.age))

				&& ((nickName == user.nickName )|| (nickName != null && nickName.equals(user.getNickName())))

				  );
	}

}
