package uk.co.santander.partyidv.omni.baas.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SharedState {
    private static final Map<State, Object> state = new HashMap<>();

    public <T> Optional<T> getState(State field, Class<T> returnType) {
        return Optional.ofNullable(state.get(field))
            .map(returnType::cast);
    }

    public void setState(State field, Object value) {
        if (value == null) {
            state.remove(field);
            return;
        }

        if (!field.assignableType().isInstance(value)) {
            throw new IllegalArgumentException(String.format("Object of type %s is not an instance of the expected type %s", value.getClass(), field.assignableType()));
        }
        state.put(field, value);
    }

    public void clearState() {
        state.clear();
    }

    public <T> T getStateOrFail(State field, Class<T> returnType, String failureMessage) {
        var stateValue = getState(field, returnType);
        if (stateValue.isEmpty()) {
            throw new AssertionError(failureMessage);
        }
        return stateValue.get();
    }

    @Override
    public String toString() {
        return "SharedState{" +
            "state=" + state +
            '}';
    }
}
