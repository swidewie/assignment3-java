package models;

import java.util.Objects;

public class Pet {
    private String name;
    private String species;
    private int age;

    public Pet(String name, String species, int age){
        this.name=name;
        this.species = species;
        this.age = age;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Pet name: " + name + ", information: " + species +", " + age + "years old";
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
        return age == p.age && name.equals(p.name) && species.equals(p.species);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, species, age);
    }
}