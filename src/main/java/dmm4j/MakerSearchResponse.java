package dmm4j;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MakerSearchResponse {

    private MakerSearchRequest request;

    private MakerSearchResult result;

    @Data
    @NoArgsConstructor
    public static class MakerSearchRequest {

        private MakerSearchParameters parameters;
    }

    @Data
    @NoArgsConstructor
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
    @NoArgsConstructor
    public static class Maker {

        private String makerId;

        private String name;

        private String ruby;

        private String listUrl;
    }
}
