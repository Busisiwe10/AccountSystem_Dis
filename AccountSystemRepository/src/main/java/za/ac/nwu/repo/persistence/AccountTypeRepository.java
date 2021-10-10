package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT "+
            "       ACCOUNT_TYPE_ID,"+
            "       ACCOUNT_HOLDER_NAME,"+
            "       ACCOUNT_START_DATE," +
            "   FROM "+
            "       ACCOUNT_TYPE" +
            "   WHERE ACCOUNT_TYPE_ID = :Account_Type_ID", nativeQuery = true)
    AccountType getAccountTypeIdNativeQuery(String Account_Type_ID);

    @Query(value = "SELECT "+
            "           at" +
            "       FROM"+
            "           AccountType at"+
            "       WHERE at.Account_Type_ID =: Account_Type_ID")
    AccountType getAccountTypeID(String Account_Type_ID);

    @Query(value =  "SELECT new za.ac.nwu.domain.dto.AccountTypeDto( "+
            "           at.Account_Type_Name,"+
            "           at.Account_Start_Date )"+
            "        FROM" +
            "              AccountType at" +
            "        WHERE at.Account_Type_ID =: Account_Type_ID")
    AccountTypeDto getAccountTypeDtoByAccountTypeID(String Account_Type_ID);
}
