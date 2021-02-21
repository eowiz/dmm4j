package dmm4j;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeriesSearchResponse {

    private SeriesSearchRequest request;

    private SeriesSearchResult result;

    @Data
    @NoArgsConstructor
    public static class SeriesSearchRequest {

        private SeriesSearchParameters parameters;
    }

    @Data
    @NoArgsConstructor
    public static class SeriesSearchResult {

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

        private Series series;
    }

    @Data
    @NoArgsConstructor
    public static class Series {

        private String seriesId;

        private String name;

        private String ruby;

        private String listUrl;
    }
}
