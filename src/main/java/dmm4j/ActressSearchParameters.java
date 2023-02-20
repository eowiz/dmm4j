package dmm4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com 女優API リクエストパラメータ. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class ActressSearchParameters {

  /** API ID. */
  @Nullable String apiId;

  /** アフィリエイトID. */
  @Nullable String affiliateId;

  /** 頭文字 (50音). */
  @Nullable String initial;

  /** 女優ID. */
  @Nullable String actressId;

  /** キーワード. */
  @Nullable String keyword;

  /** バスト. */
  @Nullable Integer gteBust;

  /** バスト. */
  @Nullable Integer lteBust;

  /** ウエスト. */
  @Nullable Integer gteWaist;

  /** ウエスト. */
  @Nullable Integer lteWaist;

  /** ヒップ. */
  @Nullable Integer gteHip;

  /** ヒップ. */
  @Nullable Integer lteHip;

  /** 身長. */
  @Nullable Integer gteHeight;

  /** 身長. */
  @Nullable Integer lteHeight;

  /** 誕生日. */
  @Nullable
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonFormat(pattern = "uuuu-MM-dd")
  LocalDate gteBirthday;

  /** 誕生日. */
  @Nullable
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDate lteBirthday;

  /** 取得件数. */
  @Nullable Integer hits;

  /** 検索開始位置. */
  @Nullable Integer offset;

  /** ソート順. */
  @Nullable Sort sort;

  /** 出力形式. */
  @Nullable String output;

  /** コールバック. */
  @Nullable String callback;

  /** ソート順. */
  @RequiredArgsConstructor
  public enum Sort {

    /** 名前昇順. */
    NAME_ASC("name"),

    /** 名前降順. */
    NAME_DESC("-name"),

    /** バスト昇順. */
    BUST_ASC("bust"),

    /** バスト降順. */
    BUST_DESC("-bust"),

    /** ウエスト昇順. */
    WAIST_ASC("waist"),

    /** ウエスト降順. */
    WAIST_DESC("-waist"),

    /** ヒップ昇順. */
    HIP_ASC("hip"),

    /** ヒップ降順. */
    HIP_DESC("-hip"),

    /** 身長昇順. */
    HEIGHT_ASC("height"),

    /** 身長降順. */
    HEIGHT_DESC("-height"),

    /** 生年月日昇順. */
    BIRTHDAY_ASC("birthday"),

    /** 生年月日降順. */
    BIRTHDAY_DESC("-birthday"),

    /** 女優ID昇順. */
    ID_ASC("id"),

    /** 女優ID降順. */
    ID_DESC("-id");

    @Nonnull
    @Getter(onMethod = @__(@JsonValue))
    private final String value;
  }
}
