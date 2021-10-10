package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "Demo Account Type")
public class AccountType implements Serializable{

    @Id
    @SequenceGenerator(name = "Generic Sequence")
    @Column(name ="Account_Type_Id")
    private String Account_Type_Id;

    @Column(name = "Account_holder_name")
    private String Account_holder_name;

    @Column(name = "Account_start_date")
    private LocalDate Acc_start_date;

    public AccountType(String account_Type_Id, String account_holder_name, LocalDate acc_start_date) {
        Account_Type_Id = account_Type_Id;
        Account_holder_name = account_holder_name;
        Acc_start_date = acc_start_date;
    }

    public String getAccount_Type_Id() {
        return Account_Type_Id;
    }

    public void setAccount_Type_Id(String account_Type_Id) {
        Account_Type_Id = account_Type_Id;
    }

    public String getAccount_holder_name() {
        return Account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        Account_holder_name = account_holder_name;
    }

    public LocalDate getAcc_start_date() {
        return Acc_start_date;
    }

    public void setAcc_start_date(LocalDate acc_start_date) {
        Acc_start_date = acc_start_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(Account_Type_Id, that.Account_Type_Id) && Objects.equals(Account_holder_name, that.Account_holder_name) && Objects.equals(Acc_start_date, that.Acc_start_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Account_Type_Id, Account_holder_name, Acc_start_date);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "Account_Type_Id='" + Account_Type_Id + '\'' +
                ", Account_holder_name='" + Account_holder_name + '\'' +
                ", Acc_start_date=" + Acc_start_date +
                '}';
    }
}
