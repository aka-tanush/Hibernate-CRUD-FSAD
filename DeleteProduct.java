package com.fsad.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsad.entity.Product;
import com.fsad.util.HibernateUtil;

public class DeleteProduct {

    public static void main(String[] args) {

        // Open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Fetch product by ID
        Product product = session.get(Product.class, 2); // change ID if needed

        if (product != null) {
            session.delete(product);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }

        // Commit transaction
        tx.commit();

        // Close session
        session.close();
    }
}
