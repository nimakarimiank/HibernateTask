package database.entities.subentities;

import database.entities.subentities.contactType;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Embeddable
public class Contact {

    private String countryCode;
    private String number;
    public Contact(){}
    public Contact(String countryCode,String number,contactType contactType){

        this.contactType=contactType;
        this.countryCode=countryCode;
        this.number=number;
    }

    @Enumerated(EnumType.STRING)
    private contactType contactType;

    public database.entities.subentities.contactType getContactType() {
        return contactType;
    }

    public void setContactType(database.entities.subentities.contactType contactType) {
        this.contactType = contactType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
