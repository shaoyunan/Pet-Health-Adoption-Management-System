package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SysAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public boolean checkIfNameIsUnique(String name) {
        for (Network n : networkList) {
            if (n.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfNetworkisUnique(String name) {
        for (Network n : this.networkList) {
            if (n.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Network findNetworkbyUser(UserAccount ua) {
        for (Network n : networkList) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getUsername().equals(ua.getUsername())) {
                            return n;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SysAdminRole());
        return roleList;
    }
}
