package com.sap.devcamp.bookstore.conf;

import com.sap.devcamp.bookstore.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class SwaggerConfigTest {

    private SwaggerConfig cut;

    @Before public void setUp () {
        cut = new SwaggerConfig();
    }

    @Test public void doCheck_classAnnotatedWith_configuration () {
        TestUtils.isAnnotatedWith_Configuration(cut.getClass());
    }

    @Test public void doCheck_beanDocket_exists () {
        final Docket bean = cut.api();
        assertNotNull("Missing Bean of type " + bean.getClass().getName(), bean);
        if (!(bean instanceof Docket)) {
            fail("Bean is not of expected type " + bean.getClass().getName());
        }
    }

    @Test public void doCheck_beanUiConfiguration_exists () {
        final UiConfiguration bean = cut.tryItOutConfig();
        assertNotNull("Missing Bean of type " + bean.getClass().getName(), bean);
        if (!(bean instanceof UiConfiguration)) {
            fail("Bean is not of expected type " + bean.getClass().getName());
        }
    }

}
