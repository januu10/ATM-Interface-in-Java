package JavaProject;
import java.util.Scanner;
class BankAc
{
	String name;
	String username;
	String password;
	String accountno;
	float balance = 20000f;
	int transactions = 0;
	String transahis = "";
	
	public void register() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Your Name:");
		this.name = sc.nextLine();
		System.out.println("\nEnter Your Username:");
		this.username = sc.nextLine();
		System.out.println("\nEnter Your Password:");
		this.password = sc.nextLine();
		System.out.println("\nEnter Your Account No:");
		this.accountno = sc.nextLine();
		System.out.println("\nResgistration Successfully. Please Login to Bank Account");
	}
	public boolean login() 
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while(!isLogin) 
		{
			System.out.println("\nEnter Your Username:");
			String Username = sc.nextLine();
			if (username.equals(Username)) 
			{
				while(!isLogin) 
				{
					System.out.println("\nEnter Your Password");
					String Password = sc.nextLine();
					if(password.equals(Password)) 
					{
						System.out.println("\nSuccessfully Login Here");
						isLogin = true;
					}
					else 
					{
						System.out.println("\nIncorrect Password");
					}
				}
			} else 
			{
				System.out.println("\nUsername is not found here!!!");
			}
		}
		return isLogin;
	}
	public void withdraw() 
	{
		System.out.println("\nEnter amount to withdraw:");
		Scanner sc = new Scanner(System.in);
		float amt = sc.nextFloat();
		try {
			if(balance >= amt) 
			{
				transactions++;
				balance -= amt;
				System.out.println("\nCongratulations..Withdraw is Successfully.");
				String str = amt + "Rs. Withdrawn\n";
				transahis = transahis.concat(str);
			}else 
			{
				System.out.println("\n Insufficent Balance Here..");
			}
		} catch(Exception e) 
		{
			
		}
	}
	
	public void deposit() 
	{
		System.out.println("\nEnter amount to Deposit:");
		Scanner sc = new Scanner(System.in);
		float amt = sc.nextFloat();
		try {
			if(amt <= 20000f) 
			{
				transactions++;
				balance += amt;
				System.out.println("\nCongratulations..Deposit is Successfully.");
				String str = amt + "Rs. Deposited\n";
				transahis = transahis.concat(str);
			}else {
				System.out.println("\n Sorry for the inconvience. The  limit is 20000.");
			}
		} catch(Exception e) {
			
		}
	}
	
	public void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n To put on the Receipent's Name:");
		String recepient = sc.nextLine();
		System.out.println("\nEnter amount to Transfer:");
		
		float amt = sc.nextFloat();
		try {
			if(balance >= amt) {
			if(amt <= 70000f) {
				transactions++;
				balance -= amt;
				System.out.println("\nCongratulations..Successfully transfered to"+ recepient);
				String str = amt + "Rs. tranferred to" + recepient+"\n";
				transahis = transahis.concat(str);
			}else {
				System.out.println("\n Sorry for the inconvience. The limit is 70000.");
			}
		}else {
			System.out.println("\nSorry.. Insufficient Balance.");
		}
			} catch(Exception e) {
			
		}
	}
	public void transahis() {
		if(transactions == 0) {
			System.out.println("No Transactions Happened...");
		} else {
			System.out.print("\n"+transahis);
		}
	}

public void chekbala() {
	System.out.println("\n"+balance+"Rs.");
}
public static class ATMInterface 
{
	public static int takenIntegerInput(int limit) 
	{
		int input = 0;
		boolean flag = false;
		
		while(!flag) 
		{
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input>limit || input<1) {
					System.out.println("Choose the number between 1 to"+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("Enter only Integer Value:");
				flag=false;
			}
		}
		return input;
	}
	public static void main(String[] args) {
		System.out.println("\n********************************* WELCOME TO SHREENATH ATM INTERFACE**************************");
		
		System.out.println("\n1.Register \n2.Exit");
		System.out.println("Choose one option");
		int choose = takenIntegerInput(2);
		if(choose == 1) {
			BankAc b = new BankAc();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter Your Choice here...");
				int ch = takenIntegerInput(2);
				if(ch == 1) {
					if(b.login())
					{
						System.out.println("\n********************************* WELCOME BACK"+b.name +"******************************");
						boolean isfinished = false;
						while(!isfinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.println("Enter Your Choice here...");
							int c = takenIntegerInput(2);
							switch(c) {
							case 1:
								b.withdraw();
							case 2:
								b.deposit();
							case 3:
								b.transfer();
							case 4:
								b.chekbala();
							case 5:
								b.transahis();
							case 6:
								isfinished = true;
								break;
							}
						}
					} 
				} else {
					System.exit(0);
				}
			}
		} else {
			System.exit(0);
		}
	}
}
}