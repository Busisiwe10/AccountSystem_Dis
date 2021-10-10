package za.ac.nwu.logic.flow.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.translator.AccountTypeTranslator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @BeforeEach
    public void setUp() throws Exception{
        translator = Mockito.mock(AccountTypeTranslator.class);
        flow = new CreateAccountTypeFlowImpl((translator));
    }

    @AfterEach
    public void tearDown() throws Exception{
    }

    @Test
    public void create() {
        when(translator.create(any(AccountTypeDto.class))).thenReturn(new AccountTypeDto());
        flow.create(new AccountTypeDto());
        verify(translator, atLeastOnce()).create(any(AccountTypeDto.class));
    }
}