package com.kodgemisi.archunitexample.devicecatalog;

import com.kodgemisi.archunitexample.userprofile.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Device {

	@Id
	@GeneratedValue
	private Long id;

	private String displayName;

	private String macAddress;

	@ManyToOne
	private User owner;
}
