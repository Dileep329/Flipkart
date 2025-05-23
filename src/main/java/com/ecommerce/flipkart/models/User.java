package com.ecommerce.flipkart.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "userName"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(max=20)
    private String userName;

    @NotBlank
    @Size(max=50)
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank
    @Size(max=120)
    private String password;

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    @Setter
    @Getter
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles=new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            orphanRemoval = true)
    private Set<Product> products;


    @Getter
    @Setter
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    List<Address> addressList=new ArrayList<>();

    @ToString.Exclude
    @OneToOne(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST},orphanRemoval = true)
    private Cart cart;

}


