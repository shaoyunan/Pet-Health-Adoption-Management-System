/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author shaoy
 */
public class Network {

    private String name;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean ifEnterpriseisUnique(String name) {
        for (Enterprise e : enterpriseDirectory.getEnterpriseList()) {
            if (e.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
