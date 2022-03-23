package devonfw.com.jwtsample.general.common.api;

import java.security.Principal;

import devonfw.com.jwtsample.general.common.api.datatype.Role;

/**
 * This is the interface for the profile of a user interacting with this
 * application. TODO: Also an external system may access the application via
 * some service. Then there would be no user profile or it would be empty...
 *
 */
public interface UserProfile extends Principal {
  /**
   * @return the technical ID of the user for calling REST services.
   */
  Long getId();

  /**
   * @return the unique login of the user for authentication and identification.
   */
  String getName();

  /**
   * @return the first name of the users real name.
   */
  String getFirstName();

  /**
   * @return the last name of the users real name.
   */
  String getLastName();

  /**
   * @return {@link Role} of this {@link UserProfile}.
   */
  Role getRole();
}
