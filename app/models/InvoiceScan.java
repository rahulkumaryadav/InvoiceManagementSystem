package models;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="InvoiceScan")
public class InvoiceScan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String uniqueId;
    public String invoiceFileUpload;
    public String strCreatedBy;
    public String strModifiedBy;
    public Date dtCreated;
    public Date dtModified;
    public Boolean activeFlag;


    public InvoiceScan() {
    }

    public InvoiceScan(String uniqueId, String invoiceFileUpload, String strCreatedBy, String strModifiedBy, Date dtCreated, Date dtModified, Boolean activeFlag) {
        this.uniqueId = uniqueId;
        this.invoiceFileUpload = invoiceFileUpload;
        this.strCreatedBy = strCreatedBy;
        this.strModifiedBy = strModifiedBy;
        this.dtCreated = dtCreated;
        this.dtModified = dtModified;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getInvoiceFileUpload() {
        return invoiceFileUpload;
    }

    public void setInvoiceFileUpload(String invoiceFileUpload) {
        this.invoiceFileUpload = invoiceFileUpload;
    }

    public String getStrCreatedBy() {
        return strCreatedBy;
    }

    public void setStrCreatedBy(String strCreatedBy) {
        this.strCreatedBy = strCreatedBy;
    }

    public String getStrModifiedBy() {
        return strModifiedBy;
    }

    public void setStrModifiedBy(String strModifiedBy) {
        this.strModifiedBy = strModifiedBy;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Date getDtModified() {
        return dtModified;
    }

    public void setDtModified(Date dtModified) {
        this.dtModified = dtModified;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    public String toString() {
        return "InvoiceScan{" +
                "id=" + id +
                ", uniqueId='" + uniqueId + '\'' +
                ", invoiceFileUpload='" + invoiceFileUpload + '\'' +
                ", strCreatedBy='" + strCreatedBy + '\'' +
                ", strModifiedBy='" + strModifiedBy + '\'' +
                ", dtCreated=" + dtCreated +
                ", dtModified=" + dtModified +
                ", activeFlag=" + activeFlag +
                '}';
    }
}
