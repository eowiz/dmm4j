package dmm4j;

import lombok.Data;

@Data
public class GenreSearchResponse {

    private GenreSearchRequest request;

    private GenreSearchResult result;

    @Data
    public static class GenreSearchRequest {

        private SeriesSearchParameters parameters;
    }

    @Data
    public static class GenreSearchResult {

        private String status;

        private int resultCount;

        private int totalCount;

        private int firstPosition;

        private String siteName;

        private String siteCode;

        private String serviceName;

        private String serviceCode;

        private String floorId;

        private String floorName;

        private String floorCode;

        private Genre genre;
    }

    @Data
    public static class Genre {

        private String genreId;

        private String name;

        private String ruby;

        private String listUrl;
    }
}
