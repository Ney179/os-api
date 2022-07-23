package com.fernando.myapi.os.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
}
