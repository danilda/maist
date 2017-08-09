package ua.com.maist.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item_attribute")
public class ItemAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @JoinTable(name = "item_type_attribute", joinColumns = @JoinColumn(name = "attribute_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    @ManyToMany
    private Set<ItemType> itemTypes = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemType> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(Set<ItemType> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public ItemAttribute() {}

    @Override
    public String toString() {
        return "ItemAttribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
