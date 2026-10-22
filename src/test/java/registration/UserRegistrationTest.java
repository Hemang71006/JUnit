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

    @Test
    void validateAllProvidedEmailSamples() {
        // Valid emails from the assignment
        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        for (String email : validEmails) {
            assertTrue(validator.validateEmail(email), "Should accept: " + email);
        }

        // Invalid emails from the assignment
        String[] invalidEmails = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };

        for (String email : invalidEmails) {
            assertFalse(validator.validateEmail(email), "Should reject: " + email);
        }
    }

    @Test
    void happyPathShouldAcceptValidRegistrationInputs() {
        assertTrue(validator.validateFirstName("Hemang"));
        assertTrue(validator.validateLastName("Jeswani"));
        assertTrue(validator.validateEmail("abc.xyz@bl.co.in"));
        assertTrue(validator.validateMobile("91 9919819801"));

        // Password meets UC5, UC6, UC7, and UC8
        String password = "Password1!";

        assertTrue(validator.validatePasswordLength(password));
        assertTrue(validator.validatePasswordUppercase(password));
        assertTrue(validator.validatePasswordNumber(password));
        assertTrue(validator.validatePasswordSpecialCharacter(password));
    }

    @Test
    void sadPathShouldRejectInvalidRegistrationInputs() {
        assertFalse(validator.validateFirstName("he"));
        assertFalse(validator.validateLastName("jes"));
        assertFalse(validator.validateEmail("invalid-email"));
        assertFalse(validator.validateMobile("9919819801"));

        // Password fails the individual rules
        assertFalse(validator.validatePasswordLength("Pass1!"));
        assertFalse(validator.validatePasswordUppercase("password1!"));
        assertFalse(validator.validatePasswordNumber("Password!"));
        assertFalse(validator.validatePasswordSpecialCharacter("Password12"));
    }
}
