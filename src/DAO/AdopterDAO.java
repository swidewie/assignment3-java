package DAO;
import models.Adopter;
import models.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdopterDAO {

    public void save(Adopter adopter) {
        String sql = "INSERT INTO adopter(name, age, phone_number, want_to) VALUES (?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, adopter.getName());
            stmt.setInt(2, adopter.getAge());
            stmt.setString(3, adopter.getPhoneNumber());
            stmt.setString(4, adopter.getWantTo());
            stmt.executeUpdate();

            System.out.println("Adopter added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Adopter> findAll() {
        List<Adopter> list = new ArrayList<>();
        String sql = "SELECT * FROM adopter";

        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Adopter a = new Adopter(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("phone_number"),
                        rs.getString("want_to")
                );
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updatePhone(int id, String newPhone) {
        String sql = "UPDATE adopter SET phone_number=? WHERE id=?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newPhone);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Phone updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM adopter WHERE id=?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Adopter deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}