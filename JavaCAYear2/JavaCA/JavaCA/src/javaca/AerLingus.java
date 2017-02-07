/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaca;

import javax.persistence.*;

@Entity
@Table(name = "plane")
@DiscriminatorValue(value = "AerLingus")

@SuppressWarnings("SerializableClass")

public class AerLingus extends Plane {

    private int noStaff;

    public AerLingus() {
        super();
        noStaff = 0;
    }

    public AerLingus(String idIn, int capacityIn, int noStaffIn) {
        super(idIn, capacityIn);
        noStaff = noStaffIn;
    }

    public int getNoStaff() {
        return noStaff;
    }

    public void setNoStaff(int noStaff) {
        this.noStaff = noStaff;
    }

    @Override
    public String toString() {
        operator();
        return super.toString() + "\nNo. Staff: \t" + noStaff;
    }

    public void addRoute(Route r1) {
        super.getRlist().add(r1);
        r1.getPlist().add(this);
    }

    @Override
    public String operator() {
        return "Aer Lingus";

    }

}
