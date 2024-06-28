package com.kaanju.xml.split;

import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder={"customeraccount","ybpguid","productid","fund","profileid","sequence"})
public class Item {
    private String customeraccount;
    private String ybpguid;
    private Long productid;
    private String fund;
    private String profileid;
    private int sequence;
    public String getCustomeraccount() {
        return customeraccount;
    }
    @XmlAttribute
    public void setCustomeraccount(String customeraccount) {
        this.customeraccount = customeraccount;
    }
    public String getYbpguid() {
        return ybpguid;
    }
    @XmlAttribute
    public void setYbpguid(String ybpguid) {
        this.ybpguid = ybpguid;
    }

    public Long getProductid() {
        return productid;
    }
    @XmlAttribute
    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getFund() {
        return fund;
    }
    @XmlAttribute
    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getProfileid() {
        return profileid;
    }
    @XmlAttribute
    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }

    public int getSequence() {
        return sequence;
    }
    @XmlAttribute
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }



}
