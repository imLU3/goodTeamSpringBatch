package com.batch.goodTeam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "MYUSER")
@Data
public class MyUser implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name = "DEPT")
	private String dept;
	
	@Column(name = "SALARY")
	private Integer salary;
	
	@Column(name = "TIME")
	private Date time;

	
}
