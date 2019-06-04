/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.Adoption;

import Business.Animal.Pet.Pet;
import Business.UserAccount.PetOwnerUserAccount;
import java.util.ArrayList;

/**
 *
 * @author shaoy
 */
public class AdoptionRequestQueue {
    private ArrayList<AdoptionRequest> adoptionRequestList;

    public AdoptionRequestQueue() {
        this.adoptionRequestList = new ArrayList<>();
    }

    public ArrayList<AdoptionRequest> getAdoptionRequestList() {
        return adoptionRequestList;
    }

    public void setAdoptionRequestList(ArrayList<AdoptionRequest> adoptionRequestList) {
        this.adoptionRequestList = adoptionRequestList;
    }

    public void deleteRequest(AdoptionRequest r) {
        adoptionRequestList.remove(r);
    }

    public AdoptionRequest addRequest() {
        AdoptionRequest a = new AdoptionRequest();
        adoptionRequestList.add(a);
        return a;
    }
    
    public boolean requestExists(PetOwnerUserAccount poua, Pet pet){
        boolean result = false;
        for(AdoptionRequest ar : adoptionRequestList){
            if(ar.getSender()==poua && ar.getPet() == pet){
                result = true;
            }
        }
        return result;
    }
}
