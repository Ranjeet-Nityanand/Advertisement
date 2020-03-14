package com.mohshiri.advertisement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
	private List<User> user;
	@OneToOne
	private Status status;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
}
