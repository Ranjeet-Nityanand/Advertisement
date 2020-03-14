package com.mohshiri.advertisement.dto;

import java.io.Serializable;

import com.mohshiri.advertisement.model.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String firstName;
	private String lastName;
	private long mobile;
	private String email;
	private CompanyDto company;
	private String oldPassword;
	private String password;
	private String confirmPassword;
	private String city;
	private String country;
	private String createDate;
	private String updateDate;
	private Status status;
	
}
