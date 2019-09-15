package simpleshop.entity;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Long customerId;

    @Column
    private Date orderDate;

    @Column
    private String deliveryAddress;

    @OneToOne(mappedBy = "order",
                cascade = CascadeType.ALL)
    private CustomerProduct customerProduct;

    @Column()
    private Boolean orederStatus;

    public Order() {
    }
}
