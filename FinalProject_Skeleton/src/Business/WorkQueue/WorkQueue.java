/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.WorkQueue.HomelessReport.HomelessReport;
import Business.WorkQueue.PetHealth.PetHealthWorkRequest;
import java.util.ArrayList;
import org.joda.time.DateTime;
import Business.WorkQueue.WorkRequest.Status;

/**
 *
 * @author shaoy
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void resetPriority() {
        for (WorkRequest w : workRequestList) {
            if (w instanceof HomelessReport) {
                HomelessReport h = (HomelessReport) w;
                DateTime date = new DateTime(h.getRequestDate());
                DateTime today = new DateTime();
                if (date.isBefore(today.minusDays(15))) {
                    h.setPriority(HomelessReport.Priority.High);
                }
            }
        }
    }

    public int getTotalReport() {
        int count = 0;
        for (WorkRequest w : workRequestList) {
            if(w instanceof HomelessReport){
                count+=1;
            }
        }
        return count;
    }
}
