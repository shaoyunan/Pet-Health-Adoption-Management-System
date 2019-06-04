/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.PetHealth;

import Business.Animal.Pet.Pet;
import Business.WorkQueue.WorkRequest;
import java.util.Date;

/**
 *
 * @author shaoy
 */
public class PetHealthWorkRequest extends WorkRequest{
    private Pet pet;
    private Date sickDate;
    private String advice;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getSickDate() {
        return sickDate;
    }

    public void setSickDate(Date sickDate) {
        this.sickDate = sickDate;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
    
}
