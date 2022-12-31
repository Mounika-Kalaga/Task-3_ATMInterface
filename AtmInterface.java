import java.util.*;
//import java.util.Map;
//import java.util.HashMap;

class ATM
{
private double bal=10000.0;
private double deposit;
private double withdraw;

public double getBal()
{
  return bal;
}
public void setBal(double bal)
{
  this.bal = bal;
}
public double getdeposit()
{
  return deposit;
}
public void setDeposit(double deposit)
{
  this.deposit = deposit;
}
public double getwithdraw()
{
  return withdraw;
}
public void setwithdraw(double withdraw)
{
this.withdraw =  withdraw;
}
}


interface AtmInter
{
	public void viewbal();
	public void withdrawMoney(double withdraw);
	public void depositMoney(double deposit);
	public void transactions();
	public void transfer(double amount,AtmInter customer2);
}


class AtmPgrm implements AtmInter
{
	ATM aa=new ATM();
	Map<Double,String> transac=new HashMap<>();
	public void viewbal()
	{
		System.out.println("\nAvailable balance is : "+aa.getBal());
	}
	public void withdrawMoney(double withdraw)
	{
		if(withdraw <= aa.getBal())
		{
			transac.put(withdraw," Amount Withdrawn");
			aa.setBal(aa.getBal()-withdraw);
			viewbal();
		}
		else
		{
			System.out.println("\nYour transaction can't be done due to low balance !!");
		}
	}
	public void depositMoney(double deposit)
	{
		System.out.println("\n");
		transac.put(deposit," Amount Deposited");
		System.out.println(deposit+" Deposited Successfully !!");
		aa.setBal(aa.getBal()+deposit); 
		viewbal();
	}
	public void transactions()
	{
	
		for(Map.Entry<Double,String> m:transac.entrySet())
		{
		System.out.println(m.getValue()+" : "+m.getKey());
		}
	}
	public  void transfer ( double amount,AtmInter customer2)
	{
   		System.out.println("Transfered account details:");
   		customer2.depositMoney(amount);
   		System.out.println("Your Account details");
   		withdrawMoney(amount);
    	System.out.println(amount+" has been transfered successfulluy");
	}
}


class AtmInterface
{
	public static void main(String []args)
 {

	AtmInter customer=new AtmPgrm();
	AtmInter customer1=new AtmPgrm();

	int number1=112233445;
	int pin1=9087;
	Scanner sc=new Scanner(System.in);
	System.out.println("\nWelcome!!!!!!");
	System.out.print("\nEnter your ATM number :");
	int number=sc.nextInt();
	System.out.print("Enter ATM Pin Number :");
	int pin=sc.nextInt();
	if((number == number1)&&(pin == pin1))
	{
	while(true)
	{
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n1.View Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View transactions history\n5.Transfer to account\n6.Exit");
		System.out.println("\n");
		System.out.println("\nEnter Choice :");
		int ch=sc.nextInt();
		if(ch==1)
		{
			customer.viewbal();
		}
		else if(ch==2)
		{
			System.out.println("\nEnter amount to withdraw :");
			double withdraw=sc.nextDouble();
			customer.withdrawMoney(withdraw); 
		}
		else if(ch==3)
		{
			System.out.println("Enter Amount to Deposit :");
			double deposit=sc.nextDouble();
			customer.depositMoney(deposit);
		}
		else if(ch==4)
		{
			customer.transactions();
		}
        else if(ch==5)
		{
			System.out.println("\nEnter the account number you want to transfer money ");
			int accno=sc.nextInt();
			System.out.println("\nEnter the amount you want to transfer :");
			int amount=sc.nextInt();
			customer.transfer(amount,customer1);
					
		}
		else if(ch==6)
		{
			System.out.println("\nRemove your ATM Card\nThank You for using ATM Machine !!\n Have a good day");
			break;
		}
		else
		{
			System.out.println("Please enter correct choice");
		}
	}
  }
  else
 {
	System.out.print("OOps!!incorrect atm number or pin......Please verify and try again");
 }
}
}