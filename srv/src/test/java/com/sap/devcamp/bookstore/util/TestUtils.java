package com.sap.devcamp.bookstore.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class TestUtils {

    public static void isAnnotatedWith_Configuration (Class<?> cut) {
        doCheck_ClassIsAnnotatedWith(cut, Configuration.class);
    }

    public static void doCheck_ClassIsAnnotatedWith (final Class<?> cut, final Class<? extends Annotation> expectedAnnotation) {
        final boolean found = cut.isAnnotationPresent(expectedAnnotation);
        final String msg = "Expected class is annotated with '" + expectedAnnotation.getName() + "'";
        assertTrue(msg, found);
    }

    public static void doCheckIsInterface (final Class<?> cut) {
        assertTrue("Is not an interface", cut.isInterface());
    }

    public static void doCheckIsJpaRepository (final Object cut) {
        assertTrue("Missing extension of JpaRepository", cut instanceof JpaRepository);
    }

    public static void doCheck_ClassIsAnnotatedWith_Profile (final Class<?> cut, final String[] value) {
        doCheck_ClassIsAnnotatedWith(cut, Profile.class);
        final Profile profile = cut.getAnnotation(Profile.class);
        assertValue(profile.value(), value, "@Profile", "value");
    }

    /*****************
     * helper method's
     *****************/
    private static void assertValue (final String[] valuesFound, final String[] valueExpected, final String annotationName, final String valueDesc) {
        final List<String> expectedValues = new ArrayList<>(Arrays.asList(valueExpected));
        for (final String valueFound : valuesFound) {
            expectedValues.remove(valueFound);
        }
        final String msg = "Missing " + valueDesc + "(s) '" + expectedValues.toString() + "' at annotation '" + annotationName + "'";
        if (!expectedValues.isEmpty()) {
            fail(msg);
        }
    }

}
