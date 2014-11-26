package gc.cs.comp1011.writingtextfiles;

//defining a record
public class AccountRecord {

	// instance variables
	private int accountNumber;
	private String firstName;
	private String lastName;
	private double balance;

	public AccountRecord() {
		this(0, "", "", 0.0);
	}

	public AccountRecord(int account, String firstName, String lastName,
			double balance) {
		super();
		setAccount(account);
		setFirstName(firstName);
		setLastName(lastName);
		setBalance(balance);
	}

	public int getAccount() {
		return accountNumber;
	}

	public void setAccount(int account) {
		this.accountNumber = account;
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
