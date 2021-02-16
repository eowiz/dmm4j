package dmm4j;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Site {
    FANZA("FANZA"),
    DMM("DMM");

    @JsonValue
    private final String value;
}
