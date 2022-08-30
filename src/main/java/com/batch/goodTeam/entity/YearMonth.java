package com.batch.goodTeam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
//@Entity
//@Table(name = "MyYear")
public class YearMonth implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="YEAR")
	private String year;
	
	@Id
	@Column(name="MONTH")
	private String month;
}
