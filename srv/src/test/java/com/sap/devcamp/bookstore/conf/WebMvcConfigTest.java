package com.sap.devcamp.bookstore.conf;

import com.sap.devcamp.bookstore.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class WebMvcConfigTest {

    private WebMvcConfig cut;

    @Before public void setUp () {
        cut = new WebMvcConfig();
    }

    @Test public void doCheck_classAnnotatedWith_configuration () {
        TestUtils.isAnnotatedWith_Configuration(cut.getClass());
    }

    @Test public void doCheck_instanceOf_webMvcConfigurer () {
        assertTrue("Missing extension of WebMvcConfigurer", cut instanceof WebMvcConfigurer);
    }

}
