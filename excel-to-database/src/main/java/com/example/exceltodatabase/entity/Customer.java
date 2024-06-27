package com.example.exceltodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String accountNumber;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String SVATCreditNoteNo;
    private String invoiceNo;
    private String customerVATNo;
    private String customerSVATNo;
    private Double subTotal;
    private Double TLandCESS;
    private Double Total;
    private Double SVATAmount;
    private String EmailID;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "LONGBLOB")
    private byte[] invoice;
}
