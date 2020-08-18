package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount (1002, "Maria", 0.0, 500.0);
		
		//UPCASTING - objeto da subclasser ser atribuido
		//na super classe
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		//DOWNCASTING - objeto da superclasse
		//para a subclasse
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.0);
		
		//vai dar erro pois SavingsAccount não e um
		//BusinessAccount, erro vai ser identificado
		//na hora da compilação.
		//BusinessAccount acc5 = (BusinessAccount)acc3;
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		Account acc6 = new Account(2001,"Alexandre", 1000.0);
		acc6.withdraw(200.0);
		System.out.println(acc6.getBalance());
		
		Account acc7 = new SavingsAccount (2002, "Mario", 1000.0, 0.01);
		acc7.withdraw(200.0);
		System.out.println(acc7.getBalance());
		
		//resultado vai dar 793, pois vai sacar 200
		//descontar 5 da superclasse e descontar 2
		//por conta do metodo na subclasse
		Account acc10 = new BusinessAccount(3001, "Bob", 1000.0, 500.0);
		acc10.withdraw(200.0);
		System.out.println(acc10.getBalance());
		
		
		sc.close();
	}

}
