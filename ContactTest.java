package test;

import org.junit.jupiter.api.*;

import main.Contact;

public class ContactTest {

	@Test
    @Tag("Constructor")
    void testContactClass() {
        // When
        Contact contact = new Contact("123456", "Han", "Solo", "6455558976", "345 Kessel Run");
        
        // Then
        Assertions.assertTrue(contact.getContactID().equals("123456"));
        Assertions.assertTrue(contact.getFirstName().equals("Han"));
		Assertions.assertTrue(contact.getLastName().equals("Solo"));
		Assertions.assertTrue(contact.getNumber().equals("6455558976"));
        Assertions.assertTrue(contact.getAddress().equals("345 Kessel Run"));
    }
	
	@Test
	@Tag("IdFailure")
	public void testImproperIDs() {
		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("12345678910", "Han", "Solo", "6455558976", "345 Kessel Run"); });

		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact(null, "Han", "Solo", "6455558976", "345 Kessel Run"); });

	}

	@Test
	@Tag("FirstNameFailure")
	public void testImproperFirstName() {
		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "12345678910", "Solo", "6455558976", "345 Kessel Run"); });

		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", null, "Solo", "6455558976", "345 Kessel Run"); });

	}

	@Test
	@Tag("LastNameFailure")
	public void testImproperLastName() {
		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", "12345678910", "6455558976", "345 Kessel Run"); });

		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", null, "6455558976", "345 Kessel Run"); });

	}

	@Test
	@Tag("NumberFailure")
	public void testImproperNumber() {
		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", "Solo", "12345678910", "345 Kessel Run"); });

		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", "Solo", null, "345 Kessel Run"); });

		// Assert Test (digits)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", "Solo", "Hello67891", "345 Kessel Run"); });
	}

	@Test
	@Tag("AddressFailure")
	public void testImproperAddress() {
		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", "Solo", "6455558976", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16"); });

		// Assert Test (length)
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Contact("1234", "Han", "Solo", "6455558976", null); });

	}
}
