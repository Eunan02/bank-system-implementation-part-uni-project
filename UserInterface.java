package implemation;
import java.util.Scanner;

public class UserInterface {//lcom 0.2
private  Client[] bankClients=new Client[1000];//array with the max number of clients allow
 
 void batchRegistration(short clientId)//useCase1
	{
	 //creating clients, will do this for every client in the bankClients array
	 Client client=null;
		client=new Client();
	bankClients[clientId]=client;
	bankClients[clientId].setId(clientId);
	System.out.println("Registration of bank Client with ID = "+bankClients[clientId].getId());
	}
	void presentManagementOptions(short id) //useCase2
	{Scanner input=new Scanner(System.in);
		System.out.println();
			//showing all the management options
		System.out.println("A. Create Client Profile");
		System.out.println("B. Update Client Profile");
		System.out.println("C. Create Bank Account");
		System.out.println("D. Delete Bank Account");
		System.out.println("E. Transfer Money Between Accounts");
		System.out.println("F. Print Client Profile");
		System.out.println("G. Client Account Details");
		System.out.println("H. Exit");
		System.out.print("Chose a management option \n> \n");
		char selectedOption = input.next().charAt(0);
	
		switch (Character.toUpperCase(selectedOption)) {
		case 'A':
			createProfileOfClient(id);
			break;
		case 'B':
			updateProfileOfBankClient(id);
			break;
		case 'C':
			createBankAccount(id);
			break;
		case 'D':
			deleteBankAccount(id);
			break;
		case 'E':
			moneyTransfer(id);
			break;
		case 'F':
			printClientProfile(id);
			break;
		case 'G':
			printClientBankAccounts(id);
			break;
		case 'H':
			System.out.println("System Shut-Down");
			System.exit(0);
		default:
			System.out.println("Invalid input.");
			presentManagementOptions(id);
	}
		}

		
	
	void createProfileOfClient(short id)//useCase3
	{
		Scanner input=new Scanner(System.in);
		String fName = "";
		String sName="";
		String address="";
	short age=0;
		System.out.println("Use Case 3: Create Profile of Client");
		System.out.println();
		Profile newProfile =new Profile(); 
		ProfileName newProfileName=new ProfileName();
		if (bankClients[id].getClientProfile() != null) {
		System.out.println("Client Profile already Created");
		}
		else {
		System.out.print("Enter client First Name \n> \n");
		 fName=input.nextLine();
		newProfileName.setFirstName(fName);
		System.out.println();
		System.out.print("Enter client Second Name \n> \n");
		 sName=input.nextLine();
		newProfileName.setLastName(sName);
		System.out.println();
		System.out.print("Enter client Address \n> \n");
		 address=input.nextLine();
		newProfile.setAddress(address);
		System.out.println();
		System.out.print("Enter client Age \n> \n");
		 age=input.nextShort();
		input.nextLine();
		newProfile.setAge(age);
		
		boolean valid=true;
		if (fName.length()==0)
		{
			valid=false;
		}
		 if (sName.length()==0)
		{
			valid=false;
		}
		 if (address.length()==0)
		{
			valid=false;
		}
		 if (newProfile.getAge()<=0)
		{
			valid=false;
		}
		if (valid==false)
		{
			System.out.println("Unable to add Profile,Invalid data entered");	
		}
		
		else
		{
		bankClients[id].setClientProfile(newProfile);
		bankClients[id].getClientProfile().setProfileName(newProfileName);
		System.out.println("The Client Profile has been created");
		}
	//	input.nextLine();
		}
		presentManagementOptions(id);
		}
	
	
	void updateProfileOfBankClient(short id)//useCase4
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Use Case 4. Update the Profile of a Bank-Client");
		System.out.println();
		if (bankClients[id].getClientProfile()==null)
		{
			System.out.println("No Client Profile has been created");//placeholder for error message for no client profile to update
		}else
		{
			//placeholder for validation and input of updating profile
			System.out.print("Ask for address \n> \n");
		String address=input.nextLine();
		System.out.println();
			System.out.print("Ask for Age \n> \n");
			short age=input.nextShort();
			input.nextLine();
		
			
			boolean valid=true;
		 if (address.length()==0)
			{
				valid=false;
			}
			else if (age<=0)
			{
				valid=false;
			}
			if (valid==false)
			{
				System.out.println("Unable to create Profile,Invalid data entered");	
			}
			else
			{
			bankClients[id].getClientProfile().setAddress(address);
			bankClients[id].getClientProfile().setAge(age);
			System.out.println("Profile Successfully Updated");	
			}
	
	}
	//System.out.println();
	presentManagementOptions(id);
	}
	
	void createBankAccount(short id)//useCase5
	{
		Scanner input=new Scanner(System.in);
		//BankAccount account=null;
	
		int count=0;
		System.out.println("Use Case 5. Create a Bank Account");
		//bankClients[id].setAccounts(account, 0);
		for ( int x=0;x<bankClients[id].getAccounts().length;x++)
		{
			if (bankClients[id].getAccounts()[x]!=null)
			{
			count++;
			}
		}
		if (count==5)
		System.out.println("Max number of accounts created");//placeholder error message
		else
		{
		System.out.println();
		//placeholder for input and validation of creating an account
		System.out.println("Account Types");
		System.out.println("A)Basic Account Type");
		System.out.println("B)Premium Account Type");
		System.out.print("Chose Bank Account Type \n> \n");
		String choice=input.nextLine();
		
		
		if (choice.equals("A"))
		{
			BasicAccount account=new BasicAccount();
			account.setBalance(1000);
			//bankClients[id].setAccounts(account, 0);
			for ( int y=0;y<bankClients[id].getAccounts().length;y++)
			{
				if (bankClients[id].getAccounts()[y]==null)
				{
					account.setID((byte)y);
					bankClients[id].setAccounts(account, y);
					break;
				}
			}
		
	
		//account.setID((byte));
	//	bankClients[id].setAccounts(account, count);
		
		System.out.println("Basic Bank Account Created");
		}
		else if (choice.equals("B"))
		{
			PremiumAccount account=new PremiumAccount();
			account.setBalance(1000);
			account.setFee(5);
			account.setCashback(10);
			//bankClients[id].setAccounts(account, 0);
			for ( int y=0;y<bankClients[id].getAccounts().length;y++)
			{
				if (bankClients[id].getAccounts()[y]==null)
				{
					account.setID((byte)y);
					bankClients[id].setAccounts(account, y);
					break;
				}
			}
			
			
			//account.setID((byte)count);
			//bankClients[id].setAccounts(account, count);
			System.out.println("Premium Bank Account Created");
			
		}
		else System.out.println("No account created, Invalid Input");
		
		
	}
		presentManagementOptions(id);
		}
	
	void deleteBankAccount(short clientID){//useCase6
		Scanner input=new Scanner(System.in);
	System.out.println("Use Case 6. Delete a Bank Account");
	System.out.println();
	int count=0;
	for (int x=0;x<bankClients[clientID].getAccounts().length;x++)
	{
		if (bankClients[clientID].getAccounts()[x]!=null)
		{
			count++;
		}
	}
	if (count==0)
	{
		System.out.println("No Bank Accounts added for client");
	}
	else
	{
	System.out.print("Enter the id of the bank Account:");
	byte bankId=input.nextByte();
	input.nextLine();
	if (bankId<0 || bankId>4)
	{
		System.out.println("Invalid Bank Id");
	}
	else
	{
		
		
			if (bankClients[clientID].getAccounts()[bankId] instanceof PremiumAccount || bankClients[clientID].getAccounts()[bankId] instanceof BasicAccount )
			{
				bankClients[clientID].getAccounts()[bankId]=null;
				System.out.println("Account deleted");
					//break;
			}
			else
				System.out.println("Invalid Bank Id");	
			}
		
	}	
	
	presentManagementOptions(clientID);
	}
	void moneyTransfer(short clientID)//useCase7
	{
		Scanner input=new Scanner(System.in);
	System.out.println("Use Case 7. Money Transfer");
	System.out.println();
	System.out.print("Enter Id of source Bank Account \n> \n");
	byte sourceBankId=input.nextByte();
	input.nextLine();
	System.out.println();
	System.out.print("Enter Id of target Bank Account \n> \n");
	byte targetBankId=input.nextByte();
	input.nextLine();
	System.out.println();
	System.out.print("Enter the ID of the Target Bank Client \n> \n");
	byte targetClientId=input.nextByte();
	input.nextLine();
	System.out.println();
	System.out.println("Enter The cash amount to be transferred \n> \n");
	double cashAmount=input.nextDouble();
	input.nextLine();	
	boolean doesIdExist = true;
	boolean isBalanceEnough = true;
	boolean doesTargetAccountExist=true;
	if (bankClients[clientID].getAccounts()[sourceBankId]==null)
			{
				doesIdExist=false;
			}
	else if (bankClients[targetClientId].getAccounts()[targetBankId]==null)
			 {
				 doesTargetAccountExist=false;
			 }
	else 	if (bankClients[clientID].getAccounts()[targetBankId].getBalance()<cashAmount)
	{
		isBalanceEnough=false;
	}
		
			if(doesIdExist !=true)
			{
				System.out.println("Source Bank Account doesn't exist, Unable to complete transfer");
			}
	
			else if (doesTargetAccountExist==false)
	{
		System.out.println("Target Bank Account doesn't exist,unable to complete Transfer");
	}
		
			else if(isBalanceEnough ==false)
			{
			System.out.println("Not enough balance to complete transfer");
			}
			
			else if (isBalanceEnough==true && doesIdExist==true && doesTargetAccountExist==true)
			{
				bankClients[targetClientId].getAccounts()[targetBankId].setBalance(cashAmount);
				bankClients[clientID].getAccounts()[sourceBankId].setBalance(-cashAmount);
				System.out.println("Transfer Completed");
			}
				presentManagementOptions(clientID);
	}
	

	
	void printClientProfile(short id)//useCase8and9
	{
		System.out.println("Client Details");
		System.out.println(bankClients[id].getClientProfile().getProfileName().getFirstName() + " " + bankClients[id].getClientProfile().getProfileName().getLastName() + " " + bankClients[id].getClientProfile().getAddress() + " " + bankClients[id].getClientProfile().getAge());//print out all the users profile
		presentManagementOptions(id);

	}
	void printClientBankAccounts(short id)
	{
		short validAccounts=0;
		System.out.println("Bank Accounts");
		System.out.println();
		for (int x=0;x<bankClients[id].getAccounts().length;x++)
		{
			if (bankClients[id].getAccounts()[x] !=null)
				validAccounts++;
		}
		for (int x=0;x<validAccounts;x++)
		{
			if (bankClients[id]!=null)
			{
				//System.out.println("Bank-Account Id:"+bankClients[id].getAccounts()[x].getId());
			//	System.out.printf("Cash Amount: %.2f\n",bankClients[id].getAccounts()[x].getBalance());
				if (bankClients[id].getAccounts()[x] instanceof PremiumAccount)
				{
					PremiumAccount prem=(PremiumAccount) bankClients[id].getAccounts()[x];
					System.out.printf(bankClients[id].getAccounts()[x].getId()+" %.2f",bankClients[id].getAccounts()[x].getBalance());
					System.out.printf(" "+prem.getFee()+" %.2f",prem.getCashback());
				
				}
				else 
				{
					System.out.printf(bankClients[id].getAccounts()[x].getId()+" %.2f",bankClients[id].getAccounts()[x].getBalance());
				}
				System.out.println();
			}	
				
		}
			presentManagementOptions(id);
			}
		

			
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("***Online Banking System***");
		System.out.println();
		System.out.println("Use Case 1. Batch Registeration");
		UserInterface userInterface = new UserInterface();
		for (short i = 0; i < 1000; i++) {
			userInterface.batchRegistration((short)i);//this is done so all the client ids are initalised
		}
		System.out.println();
		System.out.print("Enter Client Id \n> \n");
		
		short enteredId=input.nextShort();
		input.nextLine();
		
	
		boolean doesIdExist=true;
		if (enteredId <0 || enteredId >999)
		 doesIdExist = false;
		
		if (doesIdExist!=true) 
			System.out.println("Invalid Client ID entered");
		else 
		
			userInterface.presentManagementOptions(enteredId);
	
		
		
}
}
