package uk.co.santander.partyidv.omni.baas.model.customer;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ConstantDetails {

 String experienceAndInsightText;
 String experienceAndInsightHelpText;

 //Product Carousel Constant Text
 String basicCurrentAccountText;
 String everydayCurrentAccountText;
 String selectCurrentAccountText;
 String _123CurrentAccountText;
 String _123LiteCurrentAccountText;

}
