/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Animal.Pet.PetDirectory;
import Business.WorkQueue.Adoption.AdoptionRequestQueue;
import Business.WorkQueue.Adoption.AdoptionInfo;
import Business.WorkQueue.AppointmentList;
import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;
/**
 *
 * @author shaoy
 */
public class PetOwnerUserAccount extends UserAccount {

    private PetDirectory petDirectory;
    private AdoptionRequestQueue adoptionRequestQueue;
    private ArrayList<AdoptionInfo> adoptionInfoList;
    private AppointmentList al;
    
    public PetOwnerUserAccount() {
        super();
        this.petDirectory = new PetDirectory();
        this.adoptionRequestQueue = new AdoptionRequestQueue();
        this.adoptionInfoList = new ActivatableArrayList<AdoptionInfo>();
        this.al = new AppointmentList();
    }

    public PetDirectory getPetDirectory() {
        return petDirectory;
    }

    public void setPetDirectory(PetDirectory petDirectory) {
        this.petDirectory = petDirectory;
    }

    public AdoptionRequestQueue getAdoptionRequestQueue() {
        return adoptionRequestQueue;
    }

    public void setAdoptionRequestQueue(AdoptionRequestQueue adoptionRequestQueue) {
        this.adoptionRequestQueue = adoptionRequestQueue;
    }

    public ArrayList<AdoptionInfo> getAdoptionInfoList() {
        return adoptionInfoList;
    }

    public void setAdoptionInfoList(ArrayList<AdoptionInfo> adoptionInfoList) {
        this.adoptionInfoList = adoptionInfoList;
    }

    public AppointmentList getAl() {
        return al;
    }

    public void setAl(AppointmentList al) {
        this.al = al;
    }

}
