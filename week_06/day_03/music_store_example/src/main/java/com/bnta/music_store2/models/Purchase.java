package com.bnta.music_store2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"purchases"})
    private User user;

    // why many-to-many
    // One purchase can have multiple products, and
    // each product can belong to multiple purchases
    @ManyToMany()
    @JoinTable(
            name = "purchases_products",
            joinColumns = {@JoinColumn(name = "purchase_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id", nullable = false)}
    )
    @JsonIgnoreProperties({"purchases"})
    private List<Product> products;

    protected Purchase() {}
    public Purchase(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
