package ua.com.maist.model.entity;

import javax.persistence.*;

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
}
