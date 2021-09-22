package tw.leonchen.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//PerosnalProfiles.java
//PerosnalProfilesController.java

//yml or properties擇一
//application.yml (Profiles)
//application.properties (Profiles)

@Component
@ConfigurationProperties(prefix = "profiles")
public class PersonalProfiles {

	private String username;
	private String address;
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
