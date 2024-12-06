import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {
    public void addContact(String name, String phone) {
        String query = "INSERT INTO Contacts (name, phone) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt =conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.executeUpdate();
            System.out.println("Contact added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding contact: " + e.getMessage());
        }
    }

    public void viewContacts() {
        String query = "SELECT * FROM Contacts";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Contacts:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving contacts: " + e.getMessage());
        }
    }

    public void updateContact(int id, String name, String phone) {
        String query = "UPDATE Contacts SET name = ?, phone = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setInt(3, id);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("Contact not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating contact: " + e.getMessage());
        }
    }

    public void deleteContact(int id) {
        String query = "DELETE FROM Contacts WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Contact not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting contact: " + e.getMessage());
        }
    }
}
