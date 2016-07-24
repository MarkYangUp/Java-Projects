package com.mgielib.entity;

public class EFacultyResource extends EMaterialsBaseEntity {

private String department;
private String semester;
public EFacultyResource(String department, String semester) {
	super();
	this.department = department;
	this.semester = semester;
}

public EFacultyResource(){}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getSemester() {
	return semester;
}

public void setSemester(String semester) {
	this.semester = semester;
}




}