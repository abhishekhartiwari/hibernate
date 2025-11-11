package com.abhi;

import jakarta.persistence.*;

public class JPACRUDExample {
    public static void main(String[] args) {
        // Create EntityManagerFactory (like SessionFactory in Hibernate)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        // CREATE
        em.getTransaction().begin();
        Student s1 = new Student();
        s1.setName("Abhishek");
        s1.setCity("Delhi");
        em.persist(s1);  // INSERT
        em.getTransaction().commit();

        // READ
        Student student = em.find(Student.class, 1); // SELECT
        System.out.println("Found: " + student.getName() + " from " + student.getCity());

        // UPDATE
        em.getTransaction().begin();
        student.setCity("Mumbai");
        em.merge(student);  // UPDATE
        em.getTransaction().commit();

        // DELETE
        em.getTransaction().begin();
        Student toDelete = em.find(Student.class, 2);
        if (toDelete != null) {
            em.remove(toDelete);  // DELETE
        }
        //em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
