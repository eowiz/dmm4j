package dmm4j;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** サイト. */
@RequiredArgsConstructor
public enum Site {

  /** FANZA（アダルト）. */
  FANZA("FANZA"),

  /** DMM.com（一般）. */
  DMM("DMM");

  /** サイト. */
  @Nonnull
  @Getter(onMethod = @__(@JsonValue))
  private final String value;
}
