package registration;

public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        return firstName != null
                && firstName.matches("[A-Z][a-zA-Z]{2,}");
    }
}
