// Cohen Gallagher - 3/7/25

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    // Error list
    public static List<String> validateClient(Client client) {
        List<String> errors = new ArrayList<>();

        if (!isValidFirstName(client.getFirstName())) {
            errors.add("First Name must not be empty and must be 50 characters or less.");
        }
        if (!isValidLastName(client.getLastName())) {
            errors.add("Last Name must not be empty and must be 50 characters or less.");
        }
        if (!isValidInitial(client.getInitial())) {
            errors.add("Initial must not be empty and must be 50 characters or less.");
        }
        if (!isValidPhoneNumber(client.getPhoneNumber())) {
            errors.add("Phone Number must not be empty and must be 50 characters or less.");;
        }
        if (!isValidZipcode(client.getZipcode())) {
            errors.add("Zipcode must be exactly 5 digits.");
        }
        if (!isValidState(client.getState())) {
            errors.add("State must not be empty and must be 50 characters or less.");;
        }
        if (!isValidCity(client.getCity())) {
            errors.add("City must not be empty and must be 50 characters or less.");;
        }
        if (!isValidPlanType(client.getPlanType())) {
            errors.add("Plan Type must not be empty and must be 50 characters or less.");;
        }

        return errors; // Return list of validation errors (empty if no errors)
    }

    // Check for correct formatting
    private static boolean isValidFirstName(String firstName) {
        return firstName != null && !firstName.trim().isEmpty() && firstName.length() <= 50;
    }

    private static boolean isValidLastName(String lastName) {
        return lastName != null && !lastName.trim().isEmpty() && lastName.length() <= 50;
    }

    private static boolean isValidInitial(String initial) {
        return initial != null && !initial.trim().isEmpty() && initial.length() <= 50;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.trim().isEmpty() && phoneNumber.length() <= 50;
    }

    private static boolean isValidZipcode(Integer zipcode) {
        return zipcode != null && String.valueOf(zipcode).length() == 5; // 5-digit zipcode
    }

    private static boolean isValidState(String state) {
        return state != null && !state.trim().isEmpty() && state.length() <= 50;
    }

    private static boolean isValidCity(String city) {
        return city != null && !city.trim().isEmpty() && city.length() <= 50;
    }

    private static boolean isValidPlanType(String planType) {
        return planType != null && !planType.trim().isEmpty() && planType.length() <= 50;
    }
}