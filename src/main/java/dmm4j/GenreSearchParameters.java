package dmm4j;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com ジャンル検索API パラメータ. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class GenreSearchParameters {

  /** API ID. */
  @Nullable String apiId;

  /** アフィリエイトID. */
  @Nullable String affiliateId;

  /** フロアID. */
  @Nonnull String floorId;

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
