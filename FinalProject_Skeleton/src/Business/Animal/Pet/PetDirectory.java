/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Animal.Pet;

import java.util.ArrayList;

/**
 *
 * @author shaoy
 */
public class PetDirectory {

    private ArrayList<Pet> petList;

    public PetDirectory() {
        this.petList = new ArrayList<Pet>();
    }

    public ArrayList<Pet> getPetList() {
        return petList;
    }

    public void setPetList(ArrayList<Pet> petList) {
        this.petList = petList;
    }

    public Pet addPet() {
        Pet p = new Pet();
        petList.add(p);
        return p;
    }

    public void deletePet(Pet p) {
        petList.remove(p);
    }
    
    public int countPet(){
        return petList.size();
    }
}
