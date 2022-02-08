package mk.ukim.finki.wpaudrecap.repository.jpa;

import mk.ukim.finki.wpaudrecap.model.ShoppingCart;
import mk.ukim.finki.wpaudrecap.model.User;
import mk.ukim.finki.wpaudrecap.model.enumeration.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
