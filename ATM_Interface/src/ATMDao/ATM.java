package ATMDao;

import java.util.Scanner;

public class ATM {
	
	public static int takeIntrgerInput(int limit) {
		int input_value=0;
		boolean flag = false;
		
		while (!flag) {
			try {
				Scanner s1=new Scanner(System.in);
				input_value=s1.nextInt();
				flag=true;
				if(flag && input_value>limit || input_value<1) {
					System.out.println("Choose the number between 1 to" + limit);
					flag= false;
					
				}
				
			}catch(Exception e) {
				System.out.println("Enter only Integer value");
				flag= false;
			}
		};
		return input_value;
	}

	public static void main(String[] args) {
		
     System.out.println("\n**** WELCOME TO ATM ****\n");
     System.out.println("1.Register \n2.Exit");
     System.out.println("Enter your Option:");
     int ch=takeIntrgerInput(2);
     
     if (ch==1) {
    	 bankAccount b= new bankAccount();
    	 b.registration();
    	 while(true) {
    		 System.out.println("\n1.Login \n2.Exit");
    		 System.out.println("Enter your Option:");
    		 int c=takeIntrgerInput(2);
    		 if(c==1) {
    			 if(b.login()) {
    				 System.out.println("\n\n **** Welcome To" + b.name +"*****\n");
    				 boolean isFinished =false;
    				 while(!isFinished) {
    				System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check balance \n5.History" );
    			    System.out.println("Enter your Option:");
    			    int c1=takeIntrgerInput(6);
    			    switch(c1) {
    			    case 1:
    			    	b.withdraw();
    			    	break;
    			    case 2:
    			    	b.deposit();
    			    	break;
    			    case 3:
    			    	b.transfer();
    			    	break;
    			    case 4:
    			    	b.check_Balance();
    			    	break;
    			    case 5:
    			    	b.trans_History();
    			    	break;
    			    case 6:
    			    	isFinished=true;
    			    	break;
    			    }
    				 }
    			 }
    		 }
    		 else {
    			 System.exit(0);
    		 }
    	 }
     }
     else {
		 System.exit(0);
	 }
	}

}