package registration;

public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        return firstName != null
                && firstName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public boolean validateLastName(String lastName) {
        return lastName != null
                && lastName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public boolean validateEmail(String email) {
        return email != null
                && email.matches(
                "^[A-Za-z0-9]+(?:[.+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(?:\\.[A-Za-z]{2,}){1,2}$"
        );
    }

    public boolean validateMobile(String mobile) {
        return mobile != null
                && mobile.matches("^[0-9]{1,3} [0-9]{10}$");
    }

    public boolean validatePasswordLength(String password) {
        return password != null && password.length() >= 8;
    }

    public boolean validatePasswordUppercase(String password) {
        return password != null && password.matches(".*[A-Z].*");
    }
}
