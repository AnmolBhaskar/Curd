package com.example.curd.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class Users {

	@Id
	private String userName;
	private char[] password;
	
	@OneToMany 
	@JoinColumns(
			{@JoinColumn(name = "roleId")}
			)
	private List<Role> roleId;
	
	private boolean isLocked;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public List<Role> getRoleId() {
		return roleId;
	}
	public void setRoleId(List<Role> roleId) {
		this.roleId = roleId;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	
}
