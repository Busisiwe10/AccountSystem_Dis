package za.ac.nwu.logic.flow.impl;

import za.ac.nwu.domain.dto.AccountTypeDto;

import java.time.LocalDate;

public interface ModifyAccountTypeFlow {
    AccountTypeDto deleteAccountType(String Account_TypeID);
    AccountTypeDto updateAccountType(String Account_TypeID, String newAccountTypeName, LocalDate newStartDate);

}
