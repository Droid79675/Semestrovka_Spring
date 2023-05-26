package ru.kpfu.itis.emelyanov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition="text")
    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer author;
}
