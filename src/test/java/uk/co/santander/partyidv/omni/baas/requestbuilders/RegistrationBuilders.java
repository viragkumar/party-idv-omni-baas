package uk.co.santander.partyidv.omni.baas.requestbuilders;

import uk.co.santander.partyidv.omni.baas.model.Registration.RegistrationRequest;
import uk.co.santander.partyidv.omni.baas.model.Registration.RegistrationRequestAttribution;

public class RegistrationBuilders {

    public static RegistrationRequest buildRegistrationRequest(final String emailAddress,
                                                               final String channelKey,
                                                               final String productKey) {
        final RegistrationRequest.RegistrationRequestBuilder requestBuilder = RegistrationRequest.builder();

        if (!emailAddress.equals("null")) {
            requestBuilder.email(emailAddress);
        }

        requestBuilder.attribution(buildAttributionRequest(productKey, channelKey));

         return requestBuilder.build();
    }

    private static RegistrationRequestAttribution buildAttributionRequest(final String productKey, final String channelKey) {
        final RegistrationRequestAttribution.RegistrationRequestAttributionBuilder attributionRequest = RegistrationRequestAttribution.builder();

        if(!channelKey.equals("null")){
            attributionRequest
                    .channelKey(channelKey)
                    .build();
        }
        if(!productKey.equals("null")){
            attributionRequest
                    .productKey(productKey)
                    .build();
        }

        return attributionRequest.build();
    }
}
