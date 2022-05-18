package com.bnta.music_store2.components;

import com.bnta.music_store2.models.Product;
import com.bnta.music_store2.models.Purchase;
import com.bnta.music_store2.models.User;
import com.bnta.music_store2.repositories.ProductRepository;
import com.bnta.music_store2.repositories.PurchaseRepository;
import com.bnta.music_store2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

import static java.util.Arrays.asList;

// component annotation required to make the class 'visible' to spring
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // add some products
        Product product1 = new Product("Generic Acoustic Guitar", "A very generic acoustic guitar", (float)549.99);
        Product product2 = new Product("Generic Bass Guitar", "A very generic bass guitar", (float)849.99);
        Product product3 = new Product("Generic Electric Guitar", "A very generic electric guitar", (float)949.99);
        Product product4 = new Product("Generic Drum Kit", "A very generic drum kit", (float)799.99);
        productRepository.saveAll(asList(product1, product2, product3, product4));

        // add some users
        User user1 = new User("Jack", LocalDate.of(1985, 3, 25));
        User user2 = new User("Jason", LocalDate.of(1992, 6, 14));
        User user3 = new User("Jane", LocalDate.of(1988, 9, 11));
        userRepository.saveAll(asList(user1, user2, user3));

        // add some purchases
        Purchase purchase1 = new Purchase(user1, asList(product4, product2));
        Purchase purchase2 = new Purchase(user2, Arrays.asList(product1));
        Purchase purchase3 = new Purchase(user1, Arrays.asList(product3));
        Purchase purchase4 = new Purchase(user3, Arrays.asList(product3, product3, product3, product3));
        purchaseRepository.saveAll(Arrays.asList(purchase1, purchase2, purchase3, purchase4));
    }
}
