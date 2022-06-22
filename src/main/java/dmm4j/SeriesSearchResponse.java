package dmm4j;

import javax.annotation.Nonnull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com シリーズ検索API レスポンス. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class SeriesSearchResponse {

  /** リケストパラメータ. */
  @Nonnull SeriesSearchRequest request;

  /** レスポンスフィールド. */
  @Nonnull SeriesSearchResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class SeriesSearchRequest {

    /** リクエストパラメータ. */
    @Nonnull SeriesSearchParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class SeriesSearchResult {

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

    /** シリーズ情報. */
    @Nonnull Series series;
  }

  /** シリーズ情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Series {

    /** シリーズID. */
    @Nonnull String seriesId;

    /** シリーズ名. */
    @Nonnull String name;

    /** シリーズ名（読み仮名）. */
    String ruby;

    /** リストページURL（アフィリエイトID付き）. */
    String listUrl;
  }
}
