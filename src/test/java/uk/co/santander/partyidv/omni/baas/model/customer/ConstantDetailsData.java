package uk.co.santander.partyidv.omni.baas.model.customer;

public class ConstantDetailsData {
    public static final ConstantDetails CONSTANT =
        ConstantDetails.builder()
        .experienceAndInsightText("These cookies help us to understand how people use our application journey so we can make it easier for everyone.")
            .experienceAndInsightHelpText("If you turn off experience and insight cookies you can still apply via the website")
            .build();

    public static final ConstantDetails PRODUCT_CONSTANT =
        ConstantDetails.builder()
            .basicCurrentAccountText("Basic Current Account")
            .everydayCurrentAccountText("Everyday Current Account")
            .selectCurrentAccountText("Select Current Account")
            ._123CurrentAccountText("1|2|3 Current Account")
            ._123LiteCurrentAccountText("1|2|3 Lite Current Account")
            .build();
}
