package dmm4j;

import lombok.*;

import java.util.List;

@Data
public class FloorListResponse {

    private FloorListRequest request;

    private FloorListResult result;

    @Data
    public static class FloorListRequest {

        private FloorListParameters parameters;
    }

    @Data
    public static class FloorListResult {

        private List<Site> site;
    }

    @Data
    public static class Site {

        private String name;

        private String code;

        private List<Service> service;
    }

    @Data
    public static class Service {

        private String name;

        private String code;

        private List<Floor> floor;
    }

    @Data
    public static class Floor {

        private String id;

        private String name;

        private String code;
    }
}
