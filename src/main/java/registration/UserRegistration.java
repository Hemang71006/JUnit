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
}
