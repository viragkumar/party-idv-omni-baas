package uk.co.santander.partyidv.omni.baas.model.Challenge;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ChallengeResponseRequest {
    @JsonProperty("session_id")
    String sessionId;

    @JsonProperty("challenge_response_token")
    String challengeResponseToken;
}