package com.sap.devcamp.bookstore.service;

import com.sap.devcamp.bookstore.services.IBookService;
import com.sap.devcamp.bookstore.util.TestUtils;
import org.junit.Test;

public class IBookServiceTest {

    @Test public void doCheck_IBookService_isInterface () {
        TestUtils.doCheckIsInterface(IBookService.class);
    }

}
