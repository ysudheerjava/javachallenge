//Checking_Account Class:

package com.arcus.javatraining.assignment;

public class Checking_Account extends Bank_Account {

	private double daily_withdrawl_limit;

	public Checking_Account(String name, String User_id, String user_password) {
		super(name, User_id, user_password);
		daily_withdrawl_limit = 300;
	}

	public double getDaily_withdrawl_limit() 
	{
		return daily_withdrawl_limit;
	}

	public void setDaily_withdrawl_limit(double daily_withdrawl_limit) {
		
		this.daily_withdrawl_limit = daily_withdrawl_limit;
	}

	public static void main(String[] args) {
		Checking_Account obj = new Checking_Account("Hari", "125", "2566");
		obj.setName("Ram");
		obj.setAccount_id(12354);
		obj.setUser_id("12345");
		obj.setPassword("12354@#");
		obj.setAccount_balance(326553.00);
		obj.setDaily_withdrawl_limit(1500);
		obj.setNumber_of_account(5);
		
		
		System.out.println(obj.getName());
		System.out.println(obj.getUser_id());
		System.out.println(obj.getPassword());
		System.out.println(obj.getAccount_id());
		System.out.println(obj.getAccount_balance());
		System.out.println(obj.getDaily_withdrawl_limit());
		System.out.println(obj.getNumber_of_account());

	}
}
