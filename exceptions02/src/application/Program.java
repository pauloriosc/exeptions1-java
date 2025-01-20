package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		
		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder:");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initital balance:");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.print("New balance: " + account.getBalance());
			
			sc.close();
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
	}

}
