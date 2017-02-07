/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaca;

import static Menu.Menu.displayMenu;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class TestPlane {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCAPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//--------------------Adding planes-----------------------------------
        Ryanair r1 = new Ryanair("FR9997", 142, 6);
        em.persist(r1);

        Ryanair r2 = new Ryanair("FR4655", 128, 5);
        em.persist(r2);

        AerLingus al1 = new AerLingus("EI3135", 168, 7);
        em.persist(al1);

//--------------------Adding Routes------------------------------------
        Route route1 = new Route("R861", "Dublin-Barcelona", 129);
        r2.addRoute(route1);
        em.persist(route1);

        Route route2 = new Route("R149", "Dublin-Thailand", 420);
        r1.addRoute(route2);
        em.persist(route2);

        Route route3 = new Route("R012", "Cork-Ibiza", 156);
        al1.addRoute(route3);
        em.persist(route3);

//-------------------Adding Tickets----------------------------------
        Ticket t1 = new Ticket("RY7411", "Adult", 126.99, "R149");
        em.persist(t1);

        Ticket t2 = new Ticket("RY7412", "Child", 126.99, "R149");
        em.persist(t2);

        Ticket t3 = new Ticket("RY7413", "Child", 126.99, "R149");
        em.persist(t3);

        Ticket t4 = new Ticket("AL3266", "Adult", 126.99, "R861");
        em.persist(t4);

        Ticket t5 = new Ticket("AL3267", "Adult", 126.99, "R861");
        em.persist(t5);

        
        Ticket t6 = new Ticket("RY8195", "Child", 126.99, "R861");
        em.persist(t6);

        Ticket t7 = new Ticket("RY8196", "Adult", 126.99, "R012");
        em.persist(t7);

        Ticket t8 = new Ticket("AL9142", "Child", 126.99, "R012");
        em.persist(t8);

//-------------------Add Passengers---------------------------------------
        Calendar dob1 = Calendar.getInstance();
        dob1.set(23, 8, 1996);
        Passengers p1 = new Passengers( "Shane McCann",dob1);
        t1.addPassenger(p1);
        em.persist(p1);

        Calendar dob2 = Calendar.getInstance();
        dob1.set(14, 4, 1971);
        Passengers p2 = new Passengers( "Howie Lynch",dob2);
        t1.addPassenger(p2);
        em.persist(p2);

         Calendar dob3 = Calendar.getInstance();
        dob1.set(8,1,2007);
        Passengers p3 = new Passengers( "Mark O'Farrell", dob3);
        t1.addPassenger(p3);
        em.persist(p3);

         Calendar dob4 = Calendar.getInstance();
        dob1.set(16,5,2009);
        Passengers p4 = new Passengers( "Lisa Dennis", dob4);
        t1.addPassenger(p4);
        em.persist(p4);

         Calendar dob5 = Calendar.getInstance();
        dob1.set(29,11,1998);
        Passengers p5 = new Passengers( "David Burns",dob5);
        t1.addPassenger(p5);
        em.persist(p5);

         Calendar dob6 = Calendar.getInstance();
        dob1.set(17,12,1998);
        Passengers p6 = new Passengers( "Shauna O'Leary", dob6);
        t1.addPassenger(p6);
        em.persist(p6);

         Calendar dob7 = Calendar.getInstance();
        dob1.set(17,10,1988);
        Passengers p7 = new Passengers( "Sean Nevin", dob7);
        t1.addPassenger(p7);
        em.persist(p7);

         Calendar dob8 = Calendar.getInstance();
        dob1.set(9,3,2001);
        Passengers p8 = new Passengers( "Ellen Griffin", dob8);
        t1.addPassenger(p8);
        em.persist(p8);

        em.getTransaction().commit();

//        System.out.println(r1.toString() + "\n" + route1 + "\n\n" + t1 + "\n\n" + t2);
//        System.out.println("----------------------------------------------------------------------------------");
//        System.out.println(r2.toString() + "\n");
//        System.out.println(al1.toString() + "\n");
        
        displayMenu();

       

        em.close();
        emf.close();

    }

}
