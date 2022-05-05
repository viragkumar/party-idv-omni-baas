package uk.co.santander.partyidv.omni.baas.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmailState implements State {
    EMAIL_ADDRESS(String.class);

    private final Class<?> assignableType;

    @Override
    public Class<?> assignableType() {
        return this.assignableType;
    }
}
