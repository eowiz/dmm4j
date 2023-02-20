package dmm4j;

import jakarta.annotation.Nonnull;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com 作者検索API レスポンス. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class AuthorSearchResponse {

  /** リクエストパラメータ. */
  @Nonnull AuthorSearchRequest request;

  /** レスポンスフィールド. */
  @Nonnull AuthorSearchResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class AuthorSearchRequest {

    /** リクエストパラメータ. */
    @Nonnull AuthorSearchParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class AuthorSearchResult {

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

    /** 作者情報リスト. */
    @Nonnull List<Author> author;
  }

  /** 作者情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Author {

    /** 作者ID. */
    @Nonnull String authorId;

    /** 作者名. */
    @Nonnull String name;

    /** 作者名（読み仮名）. */
    String ruby;

    /** 作者別名. */
    String authorName;

    /** リストページURL（アフィリエイトID付き）. */
    String listUrl;
  }
}
