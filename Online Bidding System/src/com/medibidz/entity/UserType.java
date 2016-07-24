package com.medibidz.entity;

public enum UserType {
	FACULTY,ADMIN,STUDENT;
	
	public static boolean isAdmin(UserType ut){
		return ADMIN.equals(ut);
	}
	public static boolean isStudent(UserType ut){
		return STUDENT.equals(ut);
	}
	public static boolean isFaculty(UserType ut){
		return FACULTY.equals(ut);
	}
}
