package dmm4j;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** 出力形式. */
@Getter
@RequiredArgsConstructor
public enum Output {

  /** XML. */
  XML("xml"),

  /** JSON. */
  JSON("json");

  @Nonnull
  @Getter(onMethod = @__(@JsonValue))
  private final String value;
}
