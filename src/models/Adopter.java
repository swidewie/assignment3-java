package models;

public class Adopter extends Person {
    private String phoneNumber;
    private String WantTo;

    public Adopter(String name, int age, String phoneNumber, String WantTo) {
        super(name, age);
        this.phoneNumber = phoneNumber;
        this.WantTo = WantTo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWantTo(){
        return WantTo;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setWantTo(String WantTo){
        this.WantTo = WantTo;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Adopter: " + getName() + ", Age: " + getAge() + ", phoneNumber: "
                        + phoneNumber + ", Want to adopt: " + WantTo
        );
    }

    @Override
    public String toString() {
        return "Adopter name: " + getName() + ", Information: " + getAge() + " years old, phone number: " + phoneNumber;
    }
}
