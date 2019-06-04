/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.Adoption;

import Business.Animal.Pet.Pet;
import java.util.Date;

/**
 *
 * @author shaoy
 */
public class AdoptionInfo {
    private Pet pet;
    private Date date;
    private String information;
    private static int count;
    private int id;
    public AdoptionInfo(){
        count++;
        id = count;
        this.date = new Date();
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return String.valueOf(id);
    }
}
