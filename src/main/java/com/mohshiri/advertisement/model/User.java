package com.mohshiri.advertisement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private long mobile;
	private String email;
	@ManyToOne
	private Company company;
	private String password;
	private String confirmPassword;
	private String city;
	private String country;
	@OneToOne
	private Status status;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
}
