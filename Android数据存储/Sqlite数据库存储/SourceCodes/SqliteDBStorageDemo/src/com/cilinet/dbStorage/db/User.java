package com.cilinet.dbStorage.db;

/** 用户类 **/
public class User {
	public int id;
	public String userName;
	public String userAddress;
	
	public String toString(){
		return "id: " + id + " && userName: " + userName + " && userAddress: " + userAddress;
	}
}
