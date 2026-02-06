
import DAO.PetDAO;
import DAO.AdopterDAO;
import models.Pet;
import models.Adopter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PetDAO petDAO = new PetDAO();
        AdopterDAO adopterDAO = new AdopterDAO();

        while (true) {
            System.out.println("\n=== PET ADOPTION SYSTEM ===");
            System.out.println("1. Show all pets");
            System.out.println("2. Add pet");
            System.out.println("3. Update pet color");
            System.out.println("4. Delete pet");
            System.out.println("5. Show adopters");
            System.out.println("6. Add adopter");
            System.out.println("7. Update adopter phone");
            System.out.println("8. Delete adopter");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                petDAO.findAll().forEach(System.out::println);

            } else if (choice == 2) {
                System.out.print("Pet name: ");
                String name = sc.nextLine();
                System.out.print("Species: ");
                String species = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Color: ");
                String color = sc.nextLine();

                petDAO.save(new Pet(name, species, age, color));

            } else if (choice == 3) {
                System.out.print("Pet ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("New color: ");
                String color = sc.nextLine();

                petDAO.updateColor(id, color);

            } else if (choice == 4) {
                System.out.print("Pet ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                petDAO.deleteById(id);

            } else if (choice == 5) {
                adopterDAO.findAll().forEach(System.out::println);

            } else if (choice == 6) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Phone: ");
                String phone = sc.nextLine();
                System.out.print("Wants to adopt: ");
                String want = sc.nextLine();

                adopterDAO.save(new Adopter(name, age, phone, want));

            } else if (choice == 7) {
                System.out.print("Adopter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("New phone: ");
                String phone = sc.nextLine();
                adopterDAO.updatePhone(id, phone);

            } else if (choice == 8) {
                System.out.print("Adopter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                adopterDAO.deleteById(id);

            } else if (choice == 0) {
                break;
            }
        }
        sc.close();
    }
}