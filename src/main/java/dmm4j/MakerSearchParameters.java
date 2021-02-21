package dmm4j;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakerSearchParameters {

    String apiId;

    String affiliateId;

    String floorId;

    String initial;

    Integer hits;

    Integer offset;

    String output;

    String callback;
}
