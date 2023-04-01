package com.arcus.javatraining.assignment;

import java.util.*;

public class DriverClass {

	public static void main(String[] args) {
		
		System.out.println("ss".hashCode());
		ArrayList<Bank_Account> al = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		String name = "";
		String user_id = "";
		String user_password = "";
		double amt = 0;
		
		while (true) {
			System.out.println("1. Create an  Account");
			System.out.println("2. Delete an  Account");
			System.out.println("3. Make an Account Deposit");
			System.out.println("4. Make an Account Withdrawal");
			System.out.println("5. Check an Account Balance");
			System.out.println("6. Exit");
			
			while (true) {
				System.out.println("Enter choice : ");
				ch = sc.nextInt();
				if (ch < 1 || ch > 6) {
					System.out.println("Please enter a valid choice [ 1 through 6 ]");
					continue;
				} else
					break;
			}
			switch (ch) {
				case 1:// create account
					sc = new Scanner(System.in);
					System.out.println("Enter name : ");
					name = sc.nextLine();
					System.out.println("Enter User Id : ");
					user_id = sc.next();
					System.out.println("Enter Password : ");
					user_password = sc.next();
					if (user_password.length() < 8) {
						try {
							throw new InvalidPasswordException(
									"Error:Must enter a valid password\nInvalidPasswordFormatException: Invalid password format");
						} catch (InvalidPasswordException e)

						{
							System.out.println(e.getMessage());
							continue;
						}
					}
					if (!user_password.contains("*")) {
						try {
							throw new InvalidPasswordException(
									"Error: Must enter a valid password\nInvalidPasswordFormatException: Invalid password format");
						} catch (InvalidPasswordException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}

					Checking_Account chacc = new Checking_Account(name, user_id, user_password);
					al.add(chacc);
					break;

				case 2:// delete acct
					System.out.println("Enter User Id : ");
					user_id = sc.next();
					System.out.println("Enter Password : ");
					user_password = sc.next();
					Iterator<Bank_Account> it = al.iterator();
					int flag = 0;
					while (it.hasNext()) {
						Checking_Account chk = (Checking_Account) it.next();
						if (chk.getUser_id().equalsIgnoreCase(user_id) && chk.getPassword().equals(user_password)) { // remove
																														// this
																														// user
							flag = 1;
							it.remove();
							Checking_Account.decrease_number_of_account();
							break;
						}
					}

					if (flag == 0) {
						try {
							throw new CustomerAccountNotFoundException(
									"Error: Must enter a valid user ID and Password\nCustomerAccountNotFoundException: Customer Account not found");
						} catch (CustomerAccountNotFoundException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}
					break;
				case 3:// deposit
					System.out.println("Enter User Id : ");
					user_id = sc.next();
					System.out.println("Enter Password : ");
					user_password = sc.next();
					flag = 0;
					for (int i = 0; i <= al.size() - 1; i++) {
						Checking_Account chk = (Checking_Account) al.get(i);// getting the account

						if (chk.getUser_id().equalsIgnoreCase(user_id) && chk.getPassword().equals(user_password)) { // customer
																														// found
							flag = 1;
							System.out.println("Enter amount to deposit : ");
							amt = sc.nextDouble();
							if (amt < 0) { // amount negative
								try {
									throw new NegativeAmountException(
											"Error: Must enter a positive  amount\nNegativeAmountException: Negative  amount");

								} catch (NegativeAmountException e) {
									System.out.println(e.getMessage());
									continue;
								}
							} else {
								// update balance
								chk.setAccount_balance(chk.getAccount_balance() + amt);
								break;// exit for loop
							}
						}
					}
					if (flag == 0) {
						try {
							throw new CustomerAccountNotFoundException(
									"Error: Must enter a valid user ID and Password\nCustomerAccountNotFoundException: Customer Account not found");
						} catch (CustomerAccountNotFoundException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}
					break;
				case 4: // withdraw
					System.out.println("Enter User Id : ");
					user_id = sc.next();
					System.out.println("Enter Password : ");
					user_password = sc.next();
					flag = 0;
					for (int i = 0; i <= al.size() - 1; i++) {
						Checking_Account chk = (Checking_Account) al.get(i);// getting the account
						if (chk.getUser_id().equalsIgnoreCase(user_id) && chk.getPassword().equals(user_password)) { // customer
																														// found
							flag = 1;
							System.out.println("Enter amount to withdraw : ");
							amt = sc.nextDouble();
							if (amt < 0) {
								// amount negative
								try {
									throw new NegativeAmountException(
											"Error: Must enter a positive dollar amount\nNegativeAmountException: Negative  amount");
								} catch (NegativeAmountException e) {
									System.out.println(e.getMessage());
									continue;
								}
							} else if (amt > chk.getAccount_balance()) {
								try {
									throw new InsufficientFundsException(
											"Error: Must withdraw An Amount Less Than Your Balance\nInsufficientFundsException: Insufficient fund");
								} catch (InsufficientFundsException e) {
									System.out.println(e.getMessage());
									continue;
								}
							}

							else if (amt > chk.getDaily_withdrawl_limit()) {
								try {
									throw new InsufficientFundsException("Error: withdraw limit exceeded");
								} catch (InsufficientFundsException e) {
									System.out.println(e.getMessage());
									continue;
								}
							}

							else { // update balance
								chk.setAccount_balance(chk.getAccount_balance() - amt);
								break;// exit for loop
							}
						}
					}
					if (flag == 0) {
						try {
							throw new CustomerAccountNotFoundException(
									"Error: Must enter a valid user ID and Password\nCustomerAccountNotFoundException: Customer Account not found");
						} catch (CustomerAccountNotFoundException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}
					break;
				case 5:// check balance
					System.out.println("Enter User Id : ");
					user_id = sc.next();
					System.out.println("Enter Password : ");
					user_password = sc.next();
					flag = 0;
					Checking_Account chk = null;
					for (int i = 0; i <= al.size() - 1; i++) {
						if (al.get(i) instanceof Checking_Account) {
							chk = (Checking_Account) al.get(i);// getting the account
							if (chk.getUser_id().equalsIgnoreCase(user_id) && chk.getPassword().equals(user_password)) { // customer
																															// found
								flag = 1;
								System.out.println("Customer name : " + chk.getName());
								System.out.println("Account Number : " + chk.getAccount_id());
								System.out.println("Account Balance : " + chk.getAccount_balance());
								System.out.println("Account type : Checking");
								System.out
										.println("Account daily withdrawal limit : " + chk.getDaily_withdrawl_limit());
								System.out.println();
								break;
							}
						}
					}
					if (flag == 0) {
						try {
							throw new CustomerAccountNotFoundException(
									"Error: Must enter a valid user ID and Password\nCustomerAccountNotFoundException: Customer Account not found");
						} catch (CustomerAccountNotFoundException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}
					break;
				case 6:
					System.exit(0);
			}
		}
	}

}
