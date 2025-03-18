// Cohen Gallagher - 3/7/25

import java.sql.*;
import java.util.ArrayList;

public class ClientDatabaseManager {

    // Connect to the database
    private static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:sqlserver://java-sql-necc-work.database.windows.net:1433;database=JavaSQLDB2;user=necc@java-sql-necc-work;password=N0rtheast123!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        return DriverManager.getConnection(url);
    }
    public static boolean insertClient(Client client) throws SQLException {
        String sql = "INSERT INTO clients (firstName, lastName, initial, phoneNumber, zipcode, state, city, planType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Statements fpr insertions
        try (Connection conn = connectToDatabase()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, client.getFirstName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getInitial());
            stmt.setString(4, client.getPhoneNumber());
            stmt.setInt(5, client.getZipcode());
            stmt.setString(6, client.getState());
            stmt.setString(7, client.getCity());
            stmt.setString(8, client.getPlanType());

            int rowsAffected = stmt.executeUpdate();

            // Retrieve generated ID
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        System.out.println("Inserted client with ID: " + generatedId);
                    }
                }
            }
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get clients from database
    public static ArrayList<Client> getAllClients() throws SQLException {
        String sql = "SELECT [Id], [firstName], [lastName], [initial], [phoneNumber], [zipcode], [state], [city], [planType] FROM [dbo].[clients]";
        ArrayList<Client> clientList = new ArrayList<>();

        try (Connection conn = connectToDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) { // Loop through all rows in the ResultSet
                clientList.add(new Client(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("initial"),
                        rs.getString("phoneNumber"),
                        rs.getInt("zipcode"),
                        rs.getString("state"),
                        rs.getString("city"),
                        rs.getString("planType")
                ));
            }
        }

        return clientList; // Return the list of clients (empty if no clients found)
    }

    // Retrieve a client based on ID
    public static Client getClientById(int ClientId) throws SQLException {
        String sql = "SELECT [Id], [firstName], [lastName], [initial], [phoneNumber], [zipcode], [state], [city], [planType] FROM [dbo].[clients]\" WHERE Id = ?";

        try (Connection conn = connectToDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ClientId); // Set client ID in query

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // If a client is found
                    return new Client(
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("initial"),
                            rs.getString("phoneNumber"),
                            rs.getInt("zipcode"),
                            rs.getString("state"),
                            rs.getString("city"),
                            rs.getString("planType")
                    );
                }
            }
        }
        return null; // No client found
    }
}
