package za.ac.nwu.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.repo.config.RepositoryTestConfig;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})

public class AccountTypeRepositoryTest {
    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Before
    public void setUp() throws Exception{
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void getAccountTypeByAccountTypeIDNativeQueryMiles(){
        AccountType miles = accountTypeRepository.getAccountTypeIdNativeQuery("MILES");
        assertNotNull(miles);
        assertEquals("MILES", miles.getAccount_Type_Id());
    }

    @Test
    public void getAccountTypeByAccountTypeIDNativeQuery(){
        AccountType miles = accountTypeRepository.getAccountTypeIdNativeQuery("MILESSS");
        assertNull(miles);
    }

    @Test
    public void getAccountTypeByAccountTypeID(){
        AccountType miles = accountTypeRepository.getAccountTypeID("MILESS");
        assertNotNull(miles);
        assertEquals("MILES", miles.getAccount_Type_Id());

    }



 }
