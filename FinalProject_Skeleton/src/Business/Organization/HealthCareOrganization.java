/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Animal.Pet.PetDirectory;
import Business.Role.EmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;
import Business.WorkQueue.Adoption.AdoptionRequestQueue;
import Business.WorkQueue.Adoption.AdoptionInfo;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author shaoy
 */
public class HealthCareOrganization extends Organization{

    private PetDirectory petDirectory;
    private AdoptionRequestQueue adoptionRequestQueue;
    private ArrayList<AdoptionInfo> adoptionInfoList;
    
    public HealthCareOrganization() {
        super(Type.HealthCare.getValue());
        this.petDirectory = new PetDirectory();
        this.adoptionRequestQueue = new AdoptionRequestQueue();
        this.adoptionInfoList = new ArrayList<AdoptionInfo>();
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
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EmployeeRole());
        return roles;
    }
    
}
