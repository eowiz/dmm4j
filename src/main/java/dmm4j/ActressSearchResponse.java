package dmm4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Nonnull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com 女優API レスポンス. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class ActressSearchResponse {

  /** リクエストパラメータ. */
  @Nonnull ActressSearchRequest request;

  /** レスポンスフィールド. */
  @Nonnull ActressSearchResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ActressSearchRequest {

    /** リクエストパラメータ. */
    @Nonnull ActressSearchParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ActressSearchResult {

    /** ステータスコード. */
    @Nonnull String status;

    /** 取得件数. */
    int resultCount;

    /** 全体件数. */
    int totalCount;

    /** 検索開始位置. */
    int firstPosition;

    /** 女優情報リスト. */
    @Nonnull List<Actress> actress;
  }

  /** 女優情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Actress {

    /** 女優ID. */
    @Nonnull String id;

    /** 女優名. */
    @Nonnull String name;

    /** 女優名（読み仮名）. */
    String ruby;

    /** バスト. */
    Integer bust;

    /** カップ数. */
    String cup;

    /** ウエスト. */
    Integer waist;

    /** ヒップ. */
    Integer hip;

    /** 身長. */
    Integer height;

    /** 誕生日. */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthday;

    /** 血液型. */
    String bloodType;

    /** 趣味. */
    String hobby;

    /** 出身地. */
    String prefectures;

    /** 画像URL. */
    @Nonnull
    @JsonProperty("imageURL")
    ImageUrl imageUrl;

    /** リストページURL（アフィリエイトID付き）. */
    @Nonnull
    @JsonProperty("listURL")
    ListUrl listUrl;
  }

  /** 画像URL. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ImageUrl {

    /** 画像（小）. */
    String small;

    /** 画像（大）. */
    String large;
  }

  /** リストページURL（アフィリエイトID付き）. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class ListUrl {

    /** 動画. */
    String digital;

    /** 月額動画 見放題chデラックス. */
    String monthlyPremium;

    /** DVD通販. */
    String mono;

    /** DVDレンタル. */
    String rental;
  }
}
