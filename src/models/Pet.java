package models;

import java.util.Objects;

public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private String color;

    public Pet() {}

    public Pet(String name, String species, int age, String color){
        this.name=name;
        this.species = species;
        this.age = age;
        this.color = color;

    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    public int getAge(){
        return age;
    }

    public String getColor(){
        return color;
    }

    public int getId() {
        return id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString(){
        return "Pet name: " + name + ", information: " + species +", " + age + "years old" + ", pet color: " + color;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof Pet){
            return false;
        }
        Pet p = (Pet) o;
        return age == p.age && name.equals(p.name) && species.equals(p.species) && color.equals(p.color);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, species, age, color);
    }
}