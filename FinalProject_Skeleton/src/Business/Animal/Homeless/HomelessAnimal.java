/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Animal.Homeless;

import Business.Animal.Animal;

/**
 *
 * @author shaoy
 */
public class HomelessAnimal extends Animal {

    private static int count;
    private int id;
    private HealthCondition healthCondition;
    private boolean aggresive;

    public HomelessAnimal() {
        count++;
        id = count;
        this.aggresive = false;
    }

    public enum HealthCondition{
        Good("Good"), Fair("Fair"), Critical("Critical");
        private String value;

        private HealthCondition(String s) {
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

    public HealthCondition getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(HealthCondition healthCondition) {
        this.healthCondition = healthCondition;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAggresive() {
        return aggresive;
    }

    public void setAggresive(boolean aggresive) {
        this.aggresive = aggresive;
    }

}
