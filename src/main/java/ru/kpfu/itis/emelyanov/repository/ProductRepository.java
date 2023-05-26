package ru.kpfu.itis.emelyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.emelyanov.model.Product;
import ru.kpfu.itis.emelyanov.model.Ticket;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from products p where p.name like ?1", nativeQuery = true)
    List<Product> findAllByName(String name);

    @Query("select t from tickets t where t = :ticket")
    Ticket findTicketByProduct(Ticket ticket);

    @Query(value = "select * from products", nativeQuery = true)
    List<Product> findAll();
}
