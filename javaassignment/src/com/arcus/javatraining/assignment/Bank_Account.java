//Bank_Account Class:

package com.arcus.javatraining.assignment;

public class Bank_Account {

	private String name;
	private int account_id;
	private static int number_of_account = 0;
	private String User_id;
	private String user_password;
	private double account_balance;

	public Bank_Account(String name, String User_id, String user_password) {
		this.name = name;
		this.User_id = User_id;
		this.user_password = user_password;
		number_of_account++;
		// account_balance = number_of_account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getPassword() {
		return user_password;
	}

	public void setPassword(String password) {
		this.user_password = password;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {

		this.account_id = account_id;
	}

	public static int getNumber_of_account() {
		return number_of_account;
	}

	public static void setNumber_of_account(int number_of_account) {
		Bank_Account.number_of_account = number_of_account;
	}

	public static void decrease_number_of_account() {
		number_of_account--;
	}

	{
		// return account_id;
	}

}
