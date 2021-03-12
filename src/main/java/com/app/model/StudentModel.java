package com.app.model;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@XmlRootElement
@ApiModel(description = "Student Request Model")
public class StudentModel {

	@ApiModelProperty(name = "student No", dataType = "String", value = "student No" )
	Long sno;
	
	@ApiModelProperty(name = "Student Name", value = "Student Name", allowableValues =  "Min of 3 characters & Max of 100 characters", required = true)
	String sname;
	
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
