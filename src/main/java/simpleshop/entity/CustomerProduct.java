package simpleshop.entity;

import javax.persistence.*;

@Entity
@Table
public class CustomerProduct {

    @Id
    private Long id;

    @Column
    private product;
}
