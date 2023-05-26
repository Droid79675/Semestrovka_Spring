package ru.kpfu.itis.emelyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.emelyanov.model.Ticket;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("select t from tickets t where t.date = :date")
    List<Ticket> findAllByDate(Date date);

    @Query("select t from tickets t where t.price = :price")
    List<Ticket> findAllByPrice(Integer price);

    @Query("select t from tickets t where :price > (select avg(price) from tickets)")
    List<Ticket> findTicketByPrice(Integer price);
}
