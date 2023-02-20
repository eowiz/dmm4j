package dmm4j;

import jakarta.annotation.Nonnull;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com メーカー検索API. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class MakerSearchResponse {

  /** リクエストパラメータ. */
  @Nonnull MakerSearchRequest request;

  /** レスポンスフィールド. */
  @Nonnull MakerSearchResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class MakerSearchRequest {

    /** リクエストパラメータ. */
    @Nonnull MakerSearchParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class MakerSearchResult {

    /** ステータスコード. */
    @Nonnull String status;

    /** 取得件数. */
    @Nonnull Integer resultCount;

    /** 全体件数. */
    @Nonnull Integer totalCount;

    /** 検索開始位置. */
    @Nonnull Integer firstPosition;

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

    /** メーカー情報. */
    @Nonnull List<Maker> maker;
  }

  /** メーカー情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Maker {

    /** メーカーID. */
    @Nonnull String makerId;

    /** メーカー名. */
    @Nonnull String name;

    /** メーカー名（読み仮名）. */
    String ruby;

    /** リストページURL（アフィリエイトID付き）. */
    String listUrl;
  }
}
