package ua.com.maist.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    private ItemType itemType;
    private String name;
    private double cost;
    private int amount;
    private String description;
    @OneToMany(mappedBy="item")
    private Set<ItemProperty> properties;
    @OneToMany(mappedBy = "item")
    private Set<OrderItem> orderItems;
    @Version
    private int version;

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<ItemProperty> getProperties() {
        return properties;
    }

    public void setProperties(Set<ItemProperty> properties) {
        this.properties = properties;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemType=" + itemType +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
