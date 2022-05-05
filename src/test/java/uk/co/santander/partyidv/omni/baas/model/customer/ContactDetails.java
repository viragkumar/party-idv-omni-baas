package uk.co.santander.partyidv.omni.baas.model.customer;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class ContactDetails {
    String mobileNumber;
    String postcode;
    String accommodationCircumstances;
    String whenDidYouMoveIn;
    String whenDidYouMoveIn1;
    String howLongHaveYouLivedHere;
    String flatName;
    String houseName;
    String streetName;
    String district;
    String town;
    String postcode1;

}
