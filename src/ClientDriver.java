// Cohen Gallagher - 3/7/25

import java.security.cert.TrustAnchor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientDriver {
    public static void main(String[] args) throws SQLException {

        // Test database insertion

        ArrayList<Client> clientsArray = new ArrayList<>();

        // Client client1 = new Client("Trevor", "Hoseing", "J", "332-483-232", 42432, "NY", "New York", "Recurring Monthly");

        // clientsArray.add(client1);

        for (Client c : clientsArray){
            if(ClientDatabaseManager.insertClient((c)))
                System.out.println("Successfully added " + c);
            else
                System.out.println("Failed to insert " + c);
        }
        System.out.println("Getting all clients: ");
        ArrayList<Client> allClients = ClientDatabaseManager.getAllClients();
        for (Client c : allClients)
            System.out.println(c);

        Scanner scan = new Scanner(System.in);
        System.out.print("Get client by id. Enter client id: ");

        int clientID = scan.nextInt();
        Client client = ClientDatabaseManager.getClientById(clientID);

        System.out.println(client.toString());

        Boolean success = null;
        do {
            // Add a new client
            System.out.println("***********Create new client*********** \n");
            scan.nextLine(); // consume leftover new line before taking input
            System.out.print("Enter First Name: ");
            String firstName = scan.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scan.nextLine();

            System.out.print("Enter Initial: ");
            String initial = scan.nextLine();

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scan.nextLine();

            System.out.print("Enter Zipcode: ");
            int zipcode = scan.nextInt();

            System.out.print("Enter State: ");
            String state = scan.nextLine();

            System.out.print("Enter City: ");
            String city = scan.nextLine();

            System.out.print("Enter Plan Type: ");
            String planType = scan.nextLine();

            // Add new client to DB
            Client addNewClient = new Client(firstName, lastName, initial, phoneNumber, zipcode, state, city, planType);
            List<String> errors = ClientValidator.validateClient(addNewClient);
            if (errors.isEmpty()) {
                ClientDatabaseManager.insertClient(addNewClient);
                System.out.println("Client added successfully: " + addNewClient);
                success = true;
            } else {
                System.out.println("Invalid client entry! Try again");
                for (String error : errors) {
                    System.out.println(" - " + error);
                    success = false;
                }
            }
        } while (!success);
    }
}

