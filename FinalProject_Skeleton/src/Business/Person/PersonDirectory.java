/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author shaoy
 */
public class PersonDirectory {

    private ArrayList<Person> personList;

    public PersonDirectory() {
        this.personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public Person CreatePerson() {
        Person p = new Person();
        personList.add(p);
        return p;
    }
    
    public void deletePerson(Person p){
        personList.remove(p);
    }
}
