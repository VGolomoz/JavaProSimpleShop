package simpleshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Long customerId;

    @Column
    private Date orderDate;

    @Column
    private String deliveryAddress;

    @Column()
    private Boolean orderStatus;

    @OneToMany(mappedBy = "order",
                cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList();

      public Order() {
    }

    public void addProduct(Product product) {
          productList.add(product);
    }

    public void clearProductList() {
        productList.clear();
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
        return orderStatus;
    }

    public void setOrederStatus(Boolean orederStatus) {
        this.orderStatus = orederStatus;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
