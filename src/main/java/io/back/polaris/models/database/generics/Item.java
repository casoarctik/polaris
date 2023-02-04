package io.back.polaris.models.database.generics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import io.back.polaris.models.database.tables.Ticket;
import io.back.polaris.models.enums.Category;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Item extends CreateAndUpdate {
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "item_id_seq"
    )
    @SequenceGenerator(
        name = "item_id_seq",
        schema = "polaris_db_a",
        initialValue = 1000,
        allocationSize = 5
    )
    private Long id;

    @Column(name = "title", nullable = false)
    @Size(max = 50)
    private String title;

    @OneToOne
    @JoinColumn(nullable = true)
    private Ticket ticket;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "category", nullable = false)
    private Integer category;

    
    protected Item(@Size(max = 50) String title, Ticket ticket, String path) {
        this.title = title;
        this.ticket = ticket;
        this.path = path;
        this.category = ticket.getCategory().getId();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Category getCategory() {
        return Category.getCategoryById(this.category);
    }

    public void setCategory(Category category) {
        this.category = category.getId();
    }
  
}
