package models;

public class Adopter extends Person {
    private String phoneNumber;

    public Adopter(String name, int age, String phoneNumber) {
        super(name, age);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Adopter: " + getName() + ", Age: " + getAge() + ", phoneNumber: " + phoneNumber
        );
    }

    @Override
    public String toString() {
        return "Adopter name: " + getName() + ", Information: " + getAge() + " years old, phone number: " + phoneNumber;
    }
}
