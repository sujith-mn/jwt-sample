package devonfw.com.jwtsample.employeemanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import devonfw.com.jwtsample.employeemanagement.dataaccess.api.EmployeeEntity;
import devonfw.com.jwtsample.employeemanagement.logic.api.to.EmployeeEto;
import devonfw.com.jwtsample.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import devonfw.com.jwtsample.employeemanagement.logic.api.usecase.UcFindEmployee;
import devonfw.com.jwtsample.employeemanagement.logic.base.usecase.AbstractEmployeeUc;

/**
 * Use case implementation for searching, filtering and getting Employees
 */
@Named
@Validated
@Transactional
public class UcFindEmployeeImpl extends AbstractEmployeeUc implements UcFindEmployee {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindEmployeeImpl.class);

  @Override
  public EmployeeEto findEmployee(long id) {

    LOG.debug("Get Employee with id {} from database.", id);
    Optional<EmployeeEntity> foundEntity = getEmployeeRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), EmployeeEto.class);
    else
      return null;
  }

  @Override
  public Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo criteria) {

    Page<EmployeeEntity> employees = getEmployeeRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(employees, EmployeeEto.class);
  }

}
