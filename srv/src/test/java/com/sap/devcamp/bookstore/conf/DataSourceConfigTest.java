package com.sap.devcamp.bookstore.conf;

import com.sap.devcamp.bookstore.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class DataSourceConfigTest {

    private DataSourceConfig cut;

    @Autowired private EntityManagerFactory env;

    @Before public void setUp () {
        cut = new DataSourceConfig();

        ReflectionTestUtils.setField(cut, "dbUrl", "jdbc:h2:mem:testdb");
        ReflectionTestUtils.setField(cut, "dbDriver", "org.h2.Driver");
        ReflectionTestUtils.setField(cut, "dbUser", "sa");
        ReflectionTestUtils.setField(cut, "dbPass", "");
        ReflectionTestUtils.setField(cut, "hibernateDialect", "org.hibernate.dialect.H2Dialect");
        ReflectionTestUtils.setField(cut, "hibernateDdlAuto", "none");
        ReflectionTestUtils.setField(cut, "hibernateNamingStrategy", "org.hibernate.cfg.DefaultNamingStrategy");
        ReflectionTestUtils.setField(cut, "hibernateShowSql", "false");
        ReflectionTestUtils.setField(cut, "hibernateFormatSql", "false");
    }

    @Test public void doCheck_classAnnotatedWith_configuration () {
        TestUtils.isAnnotatedWith_Configuration(cut.getClass());
    }

    @Test public void doCheck_beanDataSource_exists () {
        final DataSource bean = cut.dataSource();
        assertNotNull("Missing Bean of type " + bean.getClass().getName(), bean);
        if (!(bean instanceof DataSource)) {
            fail("Bean is not of expected type " + bean.getClass().getName());
        }
    }

    @Test public void doCheck_beanEntityManagerFactory_exists () {
        final LocalContainerEntityManagerFactoryBean bean = cut.entityManagerFactory(cut.dataSource());
        assertNotNull("Missing Bean of type " + bean.getClass().getName(), bean);
        if (!(bean instanceof LocalContainerEntityManagerFactoryBean)) {
            fail("Bean is not of expected type " + bean.getClass().getName());
        }
    }

    @Test public void doCheck_beanTransactionManager_exists () {
        final JpaTransactionManager bean = cut.transactionManager(env);
        assertNotNull("Missing Bean of type " + bean.getClass().getName(), bean);
        if (!(bean instanceof JpaTransactionManager)) {
            fail("Bean is not of expected type " + bean.getClass().getName());
        }
    }

}
