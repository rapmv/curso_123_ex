package entities;

//final neste caso e para que n�o se tenha 
//sobreposi��o de classe

//public final class SavingsAccount extends Account {

public class SavingsAccount extends Account {
	
	private Double interestRate;
	
	public SavingsAccount() {
		
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance*interestRate;
	}
	
	//sobreposi��o sobre a classe Account
	@Override
	public void withdraw(double amount) {
		balance-=amount;
	}
	
	//final no metodo e para n�o se ter sobreposi��o
	//de outra subclasse
	//public final void withdraw(double amount) { ...}
}
