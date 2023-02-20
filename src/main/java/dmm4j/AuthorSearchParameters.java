package dmm4j;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com 作者検索API リクエストパラメータ. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class AuthorSearchParameters {

  /** API ID. */
  @Nullable String apiId;

  /** アフィリエイトID. */
  @Nullable String affiliateId;

  /** フロアID. */
  @NonNull String floorId;

  /** 頭文字 (50音). */
  @Nullable String initial;

  /** 取得件数. */
  @Nullable Integer hits;

  /** 検索開始位置. */
  @Nullable Integer offset;

  /** 出力形式. */
  @Nullable String output;

  /** コールバック. */
  @Nullable String callback;
}
