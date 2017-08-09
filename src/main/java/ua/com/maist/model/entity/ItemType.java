package ua.com.maist.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item_type")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name="parent_id", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private ItemType parent;
    @Column
    private String name;
    @JoinTable(name = "item_type_attribute", joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    @ManyToMany
    private Set<ItemAttribute> itemAttributes = new HashSet<>(0);

    public ItemType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public ItemType getParent() {
        return parent;
    }

    public void setParent(ItemType parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemAttribute> getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(Set<ItemAttribute> itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "id=" + id +
                ", parent=" + (parent!=null?parent.getName():" - ") +
                ", name='" + name + '\'' +
                '}';
    }
}
