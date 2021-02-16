package dmm4j;

import lombok.Data;

@Data
public class SeriesSearchResponse {

    private SeriesSearchRequest request;

    private SeriesSearchResult result;

    @Data
    public static class SeriesSearchRequest {

        private SeriesSearchParameters parameters;
    }

    @Data
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
    public static class Series {

        private String seriesId;

        private String name;

        private String ruby;

        private String listUrl;
    }
}
