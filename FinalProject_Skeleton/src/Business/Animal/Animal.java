/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Animal;

/**
 *
 * @author shaoy
 */
public class Animal {

    private String name;
    private Species species;
    private int age;
    private String otherSpecies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOtherSpecies() {
        return otherSpecies;
    }

    public void setOtherSpecies(String otherSpecies) {
        this.otherSpecies = otherSpecies;
    }

    public enum Species {
        Dog("Dog"), Cat("Cat"), Other("Other");
        private String kind;

        private Species(String a) {
            this.kind = a;
        }

        @Override
        public String toString() {
            return this.kind;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }
    }
    
    @Override
    public String toString(){
        return name;
    }
}
