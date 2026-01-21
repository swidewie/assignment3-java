
import models.Adopter;
import models.Pet;
import models.Shelter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();

        System.out.print("Pet name: ");
        String petName = scanner.nextLine();
        System.out.print("Species: ");
        String petSpecies = scanner.nextLine();
        System.out.print("Age: ");
        int petAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Pet name2: ");
        String petName2 = scanner.nextLine();
        System.out.print("Species2: ");
        String petSpecies2 = scanner.nextLine();
        System.out.print("Age2: ");
        int petAge2 = scanner.nextInt();
        scanner.nextLine();

        Pet pet1 = new Pet(petName, petSpecies, petAge);
        Pet pet2 = new Pet(petName2, petSpecies2, petAge2);

        pets.add(pet1);
        pets.add(pet2);

        System.out.println(pet1);
        System.out.println(pet2);

        System.out.print("Adopter name: ");
        String adopterName = scanner.nextLine();
        System.out.print("Phone number: ");
        String adopterPhoneNumber = scanner.nextLine();
        System.out.print("Age: ");
        int adopterAge = scanner.nextInt();
        scanner.nextLine();

        Adopter adopter = new Adopter(adopterName, adopterAge, adopterPhoneNumber);
        adopter.showInfo();

        System.out.print("Shelter name: ");
        String shelterName = scanner.nextLine();
        System.out.print("Location: ");
        String shelterLocation = scanner.nextLine();
        System.out.print("ID: ");
        int shelterId = scanner.nextInt();
        scanner.nextLine();

        Shelter shelter = new Shelter(shelterId, shelterName, shelterLocation);
        System.out.println(shelter);


        System.out.println("Pets older than 3:");
        for (Pet p : pets) {
            if (p.getAge() > 3) {
                System.out.println(p.getName());
            }
        }

        System.out.println("Search by name: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Pet p : pets) {
            if (searchName.equals(p.getName())) {
                System.out.println("Found: " + p.getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Pet not found!");
        }

        for (int i = 0; i < pets.size() - 1; i++) {
            int age1 = pets.get(i).getAge();
            int age2 = pets.get(i + 1).getAge();

            if (age1 > age2) {
                Pet temp = pets.get(i);
                pets.set(i, pets.get(i + 1));
                pets.set(i + 1, temp);
            }
        }

        System.out.println("Pets sorted by age:");
        for (Pet p : pets) {
            System.out.println(p.getName());
        }

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.println("\nConnected to DB!");

            // INSERT 2 pets
            insertPet(conn, pet1.getName(), pet1.getSpecies(), pet1.getAge());
            insertPet(conn, pet2.getName(), pet2.getSpecies(), pet2.getAge());

            // READ pets
            System.out.println("\nPets in database:");
            readPets(conn);

            // UPDATE pet with ID = 1
            System.out.println("\nUpdating pet age for ID = 1...");
            updatePetAge(conn, 1, 10);

            // DELETE pet with ID = 2
            System.out.println("Deleting pet with ID = 2...");
            deletePet(conn, 2);

            // READ AGAIN
            System.out.println("\nPets after update/delete:");
            readPets(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPet(Connection conn, String name, String species, int age) throws SQLException {
        String sql = "INSERT INTO pet(name, species, age) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, species);
        ps.setInt(3, age);
        ps.executeUpdate();
        System.out.println("Inserted: " + name);
    }

    public static void readPets(Connection conn) throws SQLException {
        String sql = "SELECT * FROM pet";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("species") + " | " +
                            rs.getInt("age")
            );
        }
    }

    public static void updatePetAge(Connection conn, int id, int newAge) throws SQLException {
        String sql = "UPDATE pet SET age = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, newAge);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Age updated.");
    }

    public static void deletePet(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM pet WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Pet deleted.");
    }
}
