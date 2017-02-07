/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaca;

import java.util.*;
import javax.persistence.*;
@NamedQuery(name = "Route.findRoutes",
        query = "SELECT r FROM Route r")
@Entity
@Table(name = "route")

@SuppressWarnings("SerializableClass")

public class Route {

    @Id
    private String route_id;
    private String route_name;
    private int duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "planeroute",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "plane_id"))

    private List<Plane> plist = new ArrayList<>();

    public Route() {
        route_id = "";
        route_name = "";
        duration = 0;
    }

    public Route(String routeIn, String nameIn, int durationIn) {
        route_id = routeIn;
        route_name = nameIn;
        duration = durationIn;
    }
    
    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Plane> getPlist() {
        return plist;
    }

    public void setPlist(List<Plane> plist) {
        this.plist = plist;
    }

    public String toString() {
        return "Route ID: \t" + route_id + "\nRoute Name: \t" + route_name
                + "\nDuration: \t" + duration + " Minutes ";
    }
}
