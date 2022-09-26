package implemation;

public class Profile {//lcom is 0.66

	private ProfileName profileName;
	private String address;
	private short age;
	
	public ProfileName getProfileName() {
		return profileName;
	}
	
	public void setProfileName(ProfileName newProfileName) {
		profileName = newProfileName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	public short getAge() {
		return age;
	}
	
	public void setAge(short newAge) {
		this.age = newAge;
	}
}


