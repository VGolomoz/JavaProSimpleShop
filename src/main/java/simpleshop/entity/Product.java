package simpleshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column (nullable = false)
    private Long price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "productList")
    List<Order> orderList = new ArrayList<>();

    public Product() {
    }

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Order> getOrderList() {
        return Collections.unmodifiableList(orderList);
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order) {
        if ( ! orderList.contains(order))
            orderList.add(order);
        if ( ! order.getProductList().contains(this))
           order.addProduct(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(orderList, product.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, orderList);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
