package hu.elte.webshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Basket{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "basket_product", joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @ToString.Exclude
    private List<Product> product;
}
