/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webBank.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maysmiler
 */
@Entity
@Table(name = "HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
    , @NamedQuery(name = "History.findByHistoryid", query = "SELECT h FROM History h WHERE h.historyid = :historyid")
    , @NamedQuery(name = "History.findByMethod", query = "SELECT h FROM History h WHERE h.method = :method")
    , @NamedQuery(name = "History.findByAmount", query = "SELECT h FROM History h WHERE h.amount = :amount")
    , @NamedQuery(name = "History.findByCreatedate", query = "SELECT h FROM History h WHERE h.createdate = :createdate")
    , @NamedQuery(name = "History.findByBalance", query = "SELECT h FROM History h WHERE h.balance = :balance")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HISTORYID")
    private Integer historyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "METHOD")
    private String method;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private int balance;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne(optional = false)
    private Account accountid;

    public History() {
    }

    public History(Integer historyid) {
        this.historyid = historyid;
    }
 public History(Account accountid, String method, int amount, Date createdate, int balance) {
        this.accountid = accountid;
        this.method = method;
        this.amount = amount;
        this.createdate = createdate;
        this.balance = balance;
    }
    public History(Integer historyid, String method, int amount, Date createdate, int balance) {
        this.historyid = historyid;
        this.method = method;
        this.amount = amount;
        this.createdate = createdate;
        this.balance = balance;
    }

    public Integer getHistoryid() {
        return historyid;
    }

    public void setHistoryid(Integer historyid) {
        this.historyid = historyid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historyid != null ? historyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.historyid == null && other.historyid != null) || (this.historyid != null && !this.historyid.equals(other.historyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webBank.model.History[ historyid=" + historyid + " ]";
    }
    
}
