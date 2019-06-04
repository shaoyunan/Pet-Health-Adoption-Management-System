/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;
import Business.Organization.Organization.Type;

/**
 *
 * @author shaoy
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public Organization CreateOrganization(Type type) {
        Organization o = null;
        String t = type.getValue();
        if (t.equals(Type.Admin.getValue())) {
            o = new AdminOrganization();
        } else if (t.equals(Type.Clinic.getValue())) {
            o = new ClinicOrganization();
        } else if (t.equals(Type.HealthCare.getValue())) {
            o = new HealthCareOrganization();
        } else if (t.equals(Type.PetOwner.getValue())) {
            o = new PetOwnerOrganization();
        }
        organizationList.add(o);
        return o;
    }

    public void DeleteOrganization(Organization org) {
        organizationList.remove(org);
    }
}
