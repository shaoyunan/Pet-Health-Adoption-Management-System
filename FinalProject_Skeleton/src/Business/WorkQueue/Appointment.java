/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.PetOwnerUserAccount;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Appointment extends WorkRequest implements Comparable<Appointment> {

    private UserAccount da;
    private PetOwnerUserAccount ma;
    private Date starttime;
    private Date endtime;
    private Availibility avail;

    public enum Availibility {
        Busy("busy"), Free("free");
        private String st;

        private Availibility(String s) {
            this.st = s;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

    }

    public Appointment() {
        super();
        this.da = new UserAccount();
        this.ma = new PetOwnerUserAccount();

    }

    public UserAccount getDa() {
        return da;
    }

    public void setDa(UserAccount da) {
        this.da = da;
    }

    public PetOwnerUserAccount getMa() {
        return ma;
    }

    public void setMa(PetOwnerUserAccount ma) {
        this.ma = ma;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Availibility getAvail() {
        return avail;
    }

    public void setAvail(Availibility avail) {
        this.avail = avail;
    }

    @Override
    public int compareTo(Appointment a) {
        return this.getStarttime().compareTo(a.getStarttime());

    }
}
