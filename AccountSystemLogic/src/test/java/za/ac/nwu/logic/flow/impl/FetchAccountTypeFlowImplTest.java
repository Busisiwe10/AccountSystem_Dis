package za.ac.nwu.logic.flow.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FetchAccountTypeFlowImplTest {
    private FetchAccountTypeFlowImpl testClass;

    @BeforeEach
    void setUp() throws Exception {
        testClass = new FetchAccountTypeFlowImpl();
    }

    @AfterEach
    void tearDown() throws Exception{
        testClass = null;
    }

    @Test
    void methodToTest() throws Exception {
        assertTrue(testClass.methodToTest());
    }
}