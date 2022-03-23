package devonfw.com.jwtsample.employeemanagement.logic.api;

import devonfw.com.jwtsample.employeemanagement.logic.api.usecase.UcFindEmployee;
import devonfw.com.jwtsample.employeemanagement.logic.api.usecase.UcManageEmployee;

/**
 * Interface for Employeemanagement component.
 */
public interface Employeemanagement extends UcFindEmployee, UcManageEmployee {

}
