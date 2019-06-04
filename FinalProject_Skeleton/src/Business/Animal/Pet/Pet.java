/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Animal.Pet;

import Business.Animal.Animal;

/**
 *
 * @author shaoy
 */
public class Pet extends Animal {

    private PetHealthInfo petHealthInfo;
    private boolean listed;
    
    public Pet() {
        this.petHealthInfo = new PetHealthInfo();
        this.listed = false;
    }

    public PetHealthInfo getPetHealthInfo() {
        return petHealthInfo;
    }

    public void setPetHealthInfo(PetHealthInfo petHealthInfo) {
        this.petHealthInfo = petHealthInfo;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }
    
}
