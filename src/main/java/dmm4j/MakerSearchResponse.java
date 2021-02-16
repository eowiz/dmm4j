package dmm4j;

import lombok.Data;

import java.util.List;

@Data
public class MakerSearchResponse {

    private MakerSearchRequest request;

    private MakerSearchResult result;

    @Data
    public static class MakerSearchRequest {

        private MakerSearchParameters parameters;
    }

    @Data
    public static class MakerSearchResult {

        private String status;

        private Integer resultCount;

        private Integer totalCount;

        private Integer firstPosition;

        private String siteName;

        private String siteCode;

        private String serviceName;

        private String serviceCode;

        private String floorId;

        private String floorName;

        private String floorCode;

        private List<Maker> maker;
    }

    @Data
    public static class Maker {

        private String makerId;

        private String name;

        private String ruby;

        private String listUrl;
    }
}
