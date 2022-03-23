package devonfw.com.jwtsample.employeemanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import devonfw.com.jwtsample.employeemanagement.common.api.Employee;
import devonfw.com.jwtsample.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@javax.persistence.Table(name = "EMPLOYEE")
public class EmployeeEntity extends ApplicationPersistenceEntity implements Employee {

  @Column(name = "EMPLOYEEID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employeeId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "SURNAME")
  private String surname;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "AGE")
  private Integer age;

  @Column(name = "country")
  private String country;

  @Column(name = "phone")
  private String phone;

  @Column(name = "profession")
  private String profession;

  /**
   * @return country
   */
  @Override
  public String getCountry() {

    return this.country;
  }

  /**
   * @param country new value of {@link #getcountry}.
   */
  @Override
  public void setCountry(String country) {

    this.country = country;
  }

  /**
   * @return phone
   */
  @Override
  public String getPhone() {

    return this.phone;
  }

  /**
   * @param phone new value of {@link #getphone}.
   */
  @Override
  public void setPhone(String phone) {

    this.phone = phone;
  }

  /**
   * @return profession
   */
  @Override
  public String getProfession() {

    return this.profession;
  }

  /**
   * @param profession new value of {@link #getprofession}.
   */
  @Override
  public void setProfession(String profession) {

    this.profession = profession;
  }

  /**
   * @return employeeId
   */
  @Override
  public Long getEmployeeId() {

    return this.employeeId;
  }

  /**
   * @param employeeId new value of {@link #getEmployeeId}.
   */
  @Override
  public void setEmployeeId(Long employeeId) {

    this.employeeId = employeeId;
  }

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return surname
   */
  @Override
  public String getSurname() {

    return this.surname;
  }

  /**
   * @param surname new value of {@link #getSurname}.
   */
  @Override
  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * @return email
   */
  @Override
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getEmail}.
   */
  @Override
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return age
   */
  @Override
  public Integer getAge() {

    return this.age;
  }

  /**
   * @param age new value of {@link #getage}.
   */
  @Override
  public void setAge(Integer age) {

    this.age = age;
  }

}
