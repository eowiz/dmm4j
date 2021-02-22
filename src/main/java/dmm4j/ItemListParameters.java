package dmm4j;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemListParameters {

    String apiId;

    String affiliateId;

    @NonNull
    Site site;

    String service;

    String floor;

    Integer hits;

    Integer offset;

    Sort sort;

    String keyword;

    String cid;

    Article article;

    String articleId;

    LocalDateTime gteData;

    LocalDateTime lteDate;

    MonoStock monoStock;

    String output;

    String callback;

    @Getter
    @RequiredArgsConstructor
    public enum Sort {
        RANK("rank"),
        PRICE_DESC("price"),
        PRICE_ASC("-price"),
        DATE("date"),
        REVIEW("review"),
        MATCH("match");

        @JsonValue
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Article {
        ACTRESS("actress"),
        AUTHOR("author"),
        GENRE("genre"),
        SERIES("series"),
        MAKER("maker");

        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum MonoStock {
        STOCK("stock"),
        RESERVE("reserve"),
        MONO("mono"),
        DMP("dmp");

        @JsonValue
        private final String value;
    }
}
