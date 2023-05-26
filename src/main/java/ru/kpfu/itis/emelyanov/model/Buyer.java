package ru.kpfu.itis.emelyanov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "buyers")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String fName;

    @Column(nullable = false)
    private String sName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 11)
    private String email;

    @OneToMany(mappedBy = "buyer")
    private List<Ticket> tickets;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "buyer_role", joinColumns = @JoinColumn(name = "buyer_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Set<Role> roles;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;
}
