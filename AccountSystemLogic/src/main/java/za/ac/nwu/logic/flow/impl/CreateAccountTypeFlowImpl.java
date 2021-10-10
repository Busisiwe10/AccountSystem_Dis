package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.logic.CreateAccountTypeFlow;
import za.ac.nwu.translator.AccountTypeTranslator;

import java.time.LocalDate;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }


    public AccountTypeDto create(AccountTypeDto accountType){
        if(null == accountType.getStartDate()){
            accountType.setStartDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
