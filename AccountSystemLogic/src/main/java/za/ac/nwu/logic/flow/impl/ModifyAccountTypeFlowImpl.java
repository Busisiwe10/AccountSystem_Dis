package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.translator.AccountTypeTranslator;

import java.time.LocalDate;

@Transactional
@Component("ModifyAccountTypeFlowName")
public abstract class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow{

    private final AccountTypeTranslator accountTypeTranslator;


    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator ){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    public AccountTypeDto modify(AccountTypeDto accountType){
        if(null == accountType.getStartDate()){
            accountType.setStartDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
