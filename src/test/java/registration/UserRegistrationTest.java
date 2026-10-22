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
}
