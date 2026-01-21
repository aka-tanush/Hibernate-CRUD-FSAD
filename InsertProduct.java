package com.fsad.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsad.entity.Product;
import com.fsad.util.HibernateUtil;

public class InsertProduct {

    public static void main(String[] args) {

        // Open Hibernate Session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Begin Transaction
        Transaction tx = session.beginTransaction();

        // Create Product objects
        Product p1 = new Product("Laptop", "Electronics", 55000, 10);
        Product p2 = new Product("Mouse", "Accessories", 500, 50);

        // Save products
        session.save(p1);
        session.save(p2);

        // Commit transaction
        tx.commit();

        // Close session
        session.close();

        System.out.println("Products inserted successfully!");
    }
}
