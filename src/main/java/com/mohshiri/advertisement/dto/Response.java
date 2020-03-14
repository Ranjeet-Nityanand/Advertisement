package com.mohshiri.advertisement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Response {

	private int code;
	private String message;
	private Object content;
	private String description;
	
}
