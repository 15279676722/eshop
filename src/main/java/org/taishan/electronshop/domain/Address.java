package org.taishan.electronshop.domain;

public class Address {
    /*地址的id*/
    private int id;
    /*收获人*/
    private String person;
    /*省份*/
    private String provices;
    /*城市*/
    private String cites;
    /*县区*/
    private String counties;
    /*街道*/
    private String street;
    /*详细地址*/
    private String addressInfo;
    /*收获号码*/
    private String phone;
    /*邮政编码*/
    private String numCode;
    /*地址名称*/
    private String addressType;
    /*传入一个customer表示是谁的地址*/
    private Customer customer;

    public String getCounties() {
        return counties;
    }
    public void setCounties(String counties) {
        this.counties = counties;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public String getProvices() {
        return provices;
    }
    public void setProvices(String provices) {
        this.provices = provices;
    }
    public String getCites() {
        return cites;
    }
    public void setCites(String cites) {
        this.cites = cites;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getAddressInfo() {
        return addressInfo;
    }
    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumCode() {
        return numCode;
    }
    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
