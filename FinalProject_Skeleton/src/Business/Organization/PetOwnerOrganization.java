/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PetOwnerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shaoy
 */
public class PetOwnerOrganization extends Organization{

    public PetOwnerOrganization() {
        super(Type.PetOwner.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PetOwnerRole());
        return roles;
    }
    
}
