package dmm4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com 商品検索API ver3 レスポンス. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class ItemListResponse {

  /** リクエストパラメータ. */
  @Nonnull ItemListRequest request;

  /** レスポンスフィールド. */
  @Nonnull ItemListResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ItemListRequest {

    /** リクエストパラメータ. */
    @Nonnull ItemListParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ItemListResult {

    /** ステータスコード. */
    @Nonnull String status;

    /** 取得件数. */
    int resultCount;

    /** 全体件数. */
    int totalCount;

    /** 検索開始位置. */
    int firstPosition;

    /** 商品情報リスト. */
    @Nonnull List<Item> items;
  }

  /** 商品情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Item {

    /** サービスコード. */
    @Nonnull String serviceCode;

    /** サービス名. */
    @Nonnull String serviceName;

    /** フロアコード. */
    @Nonnull String floorCode;

    /** フロア名. */
    @Nonnull String floorName;

    /** カテゴリ名. */
    @Nonnull String categoryName;

    /** 商品ID. */
    @Nonnull String contentId;

    /** 品番. */
    @Nonnull String productId;

    /** タイトル. */
    @Nonnull String title;

    /** 収録時間 or ページ数. */
    @Nullable String volume;

    /** 巻数. */
    @Nullable String number;

    /** レビュー. */
    @Nullable Review review;

    /** 商品ページURL. */
    @JsonProperty("URL")
    String url;

    /** アフィリエイトリンクURL. */
    @JsonProperty("affiliateURL")
    String affiliateUrl;

    /** 画像URL. */
    @JsonProperty("imageURL")
    @Nonnull
    ImageUrl imageUrl;

    /** 立ち読みページURL. */
    @Nullable Tachiyomi tachiyomi;

    /** サンプル画像URL. */
    @JsonProperty("sampleImageURL")
    @Nullable
    SampleImageUrl sampleImageUrl;

    /** サンプル動画URL. */
    @Nullable
    @JsonProperty("sampleMovieURL")
    SampleMovieUrl sampleMovieUrl;

    /** 価格. */
    @Nonnull Prices prices;

    /** 発売日、配信開始日、貸出開始日. */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime date;

    /** 商品詳細. */
    @JsonProperty("iteminfo")
    ItemInfo itemInfo;

    /** CD情報. */
    @JsonProperty("cdinfo")
    @Nullable
    CdInfo cdInfo;

    /** ISBN. */
    @Nullable String isbn;

    /** JANコード. */
    @JsonProperty("jancode")
    @Nullable
    String janCode;

    /** メーカー品番. */
    @Nullable String makerProduct;

    /** 在庫状況（在庫数）. */
    @Nullable String stock;

    /** パンくずリスト. */
    @Nullable Directory directory;
  }

  /** レビュー. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Review {

    /** レビュー数. */
    int count;

    /** レビュー平均点. */
    String average;
  }

  /** 画像URL. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ImageUrl {

    /** リストページ用. */
    String list;

    /** 末端用（小）. */
    String small;

    /** 末端用（大）. */
    String large;
  }

  /** 立ち読みページ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Tachiyomi {

    /** 立ち読みページURL. */
    @JsonProperty("URL")
    String url;

    /** 立ち読みアフィリエイトリンクURL. */
    @JsonProperty("affiliateURL")
    String affiliateUrl;
  }

  /** サンプル画像URL. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class SampleImageUrl {

    /** サンプル画像（小）URL. */
    @Nonnull SampleS sampleS;

    /** サンプル画像（大）URL */
    @Nonnull SampleL sampleL;
  }

  /** サンプル（小）リスト. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class SampleS {

    /** サンプル画像（小）. */
    @Nonnull String[] image;
  }

  /** サンプル画像（大）リスト. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class SampleL {

    /** サンプル画像（大）. */
    @Nonnull String[] image;
  }

  /** サンプル動画URL. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class SampleMovieUrl {

    /** 476x306. */
    @JsonProperty("size_476_306")
    String size476x306;

    /** 560x360. */
    @JsonProperty("size_560_360")
    String size560x360;

    /** 644x414. */
    @JsonProperty("size_644_414")
    String size644x414;

    /** 720x480. */
    @JsonProperty("size_720_480")
    String size720x480;

    /** PC対応しているか. */
    int pcFlag;

    /** SP対応しているか. */
    int spFlag;
  }

  /** 価格. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Prices {

    /** 金額. */
    String price;

    /** 定価. */
    String listPrice;

    /** 配信リスト. */
    Deliveries deliveries;
  }

  /** 配信リスト. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Deliveries {

    /** 配信. */
    @Nonnull List<Delivery> delivery;
  }

  /** 配信. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Delivery {

    /** 配信タイプ. */
    String type;

    /** 配信価格. */
    String price;

    /** 配信価格（リスト）. */
    String listPrice;
  }

  /** 商品詳細. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ItemInfo {

    /** ジャンル. */
    List<Genre> genre;

    /** シリーズ. */
    List<Series> series;

    /** メーカー. */
    List<Maker> maker;

    /** 出演者（一般作品のみ）. */
    List<Actor> actor;

    /** 女優（アダルト作品のみ）. */
    List<Actress> actress;

    /** 監督. */
    List<Director> director;

    /** 製造者. */
    List<Manufacture> manufacture;

    /** 作家、原作者、著者. */
    List<Author> author;

    /** アーティスト. */
    List<Artist> artist;

    /** レーベル. */
    List<Label> label;

    /** タイプ. */
    List<Type> type;

    /** カラー. */
    List<Color> color;

    /** サイズ. */
    List<Size> size;
  }

  /** ジャンル. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Genre {

    /** ジャンルID. */
    int id;

    /** ジャンル名. */
    @Nonnull String name;
  }

  /** シリーズ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Series {

    /** シリーズID. */
    int id;

    /** シリーズ名. */
    @Nonnull String name;
  }

  /** メーカー. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Maker {

    /** メーカーID. */
    int id;

    /** メーカー名. */
    @Nonnull String name;
  }

  /** 出演者. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Actor {

    /** 出演者ID. */
    int id;

    /** 出演者名. */
    @Nonnull String name;
  }

  /** 女優. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Actress {

    /** 女優ID. */
    int id;

    /** 女優名. */
    @Nonnull String name;
  }

  /** 監督. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Director {

    /** 監督ID. */
    int id;

    /** 監督名. */
    @Nonnull String name;
  }

  /** 製造者. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Manufacture {

    /** 製造者ID. */
    int id;

    /** 製造者名. */
    @Nonnull String name;
  }

  /** 作家、原作者、著者. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Author {

    /** 作家、原作者、著者ID. */
    int id;

    /** 作家、原作者、著者名. */
    @Nonnull String name;
  }

  /** アーティスト. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Artist {

    /** アーティストID. */
    int id;

    /** アーティスト名 */
    @Nonnull String name;
  }

  /** レーベル. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Label {

    /** レーベルID. */
    int id;

    /** レーベル名. */
    @Nonnull String name;
  }

  /** タイプ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Type {

    /** タイプID. */
    int id;

    /** タイプ名. */
    @Nonnull String name;
  }

  /** カラー. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Color {

    /** カラーID. */
    int id;

    /** カラー名. */
    @Nonnull String name;
  }

  /** サイズ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Size {

    /** サイズID. */
    int id;

    /** サイズ名. */
    @Nonnull String name;
  }

  /** CD情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class CdInfo {

    /** アルバム、シングル. */
    String kind;
  }

  /** キャンペーンリスト. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Campaign {

    /** キャンペーンリスト. */
    List<Item> items;

    /** キャンペーン. */
    @Jacksonized
    @Value
    @Builder(toBuilder = true)
    public static class Item {

      /** 開始時刻. */
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      LocalDateTime dateBegin;

      /** 終了時刻. */
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      LocalDateTime dateEnd;

      /** タイトル. */
      String title;
    }
  }

  /** パンくずリスト. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Directory {

    /** パンくずID. */
    int id;

    /** パンくず名. */
    String name;
  }
}
