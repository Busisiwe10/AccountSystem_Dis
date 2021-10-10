package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType",
        description = "A DTO that represents the AccountType")

public class AccountTypeDto  implements Serializable {

    private String accountName;
    private String accountNum;
    private LocalDate startDate;

    public AccountTypeDto(){

    }

    public AccountTypeDto(String accountName, String accountNum, LocalDate startDate) {
        this.accountName = accountName;
        this.accountNum = accountNum;
        this.startDate = startDate;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "accountName",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Number",
            name = "accountNum",
            dataType = "java.lang.String",
            example = "MILES",
            allowEmptyValue = false,
            required = true)
    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @ApiModelProperty(position = 3,
            value = "AccountType Start Date",
            name = "accountStartDate",
            dataType = "java.lang.String",
            example = "2021-01-01",
            allowEmptyValue = true,
            required = false)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(accountName, that.accountName) && Objects.equals(accountNum, that.accountNum) && Objects.equals(startDate, that.startDate);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getAccountName(), getAccountNum(), getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, accountNum, startDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountName='" + accountName + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
