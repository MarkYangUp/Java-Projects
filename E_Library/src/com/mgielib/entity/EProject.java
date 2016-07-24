package com.mgielib.entity;

import com.mgielib.entity.EMaterialsBaseEntity;

public class EProject extends EMaterialsBaseEntity {

private String topic;
private String projectType;
private String top;

public EProject(){}

public EProject(String topic, String projectType, String top) {
	super();
	this.topic = topic;
	this.projectType = projectType;
	this.top = top;
}

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public String getProjectType() {
	return projectType;
}

public void setProjectType(String projectType) {
	this.projectType = projectType;
}

public String getTop() {
	return top;
}

public void setTop(String top) {
	this.top = top;
}



}
