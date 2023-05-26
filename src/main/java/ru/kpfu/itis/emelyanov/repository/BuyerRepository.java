package ru.kpfu.itis.emelyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.emelyanov.model.Buyer;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Optional<Buyer> findByEmail(String email);

    @Query(value = "select * from buyers b where b.email like ?1", nativeQuery = true)
    List<Buyer> findAllByEmail(String email);

    @Query(value = "select b from buyers b where b.email like ?1", nativeQuery = true)
    Buyer findBuyerByEmail(String email);

    @Query(value = "select b from buyers b where b.fName = :fName and b.sName = :sName")
    Buyer findBuyerByFNameAndSName(@Param("fName") String fName, @Param("sName") String sName);

    Optional<Buyer> getBuyerByUsername(String username);


}
