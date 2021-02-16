package dmm4j;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class SeriesSearchParameters {

    @NonNull
    String apiId;

    @NonNull
    String affiliateId;

    @NonNull
    String floorId;

    String initial;

    Integer hits;

    Integer offset;

    String output;

    String callback;
}
