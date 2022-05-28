package dmm4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActressSearchResponse {

    private ActressSearchRequest request;

    private ActressSearchResult result;

    @Data
    @NoArgsConstructor
    public static class ActressSearchRequest {

        private ActressSearchParameters parameters;
    }

    @Data
    @NoArgsConstructor
    public static class ActressSearchResult {

        private String status;

        private int resultCount;

        private int totalCount;

        private int firstPosition;

        private Actress actress;
    }

    @Data
    @NoArgsConstructor
    public static class Actress {

        private String id;

        private String name;

        private String ruby;

        private Integer bust;

        private String cup;

        private Integer waist;

        private Integer hip;

        private Integer height;

        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthday;

        private String bloodType;

        private String hobby;

        private String prefectures;

        @JsonProperty("imageURL")
        private ImageUrl imageUrl;

        @JsonProperty("listURL")
        private ListUrl listUrl;
    }

    @Data
    @NoArgsConstructor
    public static class ImageUrl {

        private String small;

        private String large;
    }

    @Data
    @NoArgsConstructor
    public static class ListUrl {

        private String digital;

        private String monthlyPremium;

        private String mono;

        private String rental;
    }
}
