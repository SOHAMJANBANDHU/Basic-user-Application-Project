package basicApplication.MainController;

import java.util.Scanner;

import basicApplication.DAO.BasicApplicationCRUD;
import basicApplication.DTO.BasicApplication;

public class BasicApplication_MainController {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		BasicApplication basic = new BasicApplication();
		BasicApplicationCRUD crud = new BasicApplicationCRUD();
		
		System.out.println("Enter the choice \n1. Sign UP \n2. Login \n3. Exit \n");
		int choice = scan.nextInt();
		
		switch (choice)
		{
		case 1:
		{
			System.out.println("Enter the ID");
			basic.setId(scan.nextInt());
			
			System.out.println("Enter the Name");
			basic.setName(scan.next());
			
			System.out.println("Enter the Email");
			basic.setEmail(scan.next());
			
			System.out.println("Enter the Password");
			basic.setPassword(scan.next());
			
			System.out.println("Enter the Phone Number");
			basic.setPhone(scan.nextLong());
			
			crud.signupApplication(basic);
			
			System.out.println("Sign Up Successful...");
			break;
			
		}
		case 2:
		{
			System.out.println("Enter the email");
			String email = scan.next() ;
			System.out.println("Enter the password");
			String password  = scan.next() ;
			
			boolean result = crud.loginUser(email, password);
			if(result == true)
			{
				System.out.println("Logged In successful");
				crud.displayPassword(email) ;
				System.out.println("Enter the choice \n1. Update Password \n2. Exit");
				int key = scan.nextInt() ;
				switch (key)
				{
					case 1:
					{
						System.out.println("Enter the facebook");
						basic.setFacebook(scan.next());
						System.out.println("Enter the Instagram");
						basic.setInstagram(scan.next());
						System.out.println("Enter the Snapchat");
						basic.setSnapchat(scan.next());
						System.out.println("Enter the Whatsapp");
						basic.setWhatsapp(scan.next());
						System.out.println("Enter the Twitter");
						basic.setTwitter(scan.next());
						
						crud.updatePasswords(basic,email) ;
						break;
					}
					case 2:
					{
						System.out.println("\n Are you sure to close program..? \n1. yes \n2.no");
						int cl = scan.nextInt();
						switch(cl)
						{
							case 1:
							{
								crud.close();
								break;
							}
							case 2:
							{
								System.out.println("bye bye..");
								break;
							}
						}
					}
					case 3:
					{
						crud.close();
						
					}
					default:
					{
						break;
					}
				}
				
			}
			else
			{
				System.out.println("Invalid credentials");
			}
		}
			default:
			{
				break;
			}
		}
	}
}
