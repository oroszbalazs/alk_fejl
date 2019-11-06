package hu.elte.webshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order extends BaseEntity { //order number is id



    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
