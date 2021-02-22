package dmm4j;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FloorListParameters {

    String apiId;

    String affiliateId;

    String output;

    String callback;
}
