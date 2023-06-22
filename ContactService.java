package main;

import java.util.*;

public class ContactService {
	// Creates a Map to hold the contact objects
	Map<String, Contact> contacts = new HashMap<String, Contact>();
	
	// Method to add new contact to contacts ArrayList
	public boolean addContact(Contact contact) {
		// Verify if ID is in map contacts
		if (contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Duplicate ID");
		}

		// Adds contact to contacts ArrayList and returns true to verify success
		contacts.put(contact.getContactID(), contact);
		return true;
	}
	
	// Method to remove an element from contacts ArrayList by contactID
	public void removeContactByID(String contactID) {
		// Finds if contactID is in contacts and removes it
		if(contacts.containsKey(contactID)) {
			contacts.remove(contactID);
		}	
	}
	
	// Method to update firstName for a contactID
	public void setFirstName(String contactID, String name) {		
		// Check that ensures the first name is not null and not over 10 characters
		if (contacts.get(contactID).validateInput(name, 10) == false) {
			throw new IllegalArgumentException("Invalid First Name");
		}

		// Finds and edits a first name by id
		if(contacts.containsKey(contactID)) {
			contacts.get(contactID).setFirstName(name);
		}
	}
	
	// Method to update lastName for a contactID
	public void setLastName(String contactID, String name) {
		// Check that ensures the last name is not null and not over 10 characters
		if (contacts.get(contactID).validateInput(name, 10) == false) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		// Finds and edits a last name by id
		if(contacts.containsKey(contactID)) {
			contacts.get(contactID).setLastName(name);
		}
	}
	
	// Method to update Number for a contactID
	public void setNumber(String contactID, String Number) {
		// Check that ensures that the phone number is not null and no longer than 10 characters
		if (contacts.get(contactID).validateInput(Number, 10) == false || Number.matches("\\d{10}") == false) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		// Finds and edits a number by id
		if(contacts.containsKey(contactID)) {
			contacts.get(contactID).setNumber(Number);
		}
	}
	
	// Method to update Address for a contactID
	public void setAddress(String contactID, String Address) {
		// Check that ensures that the address is not null and no longer than 30 digits
		if (contacts.get(contactID).validateInput(Address, 30) == false) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// Finds and edits an address by id
		if(contacts.containsKey(contactID)) {
			contacts.get(contactID).setAddress(Address);
		}
	}

	// Method to return constactrs for testing only
	public Map<String, Contact> returnContacts() {
		return this.contacts;
	}
}
