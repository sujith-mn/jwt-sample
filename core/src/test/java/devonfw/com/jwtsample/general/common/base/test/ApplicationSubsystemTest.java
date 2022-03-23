package devonfw.com.jwtsample.general.common.base.test;

import com.devonfw.module.test.common.base.SubsystemTest;

import devonfw.com.jwtsample.SpringBootApp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * Abstract base class for {@link SubsystemTest}s of this application.
 */
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class ApplicationSubsystemTest extends SubsystemTest {

}
