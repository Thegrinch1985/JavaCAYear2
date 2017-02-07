/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaca;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author x00128429
 */
@NamedQuery(query = "SELECT t FROM Ticket t where t.route_id = :route_id",
        name = "Ticket.findTickets")
@Entity
@Table(name = "ticket")
@SuppressWarnings("SerializableClass")
public class Ticket {

    @Id
    private String ticket_id;
    private String ticket_type;
    private double ticket_cost;
    private String route_id;
    @ManyToMany(cascade = CascadeType.ALL)
    @OrderBy
    @JoinTable(name = "booking",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "pass_id"))
    
    private List<Passengers> passList = new ArrayList<>();

    public Ticket() {

    }

    public Ticket(String ticket_id, String ticket_type, double ticket_cost, String route_id) {

        this.ticket_id = ticket_id;
        this.ticket_type = ticket_type;
        this.ticket_cost = ticket_cost;
        this.route_id = route_id;

    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public double getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(double ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public List<Passengers> getPassList() {
        return passList;
    }

    public void setPassList(List<Passengers> passList) {
        this.passList = passList;
    }

    public void addPassenger(Passengers p1){
        passList.add(p1);
        p1.getTlist().add(this);
    }
    public String toString() {

        return "Ticket ID : \t " + ticket_id + "\n Ticket Type :\t" + ticket_type + "\nTicket Cost : \t "
                + ticket_cost + "\nRoute Id :  \t" + route_id;

    }

}
