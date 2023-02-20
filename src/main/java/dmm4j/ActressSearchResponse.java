package dmm4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.time.LocalDate;
import java.util.List;
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
    @Nullable Integer bust;

    /** カップ数. */
    String cup;

    /** ウエスト. */
    @Nullable Integer waist;

    /** ヒップ. */
    @Nullable Integer hip;

    /** 身長. */
    @Nullable Integer height;

    /** 誕生日. */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate birthday;

    /** 血液型. */
    @Nullable String bloodType;

    /** 趣味. */
    @Nullable String hobby;

    /** 出身地. */
    @Nullable String prefectures;

    /** 画像URL. */
    @Nullable
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
