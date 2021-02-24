package com.hcl.task.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

//import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "name")
    @NotEmpty(message = "*Please provide a name")
    private String name;
	
	@Column(name = "start")
    //@NotEmpty(message = "*Please provide a start date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	
	@Column(name = "end")
    //@NotEmpty(message = "*Please provide an end date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;
	
	@Column(name = "description")
    @NotEmpty(message = "*Please provide a description")
    private String description;
	
	@Column(name = "email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
	
	@Column(name = "severity")
    //@NotEmpty(message = "*Please provide the severity")
    private String severity;
	
	@Column(name = "user_task")
    @NotEmpty(message = "*Please provide a username")
    private String user_task;
}
