package io.back.polaris.models.database.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.back.polaris.models.database.generics.CreateAndUpdate;
import io.back.polaris.models.enums.Category;
import io.back.polaris.models.enums.Status;


@Entity
@Table(name = "ticket", schema = "polaris_db_a")
public class Ticket extends CreateAndUpdate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code", nullable = false)
  @Size(max = 10)
  private String code;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "category", nullable = false)
  private Integer category;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User user;

  public Ticket() {}


  public Ticket(@Size(max = 10) String code, Status status, Category category, User user) {
    this.code = code;
    this.status = status.getId();
    this.category = category.getId();
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Status getStatus() {
    return Status.getStatusById(this.status);
  }


  public void setStatus(Status status) {
    this.status = status.getId();
  }
  

  public Category getCategory() {
    return Category.getCategoryById(this.category);
  }


  public void setCategory(Category category) {
    this.category = category.getId();
  }


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
