package implemation;

public class BankAccount {//lcom is 0.50

private byte accountId;
private double balance;

public void setID(byte i)
{
		this.accountId=i;
}
public void setBalance(double balance) {
	this.balance+=balance;
}
public double getBalance() {return this.balance;}
public byte getId() {return this.accountId;}
}