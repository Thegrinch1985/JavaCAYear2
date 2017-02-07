/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author x00128429
 *
 */
@NamedQuery(name = "Passengers.findPassengers",
        query = "SELECT p FROM Passengers p order by p.pass_id")
@Entity
@Table(name = "passengers")
@SuppressWarnings("SerializableClass")
@SequenceGenerator(name = "pid_seq", initialValue = 1, allocationSize = 1)
public class Passengers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_seq")
    private int pass_id;
    //@ManyToMany (cascade = CascadeType.PERSIST)
    private String pass_name;
    @Temporal(TemporalType.DATE)
    private Calendar pass_dob;

    @ManyToMany(mappedBy = "passList")
    @OneToMany(mappedBy = "route_id")
    private List<Ticket> tlist = new ArrayList<>();

    public Passengers() {

    }

    public Passengers(String pass_name, Calendar pass_dob) {

        this.pass_name = pass_name;
        this.pass_dob = pass_dob;

    }

    public int getPass_id() {
        return pass_id;
    }

    public String getPass_name() {
        return pass_name;
    }

    public void setPass_name(String pass_name) {
        this.pass_name = pass_name;
    }

    public Calendar getPass_dob() {
        return pass_dob;
    }

    public void setPass_dob(Calendar pass_dob) {
        this.pass_dob = pass_dob;
    }

    public List<Ticket> getTlist() {
        return tlist;
    }

    public void setTlist(List<Ticket> tlist) {
        this.tlist = tlist;
    }

    @Override
    public String toString() {

        String d = String.format("%1$s %2$tB %2$td, %2$tY", "", pass_dob);
        return "Passenger ID : \t" + pass_id + "\nPassenger Name : \t " + pass_name + "\nDate of Birth : \t " + d;

    }
}
