package simpleshop.entity;

import javax.persistence.*;

@Entity
@Table
public class ProductList {

    @Column
    private Long customerId;
}
