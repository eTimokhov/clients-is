package com.etimokhov.clients.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String patronymic;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column
    @NotNull
    @Pattern(regexp = "^[A-Z]{2}$")
    private String passportSeries;

    @Column
    @NotNull
    @Pattern(regexp = "^\\d{7}$")
    private String passportNumber;

    @Column
    @NotNull
    private String passportIssuanceSource;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date passportIssuanceDate;

    @Column
    @NotNull
    @Pattern(regexp = "^[A-Z0-9]{14}$")
    private String passportID;

    @Column
    @NotNull
    private String birthPlace;

    @ManyToOne
    @NotNull
    private City residenceCity;

    @Column
    @NotNull
    private String residenceAddress;

    @Column
    @Pattern(regexp = "(^$|^\\+\\d{12}$)")
    private String homePhoneNumber;

    @Column
    @Pattern(regexp = "(^$|^\\+\\d{12}$)")
    private String mobilePhoneNumber;

    @Column
    private String email;

    @Column
    private String jobPlace;

    @Column
    private String jobPosition;

    @ManyToOne
    @NotNull
    private MaritalStatus maritalStatus;

    @ManyToOne
    @NotNull
    private Citizenship citizenship;

    @ManyToOne
    @NotNull
    private Disability disability;

    @Column
    @NotNull
    private Boolean retiree;

    @Column
    private BigDecimal revenue;

    @Column
    @NotNull
    private Boolean reservist;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssuanceSource() {
        return passportIssuanceSource;
    }

    public void setPassportIssuanceSource(String passportIssuanceSource) {
        this.passportIssuanceSource = passportIssuanceSource;
    }

    public Date getPassportIssuanceDate() {
        return passportIssuanceDate;
    }

    public void setPassportIssuanceDate(Date passportIssuanceDate) {
        this.passportIssuanceDate = passportIssuanceDate;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public City getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(City residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public Boolean getRetiree() {
        return retiree;
    }

    public void setRetiree(Boolean retiree) {
        this.retiree = retiree;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public Boolean getReservist() {
        return reservist;
    }

    public void setReservist(Boolean reservist) {
        this.reservist = reservist;
    }
}
