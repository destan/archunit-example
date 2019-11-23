package com.kodgemisi.archunitexample.userprofile;

import com.kodgemisi.archunitexample.devicecatalog.Device;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String fullName;

	private String username;

	private String password;

	@OneToMany(mappedBy = "owner")
	private Set<Device> devices = new HashSet<>();

	public User(String fullName, String username, String password) {
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}
}
