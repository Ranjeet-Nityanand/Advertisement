package com.mohshiri.advertisement.dto;
import java.io.Serializable;

import ch.qos.logback.core.status.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanyDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private UserDto user;
	private Status status;
    private String createDate;
	private String updateDate;
	
}
