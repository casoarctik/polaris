package io.back.polaris.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "ticket", schema = "polaris_db_a")
public class Ticket extends CreateAndUpdate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code", nullable = false)
  @Size(max = 10)
  private String code;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(nullable = false)
  @Enumerated(EnumType.STRING)
  private Category category;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User user;

  public Ticket() {}


  public Ticket(@Size(max = 10) String code, Status status, Category category, User user) {
    this.code = code;
    this.status = status;
    this.category = category;
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
    return status;
  }


  public void setStatus(Status status) {
    this.status = status;
  }
  

  public Category getCategory() {
    return category;
  }


  public void setCategory(Category category) {
    this.category = category;
  }


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
