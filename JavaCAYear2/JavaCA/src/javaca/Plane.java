/*
 *
 * Shane McCann X00128429
 * Howie Lynch  X00125128
 *
 */
package javaca;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
@NamedQuery(name = "Plane.findPlanes",
        query = "SELECT p FROM Plane p")
@Entity
@Table(name = "plane")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "plane_operator")

public abstract class Plane implements Serializable {
    @Id
    private String plane_id;
    private int capacity;
    @ManyToMany(mappedBy = "plist")
    private List<Route> rlist = new ArrayList<>();
    
    public Plane(){
        plane_id = "";
        capacity = 0;
    }
    
    public Plane(String idIn, int capacityIn){
        plane_id = idIn;
        capacity = capacityIn;
    }

    public String getPlaneId() {
        return plane_id;
    }

    public void setPlaneId(String plane_id) {
        this.plane_id = plane_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public List<Route> getRlist(){
        return rlist;
    }
    
    public void setRlist(List<Route> rlist){
        this.rlist = rlist;
    }
    public abstract String operator();
    
    public String toString(){
        return "Plane ID: \t" + plane_id + "\nCapacity: \t" + capacity + "\nOperator :"+ operator();
     
    }
}
