package simpleshop.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Long customerId;

    @Column
    private java.sql.Date orderDate;

    @Column
    private String deliveryAddress;

    @Column
    private Boolean orderStatus;

    @ManyToMany
    @JoinTable(
            name="OrderProduct",
            joinColumns=@JoinColumn(name="order_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="product_id", referencedColumnName="id"))
    List<Product> productList = new ArrayList();

    public Order() {
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void addProduct(Product product) {
        if ( ! productList.contains(product))
            productList.add(product);
        if ( ! product.getOrderList().contains(this))
            product.addOrder(this);
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

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customerId, order.customerId) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(deliveryAddress, order.deliveryAddress) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(productList, order.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, orderDate, deliveryAddress, orderStatus, productList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderStatus=" + orderStatus +
                ", productList=" + productList +
                '}';
    }
}
