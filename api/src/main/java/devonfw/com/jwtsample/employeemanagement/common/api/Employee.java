package devonfw.com.jwtsample.employeemanagement.common.api;

import devonfw.com.jwtsample.general.common.api.ApplicationEntity;

public interface Employee extends ApplicationEntity {

  /**
   * @return employeeIdId
   */
  public Long getEmployeeId();

  /**
   * @param employeeId setter for employeeId attribute
   */
  public void setEmployeeId(Long employeeId);

  /**
   * @return nameId
   */
  public String getName();

  /**
   * @param name setter for name attribute
   */
  public void setName(String name);

  /**
   * @return surnameId
   */
  public String getSurname();

  /**
   * @param surname setter for surname attribute
   */
  public void setSurname(String surname);

  /**
   * @return emailId
   */
  public String getEmail();

  /**
   * @param email setter for email attribute
   */
  public void setEmail(String email);

  /**
   * @return ageId
   */
  public Integer getAge();

  /**
   * @param age setter for age attribute
   */
  public void setAge(Integer age);

  /**
   * @return
   */
  String getCountry();

  /**
   * @param country
   */
  void setCountry(String country);

  /**
   * @return
   */
  String getPhone();

  /**
   * @param phone
   */
  void setPhone(String phone);

  /**
   * @return
   */
  String getProfession();

  /**
   * @param profession
   */
  void setProfession(String profession);

}
