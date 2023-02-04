package io.back.polaris.models.database.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.back.polaris.models.database.generics.CreateAndUpdate;

@Entity
@Table(name = "user_account", schema = "polaris_db_a")
public class User extends CreateAndUpdate {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "user_account_id_seq"
  )
  @SequenceGenerator(
    name = "user_account_id_seq",
    schema = "polaris_db_a",
    initialValue = 100,
    allocationSize = 5
  )
  private Long id;

  @Column(name = "last_name", nullable = false)
  @Size(max = 50)
  private String lastName;

  @Column(name = "first_name", nullable = false)
  @Size(max = 30)
  private String firstName;

  @Column(name = "user_name", nullable = false, unique = true)
  @Size(min = 4, max = 20)
  private String userName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "user_password", nullable = false)
  @Size(min = 8, max = 20)
  private String password;

  @Column(
    name = "administrator",
    nullable = false,
    columnDefinition = "boolean default false"
  )
  private boolean administrator;

  @Column(
    name = "moderator",
    nullable = false,
    columnDefinition = "boolean default false"
  )
  private boolean moderator;

  @Column(name = "premium", nullable = false)
  private boolean premium;

  @Column(name = "month_seniority", columnDefinition = "integer default 0")
  private int monthSeniority;

  public User() {}

  public User(
    String name,
    String surname,
    String alias,
    String email,
    String password
  ) {
    this.lastName = name;
    this.firstName = surname;
    this.userName = alias;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return lastName;
  }

  public void setName(String name) {
    this.lastName = name;
  }

  public String getSurname() {
    return firstName;
  }

  public void setSurname(String surname) {
    this.firstName = surname;
  }

  public String getAlias() {
    return userName;
  }

  public void setAlias(String alias) {
    this.userName = alias;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAdmin() {
    return administrator;
  }

  public void setAdmin(boolean admin) {
    this.administrator = admin;
  }

  public boolean isModerator() {
    return moderator;
  }

  public void setModerator(boolean moderator) {
    this.moderator = moderator;
  }

  public boolean isPremium() {
    return premium;
  }

  public void setPremium(boolean premium) {
    this.premium = premium;
  }

  public int getMonthSeniority() {
    return monthSeniority;
  }

  public void setMonthSeniority(int monthSeniority) {
    this.monthSeniority = monthSeniority;
  }
}
