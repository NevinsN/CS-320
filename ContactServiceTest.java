package test;

import org.junit.jupiter.api.*;

import main.Contact;
import main.ContactService;

public class ContactServiceTest {

	ContactService conServTest = new ContactService();
	Contact contact;

	// addContact() is present in the setUp() for efficiency. It is tested individually below.
	@BeforeEach
	public void setUp() {
		contact = new Contact("1", "John", "Doe", "5555555555", "123 Hi Way");
		conServTest.addContact(contact);
	}
	
	@Test
	@Tag("AddContact")
	public void testAddContact() {
		// When
		Contact testContact = new Contact("2", "John", "Doe", "5555555555", "123 Hi Way");
		
		// Then
		Assertions.assertTrue(conServTest.addContact(testContact));
	}

	@Test
	@Tag("DuplicateID")
	public void testAddContactWithDuplicate() {
		// Then 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {conServTest.addContact(contact);});
	}


	
	@Test
	@Tag("EditFirstName")
	public void testEditFirstName () {
		// When
		conServTest.setFirstName("1", "Luke");
		
		// Then 
		Assertions.assertTrue(conServTest.returnContacts().get("1").getFirstName().equals("Luke"));
	}
	
	@Test
	@Tag("EditFirstNameInvalidInput")
	public void testEditFirstNameWithError () {
		// Then (null)
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setFirstName("1", null); } );
		
		// Then (length) 
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setFirstName("1", "12345678910");} );
	}

	@Test
	@Tag("EditLastName")
	public void testEditLastName() {
		// When
		conServTest.setLastName("1", "Skywalker");
		
		// Then 
		Assertions.assertTrue(conServTest.returnContacts().get("1").getLastName().equals("Skywalker"));
	}

	@Test
	@Tag("EditLastNameInvalidInput")
	public void testEditLastNameWithError () {
		// Then (null)
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setLastName("1", null); } );
		
		// Then (length) 
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setLastName("1", "12345678910");} );
	}

	@Test
	@Tag("EditLastName")
	public void testEditNumber() {
		// When
		conServTest.setNumber("1", "0123456789");
		
		// Then 
		Assertions.assertTrue(conServTest.returnContacts().get("1").getNumber().equals("0123456789"));
	}

	@Test
	@Tag("EditNumberInvalidInput")
	public void testEditNumberWithError () {
		// Then (null)
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setNumber("1", null); } );
		
		// Then (length) 
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setNumber("1", "12345678910");} );

		// Then (non-digits)
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setNumber("1", "Yo ho ho"); } );
	}	
		
	@Test
	@Tag("EditAddress")
	public void testEditAddress() {
		// When
		conServTest.setAddress("1", "0123456789");
		
		// Then 
		Assertions.assertTrue(conServTest.returnContacts().get("1").getAddress().equals("0123456789"));
	}

	@Test
	@Tag("EditAddressInvalidInput")
	public void testEditAddressWithError () {
		// Then (null)
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setAddress("1", null); } );
		
		// Then (length) 
		Assertions.assertThrows(IllegalArgumentException.class, () -> { conServTest.setAddress("1", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");} );
	}
	
	@Test
	@Tag("Delete")
	public void testRemoveContactByID() {
		// When
		conServTest.removeContactByID("1");
		
		// Then
		Assertions.assertTrue(conServTest.returnContacts().size() == 0);
	}
}
