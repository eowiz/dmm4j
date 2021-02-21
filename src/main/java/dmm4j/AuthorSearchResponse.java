package dmm4j;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorSearchResponse {

    private AuthorSearchRequest request;

    private AuthorSearchResult result;

    @Data
    @NoArgsConstructor
    public static class AuthorSearchRequest {

        private AuthorSearchParameters parameters;
    }

    @Data
    @NoArgsConstructor
    public static class AuthorSearchResult {

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

        private Author author;
    }

    @Data
    @NoArgsConstructor
    public static class Author {

        private String authorId;

        private String name;

        private String ruby;

        private String authorName;

        private String listUrl;
    }
}
