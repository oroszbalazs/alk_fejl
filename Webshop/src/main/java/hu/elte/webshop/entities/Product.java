package hu.elte.webshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product extends BaseEntity { //id is the product number

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private boolean inStock;

    @JsonIgnore
    @ManyToMany(mappedBy = "product")
    private List<Basket> basket;
}
