package dmm4j;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class FloorListResponse {

    private FloorListRequest request;

    private FloorListResult result;

    @Data
    @NoArgsConstructor
    public static class FloorListRequest {

        private FloorListParameters parameters;
    }

    @Data
    @NoArgsConstructor
    public static class FloorListResult {

        private List<Site> site;
    }

    @Data
    @NoArgsConstructor
    public static class Site {

        private String name;

        private String code;

        private List<Service> service;
    }

    @Data
    @NoArgsConstructor
    public static class Service {

        private String name;

        private String code;

        private List<Floor> floor;
    }

    @Data
    @NoArgsConstructor
    public static class Floor {

        private String id;

        private String name;

        private String code;
    }
}
