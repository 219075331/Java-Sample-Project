import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Contact> contacts;
	private static Scanner scanner;
	private static int id = 0;

	public static void main(String[] args) {
		
		contacts = new ArrayList<>();
		System.out.println("Welcome to programing world");
		
		showInitialOptions();
		

	}
	
	private static void showInitialOptions() {
		System.out.println("Please select one: "+
				"\n\t1. Manage Contacts" +
				"\n\t2. Message" + 
				"\n\t3. Quit");
		
		scanner = new Scanner(System.in);
		
		int choice = scanner.nextInt();
		
		switch(choice) {		
		case 1: 
			manageContacts();
			break;
		case 2:
			manageMessages();
			break;
		default:
			break;
		}
	}
	
	
	
	private static void manageMessages() {
		System.out.println("Please select one:" +
				"\n\t1. Show all messages" +
				"\n\t2. Send a new message" +
				"\n\t3. Go Back");
		
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			showAllMessage();
			break;
		
		case 2:
			sendNewMessage();
			break;
			
		default:
			showInitialOptions();
			break;
		}
	}		

	private static void sendNewMessage() {
		System.out.println("Who are you going to send a message?");
		String name = scanner.next();
		if(name.equals("")) {
			System.out.println("Please enter the name of the contact");
		}else {
			boolean doesExist = false;
			for(Contact c : contacts) {
				if(c.getName().equals(name)) {
					doesExist = true;
				}
			}
			if(doesExist) {
				System.out.println("What are you going to say?");
				String text = scanner.next();
				if(text.equals("")) {
					System.out.println("Please enter some messages.");
					sendNewMessage();
				}else {
					id++;
					Message newMessage = new Message(text,name,id);
					for(Contact c : contacts) {
						if(c.getName().equals(name)) {
							ArrayList<Message> newMessages = c.getMessage();
							newMessages.add(newMessage);
							c.setMessage(newMessages);
						}
					}
					
				}
			}else {
				System.out.println("There is no such contact");
			}
		}
		showInitialOptions();
		
	}

	private static void showAllMessage() {
		
		ArrayList<Message> allMessage = new ArrayList<>();
		for(Contact c : contacts) {
			allMessage.addAll(c.getMessage());
		}
		if(allMessage.size()>0) {
			for(Message m : allMessage) {
				m.getDetail();
				System.out.println("**********************");
			}
		}else{
			System.out.println("You don't have any message");			
		}
		
		showInitialOptions();
		
	}

	private static void manageContacts() {
		System.out.println("Please select one: "+
				"\n\t1. Show all contacts" +
				"\n\t2. Add a new contact" +
				"\n\t3. Search for a contact" +
				"\n\t4. Delete a contact" +
				"\n\t5. Go back");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			showAllContacts();
			break;
		case 2:
			addNewContact();
			break;
		case 3:
			searchForContact();
			break;
		case 4:
			deleteContact();
			break;
		default:
			showInitialOptions();	
			break;
		}
	}	
	
	private static void deleteContact() {
		System.out.println("Please enter the contact's name:");
		String name = scanner.next();
		if(name.equals("")) {
			System.out.println("Please enter the contact's name");
			deleteContact();
		}else {			
			boolean doesExist = false;
			for(Contact c : contacts) {
				if(c.getName().equals(name)) {
					doesExist = true;
					contacts.remove(c);
					System.out.println(name + " deleted sccessfully!");
					break;
				}
			}
			if(!doesExist) {
				System.out.println("There is no such contact");
			}
		}	
		
		showInitialOptions();				
	}

	private static void searchForContact() {
		System.out.println("Please enter the contact name: ");
		String name = scanner.next();
		if(name.equals("")) {
			System.out.println("Please enter the name");
			searchForContact();
		}else {
			boolean doesExist = false;
			for(Contact c : contacts) {
				if(c.getName().equals(name)) {
					doesExist = true;
					c.getDetails();
				}
			}
			if(!doesExist) {
				System.out.println("There is no such contact in your phone");
			}
		}
		
		showInitialOptions();
	}

	private static void addNewContact() {
		
		System.out.println("Adding a new contact...." + 
				"\nPlease enter the contact's name: ");
		String name = scanner.next();
		
		System.out.println("Please enter the contact's number: ");
		String number = scanner.next();
		
		System.out.println("Please enter the contact's email");
		String email = scanner.next();
		
		if(name.equals("") || number.equals("") || email.equals("")) {
			System.out.println("Please enter aa of the information");
			addNewContact();			
		}else {
			boolean doesExist = false;
			for(Contact c : contacts){
				if(c.getName().equals(name)) {
					doesExist = true;
				}				
			}
			if(doesExist) {
				System.out.println("We have a contact named " + name + " saved on this device");
				addNewContact();
			}else {
				Contact contact = new Contact(name,number,email);
				contacts.add(contact);
				System.out.println(name + " added successfully!");
			}			
		}
		
		showInitialOptions();	
		
	}

	private static void showAllContacts() {
		if(contacts.size()>0) {
			for(Contact c: contacts) {
				c.getDetails();
				System.out.println("********************");
			}
			
		}else {
			System.out.println("You don't have any contact");
			
		}	
		
		showInitialOptions();
	}
	
	
	
	
	

}
