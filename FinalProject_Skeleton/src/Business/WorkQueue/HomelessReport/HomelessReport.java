/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.HomelessReport;

import Business.Animal.Homeless.HomelessAnimal;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author shaoy
 */
public class HomelessReport extends WorkRequest{
    private HomelessAnimal homelessAnimal;
    private String location;
    private double latitude;
    private double longitude;
    private Priority priority;
    
    public enum Priority {
        High("High"), Normal("Normal"), Low("Low");
        private String value;

        private Priority(String s) {
            this.value = s;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
    
    public HomelessAnimal getHomelessAnimal() {
        return homelessAnimal;
    }

    public void setHomelessAnimal(HomelessAnimal homelessAnimal) {
        this.homelessAnimal = homelessAnimal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
}
