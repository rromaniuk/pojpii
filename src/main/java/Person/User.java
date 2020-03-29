package Person;

public class User {
	private String fullName, gender, email, password, street, postalc;
	private int id, phoneNumber;
	private char rights;
	public User() {
		
	}
	public User(String fullName, int id, char rights, String email, String password, String street,
			String gender, String postalc, int phone) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.street = street;
		this.postalc = postalc;
		this.id = id;
		this.phoneNumber = phone;	
		this.rights = rights;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalc() {
		return postalc;
	}
	public void setPostalc(String postalc) {
		this.postalc = postalc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public char getRights() {
		return rights;
	}
	public void setRights(char rights) {
		this.rights = rights;
	}
}
