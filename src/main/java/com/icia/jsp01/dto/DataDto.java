package com.icia.jsp01.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //(어노테이션은 컴파일러가 보는 주석)
public class DataDto {
	private int code; //데이터 번호
	private String strData;
	private int numData;
	private String dateData;

}
