package implemation;

public class PremiumAccount extends BankAccount {//lcom is 0.50
private float fee;
private double cashBackAmount;

//setters
public void setFee(float fee) {this.fee=fee;}
public void setCashback(double cashback) {this.cashBackAmount=cashback;}

//getters
public float getFee(){return this.fee;}
public double getCashback() {return this.cashBackAmount;}
}
