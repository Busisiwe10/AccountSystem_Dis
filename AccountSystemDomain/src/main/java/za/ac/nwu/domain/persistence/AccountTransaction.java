package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Demo Account Type")
public class AccountTransaction implements Serializable {

    @Id
    @SequenceGenerator(name = "Generic Sequence")
    @Column(name = "Account Transaction ID")
    private long account_trans_id;

    @Column(name = "Account Type ID")
    private long account_type_id;

    @Column(name = "Account Number")
    private long account_number;

    @Column(name = "Amount")
    private long amount;

    @Column(name = "Transaction date")
    private LocalDate trans_date;

    public AccountTransaction(long account_trans_id, long account_type_id, long account_number, long amount, LocalDate trans_date) {
        this.account_trans_id = account_trans_id;
        this.account_type_id = account_type_id;
        this.account_number = account_number;
        this.amount = amount;
        this.trans_date = trans_date;
    }

    public long getAccount_trans_id() {
        return account_trans_id;
    }

    public void setAccount_trans_id(long account_trans_id) {
        this.account_trans_id = account_trans_id;
    }

    public long getAccount_type_id() {
        return account_type_id;
    }

    public void setAccount_type_id(long account_type_id) {
        this.account_type_id = account_type_id;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDate getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(LocalDate trans_date) {
        this.trans_date = trans_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return account_trans_id == that.account_trans_id && account_type_id == that.account_type_id && account_number == that.account_number && amount == that.amount && Objects.equals(trans_date, that.trans_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_trans_id, account_type_id, account_number, amount, trans_date);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "account_trans_id=" + account_trans_id +
                ", account_type_id=" + account_type_id +
                ", account_number=" + account_number +
                ", amount=" + amount +
                ", trans_date=" + trans_date +
                '}';
    }
}
