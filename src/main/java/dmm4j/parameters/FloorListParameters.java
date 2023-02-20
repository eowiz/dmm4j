package dmm4j.parameters;

import dmm4j.Output;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com フロアAPI リクエストパラメータ. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class FloorListParameters {

  /** API ID. */
  @Nullable String apiId;

  /** アフィリエイトID. */
  @Nullable String affiliateId;

  /** 出力形式. */
  @Nullable Output output;

  /** コールバック. */
  @Nullable String callback;
}
