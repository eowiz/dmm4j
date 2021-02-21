package dmm4j;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FloorListParameters {

    @NonNull
    String apiId;

    @NonNull
    String affiliateId;

    String output;

    String callback;
}
