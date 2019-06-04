/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.Adoption;

import Business.Animal.Pet.Pet;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author shaoy
 */
public class AdoptionRequest extends WorkRequest {

    private String respond;
    private Pet pet;

    public AdoptionRequest() {
        super();
    }

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

}
