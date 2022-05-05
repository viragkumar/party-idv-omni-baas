package uk.co.santander.partyidv.omni.baas.state;

import lombok.RequiredArgsConstructor;
import uk.co.santander.partyidv.omni.baas.model.customer.ConstantDetails;
import uk.co.santander.partyidv.omni.baas.model.customer.Customer;

@RequiredArgsConstructor
public enum CustomerState implements State {
    CUSTOMER(Customer.class),
    CONSTANT(ConstantDetails.class);

    private final Class<?> assignableType;

    @Override
    public Class<?> assignableType() {
        return this.assignableType;
    }
}
