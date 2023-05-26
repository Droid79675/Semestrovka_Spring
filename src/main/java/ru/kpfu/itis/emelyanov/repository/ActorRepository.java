package ru.kpfu.itis.emelyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.emelyanov.model.Actor;
import java.util.Date;
import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query(value = "select * from actors a where a.name like ?1", nativeQuery = true)
    List<Actor> findAllByName(String name);

    @Query(value = "select a from actors a where a.birthday = :birthday")
    List<Actor> findAllByBirthdate(Date birthday);
}
