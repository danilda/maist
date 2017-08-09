package ua.com.maist.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_property")
public class ItemProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private ItemAttribute attribute;
    private String value;

    public ItemProperty() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(ItemAttribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemProperty{" +
                "id=" + id +
                ", item=" + item.getName() +
                ", attribute=" + attribute.getName() +
                ", value='" + value + '\'' +
                '}';
    }
}
