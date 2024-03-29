package gc.cs.comp1011.createobjectserialization;

import java.io.Serializable;

//defining a record
public class AccountRecordSerializable implements Serializable {

	// instance variables
	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	public AccountRecordSerializable() {
		this(0, "", "", 0.0);
	}

	public AccountRecordSerializable(int account, String firstName,
			String lastName, double balance) {
		super();
		setAccount(account);
		setFirstName(firstName);
		setLastName(lastName);
		setBalance(balance);
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
