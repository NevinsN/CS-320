package main;

public class Contact {

	private final String contactID;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	// Method to check for length and null
    public boolean validateInput(String item, int length) {
        if (item == null || item.length() > length) {
            return false;
        }
        else {
            return true;
        }
    }

	// Overloaded constructor
	public Contact(String contactID, String firstName, String lastName, String Number, String Address) {
		// Check that ensures the contactID is not null and not greater than 10 characters
		if (validateInput(contactID, 10) == false) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}

		// Check that ensures the first name is not null and not over 10 characters
		if (validateInput(firstName, 10) == false) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		// Check that ensures the last name is not null and not over 10 characters
		if (validateInput(lastName, 10)  == false) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		// Check that ensures that the phone number is not null and no longer than 10 characters
		if (validateInput(Number, 10) == false || Number.matches("\\d{10}") == false) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		// Check that ensures that the address is not null and no longer than 30 digits
		if (validateInput(Address, 30) == false) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Number = Number;
		this.Address = Address;
	}
	
	// Getter for contactID 
	public String getContactID() {
		return this.contactID;
	}
	
	 // Getter for firstName
	public String getFirstName() {
		return this.firstName;
	}
	
	// Setter for firstName
	public void setFirstName(String Name) {
		this.firstName = Name;
	}
	
	// Getter for lastName
	public String getLastName() {
		return this.lastName;
	}
	
	// Setter for lastName
	public void setLastName(String Name) {
			this.lastName = Name;
	}
	
	// Getter for Number
	public String getNumber() {
		return this.Number;
	}
	
	// Setter for Number
	public void setNumber(String Number) {
			this.Number = Number;
	}
	
	// Getter for Address
	public String getAddress() {
		return this.Address;
	}
	
	// Setter for Address
	public void setAddress(String Address) {
			this.Address = Address;
	}
}

