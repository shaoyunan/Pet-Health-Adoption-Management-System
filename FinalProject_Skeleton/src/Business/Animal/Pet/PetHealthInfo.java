/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Animal.Pet;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 *
 * @author shaoy
 */
public class PetHealthInfo {

    private ArrayList<VitalSign> vitalSignList;

    public PetHealthInfo() {
        this.vitalSignList = new ArrayList<VitalSign>();
    }

    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(ArrayList<VitalSign> vitalSignList) {
        this.vitalSignList = vitalSignList;
    }

    public VitalSign addVitalSign() {
        VitalSign v = new VitalSign();
        vitalSignList.add(v);
        return v;
    }

    public double getAvgByMonth(int i) {
        double total = 0;
        int count = 0;
        for (VitalSign v : vitalSignList) {
            LocalDate localDate = v.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            if(month==i){
                total+=v.getPulse();
                count+=1;
            }
        }
        return total/count;
    }
}
