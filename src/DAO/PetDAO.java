package DAO;
import models.Pet;
import models.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    public void save(Pet pet) {
        String sql = "INSERT INTO pet(name, species, age, color) VALUES (?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getSpecies());
            stmt.setInt(3, pet.getAge());
            stmt.setString(4, pet.getColor());
            stmt.executeUpdate();

            System.out.println("Pet added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> findAll() {
        List<Pet> list = new ArrayList<>();
        String sql = "SELECT * FROM pet";

        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pet p = new Pet(
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getString("color")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateColor(int id, String newColor) {
        String sql = "UPDATE pet SET color=? WHERE id=?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newColor);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Color updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM pet WHERE id=?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Pet deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
