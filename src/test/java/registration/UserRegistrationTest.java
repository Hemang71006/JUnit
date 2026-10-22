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

    @Test
    void givenValidMobileNumberShouldReturnTrue() {
        assertTrue(validator.validateMobile("91 9919819801"));
    }

    @Test
    void givenMobileWithoutCountryCodeShouldReturnFalse() {
        assertFalse(validator.validateMobile("9919819801"));
    }

    @Test
    void givenMobileWithWrongNumberOfDigitsShouldReturnFalse() {
        assertFalse(validator.validateMobile("91 991981980"));
        assertFalse(validator.validateMobile("91 99198198012"));
    }

    @Test
    void givenMobileWithoutSpaceShouldReturnFalse() {
        assertFalse(validator.validateMobile("919919819801"));
    }

    @Test
    void givenPasswordWithAtLeastEightCharactersShouldReturnTrue() {
        assertTrue(validator.validatePasswordLength("Password1!"));
    }

    @Test
    void givenPasswordWithLessThanEightCharactersShouldReturnFalse() {
        assertFalse(validator.validatePasswordLength("Pass1!"));
    }

    @Test
    void givenPasswordWithUppercaseShouldReturnTrue() {
        assertTrue(validator.validatePasswordUppercase("passwordA"));
    }

    @Test
    void givenPasswordWithoutUppercaseShouldReturnFalse() {
        assertFalse(validator.validatePasswordUppercase("password1!"));
    }

    @Test
    void givenPasswordWithDigitShouldReturnTrue() {
        assertTrue(validator.validatePasswordNumber("password1"));
    }

    @Test
    void givenPasswordWithoutDigitShouldReturnFalse() {
        assertFalse(validator.validatePasswordNumber("Password!"));
    }

    @Test
    void givenPasswordWithExactlyOneSpecialCharacterShouldReturnTrue() {
        assertTrue(validator.validatePasswordSpecialCharacter("Password1!"));
    }

    @Test
    void givenPasswordWithoutSpecialCharacterShouldReturnFalse() {
        assertFalse(validator.validatePasswordSpecialCharacter("Password12"));
    }

    @Test
    void givenPasswordWithMoreThanOneSpecialCharacterShouldReturnFalse() {
        assertFalse(validator.validatePasswordSpecialCharacter("Password1!!"));
    }
}
