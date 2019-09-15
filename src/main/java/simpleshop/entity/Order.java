package simpleshop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
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

    @ManyToOne
    private ProductList productList;

    @Column
    @GeneratedValue (generator = "false")
    private Boolean orederStatus;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Boolean getOrederStatus() {
        return orederStatus;
    }

    public void setOrederStatus(Boolean orederStatus) {
        this.orederStatus = orederStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customerId, order.customerId) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(deliveryAddress, order.deliveryAddress) &&
                Objects.equals(orederStatus, order.orederStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, orderDate, deliveryAddress, orederStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orederStatus=" + orederStatus +
                '}';
    }
}
