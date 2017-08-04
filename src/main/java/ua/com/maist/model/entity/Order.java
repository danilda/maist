package ua.com.maist.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by danil on 30.07.2017.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private Date date;
    @Column(name = "total_price")
    private double totalPrice;

    public Order() {
    }

    public Order(User user, Date date, double totalPrice) {
        this.user = user;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
