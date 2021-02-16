package dmm4j;

import lombok.*;

@Value
@Builder
public class FloorListParameters {

    @NonNull
    String apiId;

    @NonNull
    String affiliateId;

    String output;

    String callback;
}
