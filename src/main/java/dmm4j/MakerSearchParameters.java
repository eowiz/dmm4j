package dmm4j;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
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
