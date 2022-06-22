package dmm4j;

import java.util.List;
import javax.annotation.Nonnull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com ジャンル検索API レスポンス. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class GenreSearchResponse {

  /** リクエストパラメータ. */
  @Nonnull GenreSearchRequest request;

  /** レスポンスフィールド. */
  @Nonnull GenreSearchResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class GenreSearchRequest {

    /** リクエストパラメータ. */
    @Nonnull SeriesSearchParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class GenreSearchResult {

    /** ステータスコード. */
    @Nonnull String status;

    /** 取得件数. */
    int resultCount;

    /** 全体件数. */
    int totalCount;

    /** 検索開始位置. */
    int firstPosition;

    /** サイト名. */
    @Nonnull String siteName;

    /** サイトコード. */
    @Nonnull String siteCode;

    /** サービス名. */
    @Nonnull String serviceName;

    /** サービスコード. */
    @Nonnull String serviceCode;

    /** フロアID. */
    @Nonnull String floorId;

    /** フロア名. */
    @Nonnull String floorName;

    /** フロアコード. */
    @Nonnull String floorCode;

    /** ジャンル情報リスト. */
    @Nonnull List<Genre> genre;
  }

  /** ジャンル情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Genre {

    /** ジャンルID. */
    @Nonnull String genreId;

    /** ジャンル名. */
    @Nonnull String name;

    /** ジャンル名 (読み仮名). */
    String ruby;

    /** リストページURL（アフィリエイトID付き）. */
    String listUrl;
  }
}
