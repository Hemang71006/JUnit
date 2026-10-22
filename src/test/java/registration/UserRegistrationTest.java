package registration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    UserRegistration validator = new UserRegistration();

    @Test
    void givenValidFirstNameShouldReturnTrue() {
        assertTrue(validator.validateFirstName("Hemang"));
    }

    @Test
    void givenFirstNameStartingWithLowercaseShouldReturnFalse() {
        assertFalse(validator.validateFirstName("hemang"));
    }

    @Test
    void givenFirstNameShorterThanThreeCharactersShouldReturnFalse() {
        assertFalse(validator.validateFirstName("He"));
    }

    @Test
    void givenValidLastNameShouldReturnTrue() {
        assertTrue(validator.validateLastName("Jeswani"));
    }

    @Test
    void givenLastNameStartingWithLowercaseShouldReturnFalse() {
        assertFalse(validator.validateLastName("jeswani"));
    }

    @Test
    void givenLastNameShorterThanThreeCharactersShouldReturnFalse() {
        assertFalse(validator.validateLastName("Jo"));
    }

    @Test
    void givenValidEmailShouldReturnTrue() {
        assertTrue(validator.validateEmail("abc@yahoo.com"));
        assertTrue(validator.validateEmail("abc.100@abc.com.au"));
        assertTrue(validator.validateEmail("abc+100@gmail.com"));
    }

    @Test
    void givenEmailWithoutAtSymbolShouldReturnFalse() {
        assertFalse(validator.validateEmail("abc"));
    }

    @Test
    void givenEmailWithLeadingDotShouldReturnFalse() {
        assertFalse(validator.validateEmail(".abc@abc.com"));
    }

    @Test
    void givenEmailWithConsecutiveDotsShouldReturnFalse() {
        assertFalse(validator.validateEmail("abc..2002@gmail.com"));
    }

    @Test
    void givenEmailWithInvalidSuffixShouldReturnFalse() {
        assertFalse(validator.validateEmail("abc123@gmail.a"));
        assertFalse(validator.validateEmail("abc@gmail.com.1a"));
    }
}
