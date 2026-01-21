package com.fsad.main;

import org.hibernate.Session;

import com.fsad.entity.Product;
import com.fsad.util.HibernateUtil;

public class GetProduct {

    public static void main(String[] args) {

        // Open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Retrieve product by ID
        Product product = session.get(Product.class, 1);

        if (product != null) {
            System.out.println("Product Details:");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found!");
        }

        // Close session
        session.close();
    }
}
