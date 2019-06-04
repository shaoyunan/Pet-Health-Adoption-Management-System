/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class AppointmentList {

    private ArrayList<Appointment> al;
    DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public ArrayList<Appointment> getAl() {
        return al;
    }

    public void setAl(ArrayList<Appointment> al) {
        this.al = al;
    }

    public AppointmentList() {
        this.al = new ArrayList<>();
    }

    public Appointment AddAppointment() {
        Appointment a = new Appointment();
        al.add(a);
        return a;
    }

    public void DeleteAppointment(Appointment a) {
        for (Appointment a1 : al) {
            if (a1.getId() == a.getId()) {
                al.remove(a1);
                break;
            }
        }

    }

    public boolean findAppointment(Date d1, Date d2) {
        if (al.size() > 0) {
            for (Appointment a : al) {

//      System.out.println(a.getStarttime().compareTo(d1));
//    System.out.println("Starttime:"+dateformat.format(a)+"   "+dateformat.format(d1));
                if (DateEqual(a.getStarttime(), d1) && DateEqual(a.getEndtime(), d2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DateEqual(Date d1, Date d2) {
        if (d1.getYear() != d2.getYear()) {
            return false;
        }
        if (d1.getMonth() != d2.getMonth()) {
            return false;
        }
        if (d1.getDate() != d2.getDate()) {
            return false;
        }
        if (d1.getHours() != d2.getHours()) {
            return false;
        }
        if (d1.getMinutes() != d2.getMinutes()) {
            return false;
        }
        return true;
    }

}
