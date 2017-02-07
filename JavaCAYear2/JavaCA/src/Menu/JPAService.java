/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Calendar;
import java.util.List;
import javaca.Passengers;
import javaca.Plane;
import javaca.Route;
import javaca.Ryanair;
import javaca.Ticket;
import javax.persistence.*;
import java.math.BigDecimal;
import static javaca.Ticket_.route_id;

/**
 *
 * @author Howie
 */
public class JPAService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCAPU");
    EntityManager em = emf.createEntityManager();

    //Creates Query To diplay all Planes 
    public void displayPlaneOperators() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCAPU");
        EntityManager em = emf.createEntityManager();
        System.err.println("Have to fix This so output is AerLingus and Ryan Air !!!!!");
        TypedQuery<Plane> query
                = em.createNamedQuery("Plane.findPlanes", Plane.class);
        List<Plane> results = query.getResultList();

        for (Plane p : results) {
            System.out.println(p.toString());
        }
        em.close();
        emf.close();

    }

    //Display Routes 
    public void displayPlaneRoutes() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCAPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Route> query
                = em.createNamedQuery("Route.findRoutes", Route.class);
        List<Route> results = query.getResultList();

        for (Route r : results) {
            System.out.println(r.toString());
        }
        em.close();
        emf.close();

    }

    //displays Tickets 
    public void displayTickets() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCAPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Ticket> query
                = em.createNamedQuery("Ticket.findTickets", Ticket.class);
        List<Ticket> results = query.getResultList();

        for (Ticket t : results) {
            System.out.println(t.toString());
        }
        em.close();
        emf.close();

    }

    //Displays Passengers
    public void displayPassengers() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCAPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Passengers> query
                = em.createNamedQuery("Passengers.findPassengers", Passengers.class);
        List<Passengers> results = query.getResultList();

        for (Passengers p : results) {
            System.out.println(p.toString());
        }
        em.close();
        emf.close();

    }

//  public boolean findPassenger(String passenger) {
//
//        int id = findPassengerID(passenger);
//        boolean found = false;
//        
//
//        if (abo != null) {
//            found = true;
//
//        }
//        return found;
//    }
    public Passengers addPassenger(String pass_name, Calendar pass_dob) {

        em.getTransaction().begin();
        Passengers p = new Passengers(pass_name, pass_dob);
        em.persist(p);
        em.getTransaction().commit();
        return p;

    }

    public void updatePassenger(int id, String name) {

        em.getTransaction().begin();
        //findPassengerID(id);
        Passengers p = em.find(Passengers.class, id);
        p.setPass_name(name);
        em.persist(p);
        em.getTransaction().commit();

    }

    public void deletePassenger(int idDelete) {

        Passengers p = em.find(Passengers.class, idDelete);
        em.getTransaction().begin();
        em.remove(p);
        //em.persist(p);
        em.getTransaction().commit();
        System.out.println("deleted................");

    }

    private int findPassengerID(int passenger) {

        int passengerID = 0;
        Query query = em.createQuery("Select p.pass_id from Passengers p"
                + " where p.pass_id =:value", Passengers.class).setParameter("value", passenger);

        try {

            passengerID = (int) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nothing Found " + e.getMessage());

        }
        return passengerID;
    }

    public double getCost(String x) {
        //System.out.println("In here " + x);
       double total = 0;
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Ticket.findTickets",Ticket.class).setParameter("route_id", x);
    
        List<Ticket> list = query.getResultList();

        for (Ticket t : list) {
            total+=t.getTicket_cost();
            //System.out.println("Price " + t.getTicket_cost());
        }
        total = total/3;
        em.getTransaction().commit();

        return total;
    }
}
