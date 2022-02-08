package mk.ukim.finki.wpaudrecap.service;

import mk.ukim.finki.wpaudrecap.model.Product;
import mk.ukim.finki.wpaudrecap.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);

}
