package dmm4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ItemListResponse {

    private ItemListRequest request;

    private ItemListResult result;

    @Data
    @NoArgsConstructor
    public static class ItemListRequest {

        private ItemListParameters parameters;
    }

    @Data
    @NoArgsConstructor
    public static class ItemListResult {

        private String status;

        private int resultCount;

        private int totalCount;

        private int firstPosition;

        private List<Item> items;
    }

    @Data
    @NoArgsConstructor
    public static class Item {

        private String serviceCode;

        private String serviceName;

        private String floorCode;

        private String floorName;

        private String categoryName;

        private String contentId;

        private String productId;

        private String title;

        private String volume;

        private String number;

        private Review review;

        @JsonProperty("URL")
        private String url;

        @JsonProperty("affiliateURL")
        private String affiliateUrl;

        @JsonProperty("URLsp")
        private String urlSp;

        @JsonProperty("affiliateURLsp")
        private String affiliateUrlSp;

        @JsonProperty("imageURL")
        private ImageUrl imageUrl;

        private Tachiyomi tachiyomi;

        @JsonProperty("sampleImageURL")
        private SampleImageUrl sampleImageUrl;

        @JsonProperty("sampleMovieURL")
        private SampleMovieUrl sampleMovieUrl;

        private Prices prices;

        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime date;

        @JsonProperty("iteminfo")
        private ItemInfo itemInfo;

        @JsonProperty("cdinfo")
        private CdInfo cdInfo;

        @JsonProperty("bandaiinfo")
        private BandaiInfo BandaiInfo;

        private String isbn;

        @JsonProperty("jancode")
        private String janCode;
    }

    @Data
    @NoArgsConstructor
    public static class Review {

        private int count;

        private double average;
    }

    @Data
    @NoArgsConstructor
    public static class ImageUrl {

        private String list;

        private String small;

        private String large;
    }

    @Data
    @NoArgsConstructor
    public static class Tachiyomi {

        @JsonProperty("URL")
        private String url;

        @JsonProperty("affiliateURL")
        private String affiliateUrl;
    }

    @Data
    @NoArgsConstructor
    public static class SampleImageUrl {

        private SampleS sampleS;
    }

    @Data
    @NoArgsConstructor
    public static class SampleS {

        private String[] image;
    }

    @Data
    @NoArgsConstructor
    public static class SampleMovieUrl {

        @JsonProperty("size_476_306")
        private String size476x306;

        @JsonProperty("size_560_360")
        private String size560x360;

        @JsonProperty("size_644_414")
        private String size644x414;

        @JsonProperty("size_720_480")
        private String size720x480;

        private int pcFlag;

        private int spFlag;
    }

    @Data
    @NoArgsConstructor
    public static class Prices {

        private String price;

        private String listPrice;

        private Deliveries deliveries;
    }

    @Data
    @NoArgsConstructor
    public static class Deliveries {

        private List<Delivery> delivery;
    }

    @Data
    @NoArgsConstructor
    public static class Delivery {

        private String type;

        private String price;

        private String listPrice;
    }

    @Data
    @NoArgsConstructor
    public static class ItemInfo {

        private List<Genre> genre;

        private List<Series> series;

        private List<Maker> maker;

        private List<Actor> actor;

        private List<Actress> actress;

        private List<Director> director;

        private List<Author> author;

        private List<Label> label;

        private List<Type> type;

        private List<Color> color;

        private List<Size> size;
    }

    @Data
    @NoArgsConstructor
    public static class Genre {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Series {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Maker {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Actor {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Actress {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Director {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Author {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Label {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Type {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Color {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class Size {

        private String id;

        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class BandaiInfo {

        @JsonProperty("titlecode")
        private String titleCode;
    }

    @Data
    @NoArgsConstructor
    public static class CdInfo {

        private String kind;
    }
}
