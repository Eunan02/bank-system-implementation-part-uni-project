package implemation;

public class Client { //lcom is 0.66

//private static short nextId=0;
private short clientId;
private Profile clientProfile;
private BankAccount[] accounts=new BankAccount[5];

//setters
public void setId(short id)
{
	this.clientId=id;
}
public void setClientProfile(Profile clientProfile) {this.clientProfile=clientProfile;}
public void setAccounts(BankAccount account,int pos) 
{

if (pos<5 &&pos>=0)//so can only be between 1 and 5 as each client can only have one account
{
	this.accounts[pos]=account;
	account.setID((byte)pos);
}
}

//getters
public short getId() {return this.clientId;}
public Profile getClientProfile() {return this.clientProfile;}
public BankAccount[] getAccounts() {return this.accounts;}
}
