/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.*;
import javaca.*;
import javax.persistence.*;

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
        TypedQuery<Plane> query
                = em.createNamedQuery("Plane.findPlanes", Plane.class);
        List<Plane> results = query.getResultList();

        for (Plane p : results) {
            System.out.println("-----------------------------------------------");
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
            System.out.println("-----------------------------------------------");
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
                = em.createQuery("SELECT t FROM Ticket t", Ticket.class);
        List<Ticket> results = query.getResultList();

        for (Ticket t : results) {
            System.out.println("----------------------------------------------");
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
            System.out.println("----------------------------------------------");
            System.out.println(p.toString());
        }
        em.close();
        emf.close();

    }

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
        em.persist(p);
        em.getTransaction().commit();

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
