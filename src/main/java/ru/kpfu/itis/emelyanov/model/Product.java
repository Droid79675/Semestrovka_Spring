package ru.kpfu.itis.emelyanov.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;

    @Column()
    private Integer price;

    @OneToMany(mappedBy = "product")
    private List<Ticket> tickets;

    @ManyToMany(mappedBy = "products")
    private List<Actor> actorList;

}
