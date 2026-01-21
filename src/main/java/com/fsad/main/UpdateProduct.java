package com.fsad.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsad.entity.Product;
import com.fsad.util.HibernateUtil;

public class UpdateProduct {

    public static void main(String[] args) {

        // Open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Fetch product by ID
        Product product = session.get(Product.class, 1);

        if (product != null) {
            // Update fields
            product.setPrice(60000);
            product.setQuantity(8);

            // Update record
            session.update(product);

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }

        // Commit transaction
        tx.commit();

        // Close session
        session.close();
    }
}
