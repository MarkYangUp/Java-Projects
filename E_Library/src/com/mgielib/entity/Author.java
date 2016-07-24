package com.mgielib.entity;

public class Author {

private int authorId;
private String firstName;
private String lastName;
private String description;

public Author()
{
	
}

public Author(int authorId, String firstName, String lastName,
		String description) {
	super();
	this.authorId = authorId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.description = description;
}

public int getAuthorId() {
	return authorId;
}

public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
