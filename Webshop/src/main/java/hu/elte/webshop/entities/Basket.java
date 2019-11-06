package hu.elte.webshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Basket extends BaseEntity {

    @OneToOne(mappedBy = "basket")
    private User user;

    @JsonIgnore
    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "basket_product", joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;
}
