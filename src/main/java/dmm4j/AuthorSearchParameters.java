package dmm4j;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSearchParameters {

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
