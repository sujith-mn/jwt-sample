package devonfw.com.jwtsample.employeemanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import devonfw.com.jwtsample.employeemanagement.logic.api.Employeemanagement;
import devonfw.com.jwtsample.employeemanagement.logic.api.to.EmployeeEto;
import devonfw.com.jwtsample.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import devonfw.com.jwtsample.employeemanagement.logic.api.usecase.UcFindEmployee;
import devonfw.com.jwtsample.employeemanagement.logic.api.usecase.UcManageEmployee;
import devonfw.com.jwtsample.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of employeemanagement
 */
@Named
public class EmployeemanagementImpl extends AbstractComponentFacade implements Employeemanagement {

  @Inject
  private UcFindEmployee ucFindEmployee;

  @Inject
  private UcManageEmployee ucManageEmployee;

  @Override
  public EmployeeEto findEmployee(long id) {

    return this.ucFindEmployee.findEmployee(id);
  }

  @Override
  public Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo criteria) {

    return this.ucFindEmployee.findEmployees(criteria);
  }

  @Override
  public EmployeeEto saveEmployee(EmployeeEto employee) {

    return this.ucManageEmployee.saveEmployee(employee);
  }

  @Override
  public boolean deleteEmployee(long id) {

    return this.ucManageEmployee.deleteEmployee(id);
  }

}
