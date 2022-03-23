package devonfw.com.jwtsample.employeemanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

import devonfw.com.jwtsample.employeemanagement.dataaccess.api.EmployeeEntity;
import devonfw.com.jwtsample.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;

/**
 * {@link DefaultRepository} for {@link EmployeeEntity}
 */
public interface EmployeeRepository extends DefaultRepository<EmployeeEntity> {

  /**
   * @param criteria the {@link EmployeeSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link EmployeeEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<EmployeeEntity> findByCriteria(EmployeeSearchCriteriaTo criteria) {

    EmployeeEntity alias = newDslAlias();
    JPAQuery<EmployeeEntity> query = newDslQuery(alias);

    Long employeeId = criteria.getEmployeeId();
    if (employeeId != null) {
      query.where($(alias.getEmployeeId()).eq(employeeId));
    }
    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    String surname = criteria.getSurname();
    if (surname != null && !surname.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getSurname()), surname, criteria.getSurnameOption());
    }
    String email = criteria.getEmail();
    if (email != null && !email.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getEmail()), email, criteria.getEmailOption());
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   *
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<EmployeeEntity> query, EmployeeEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "employeeId":
            if (next.isAscending()) {
              query.orderBy($(alias.getEmployeeId()).asc());
            } else {
              query.orderBy($(alias.getEmployeeId()).desc());
            }
            break;
          case "name":
            if (next.isAscending()) {
              query.orderBy($(alias.getName()).asc());
            } else {
              query.orderBy($(alias.getName()).desc());
            }
            break;
          case "surname":
            if (next.isAscending()) {
              query.orderBy($(alias.getSurname()).asc());
            } else {
              query.orderBy($(alias.getSurname()).desc());
            }
            break;
          case "age":
            if (next.isAscending()) {
              query.orderBy($(alias.getAge()).asc());
            } else {
              query.orderBy($(alias.getAge()).desc());
            }
            break;
          case "email":
            if (next.isAscending()) {
              query.orderBy($(alias.getEmail()).asc());
            } else {
              query.orderBy($(alias.getEmail()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
