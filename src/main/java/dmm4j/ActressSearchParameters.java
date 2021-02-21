package dmm4j;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActressSearchParameters {

    String apiId;

    String affiliateId;

    String initial;

    String actressId;

    String keyword;

    Integer gteBust;

    Integer lteBust;

    Integer gteWaist;

    Integer lteWaist;

    Integer gteHip;

    Integer lteHip;

    Integer gteHeight;

    Integer lteHeight;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDate gteBirthday;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDate lteBirthday;

    Integer hits;

    Integer offset;

    Sort sort;

    String output;

    String callback;

    @Getter
    @RequiredArgsConstructor
    public enum Sort {
        NAME_ASC("name"),
        NAME_DESC("-name"),
        BUST_ASC("bust"),
        BUST_DESC("-bust"),
        WAIST_ASC("waist"),
        WAIST_DESC("-waist"),
        HIP_ASC("hip"),
        HIP_DESC("-hip"),
        HEIGHT_ASC("height"),
        HEIGHT_DESC("-height"),
        BIRTHDAY_ASC("birthday"),
        BIRTHDAY_DESC("-birthday"),
        ID_ASC("id"),
        ID_DESC("-id");

        @JsonValue
        private final String value;
    }
}
