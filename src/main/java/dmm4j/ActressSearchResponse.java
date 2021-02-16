package dmm4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ActressSearchResponse {

    private ActressSearchRequest request;

    private ActressSearchResult result;

    @Data
    public static class ActressSearchRequest {

        private ActressSearchParameters parameters;
    }

    @Data
    public static class ActressSearchResult {

        private String status;

        private int resultCount;

        private int totalCount;

        private int firstPosition;

        private Actress actress;
    }

    @Data
    public static class Actress {

        private String id;

        private String name;

        private String ruby;

        private Integer bust;

        private String cup;

        private Integer waist;

        private Integer hip;

        private Integer height;

        @JsonDeserialize(using = LocalDateDeserializer.class)
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
    public static class ImageUrl {

        private String small;

        private String large;
    }

    @Data
    public static class ListUrl {

        private String digital;

        private String monthlyPremium;

        private String mono;

        private String rental;
    }
}
