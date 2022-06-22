package dmm4j;

import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com 商品検索API ver3 リクエストパラメータ. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class ItemListParameters {

  /** API ID. */
  @Nullable String apiId;

  /** アフィリエイトID. */
  @Nullable String affiliateId;

  /**
   * サイト.
   *
   * <p>一般（DMM.com）かアダルト（FANZA）か.
   */
  @Nonnull Site site;

  /**
   * サービス.
   *
   * <p>フロアAPIから取得できるサービスコード.
   */
  @Nullable String service;

  /**
   * フロア.
   *
   * <p>フロアAPIから取得できるフロアコード.
   */
  @Nullable String floor;

  /**
   * 取得件数.
   *
   * <p>初期値: 20, 最大値: 100.
   */
  @Nullable Integer hits;

  /**
   * 検索開始位置.
   *
   * <p>初期値: 1, 最大値: 500000.
   */
  @Nullable Integer offset;

  /**
   * ソート順.
   *
   * <p>初期値: rank.
   *
   * <ul>
   *   <li>人気: rank
   *   <li>価格が高い順: price
   *   <li>価格が安い順: -price
   *   <li>新着: date
   *   <li>評価: review
   *   <li>マッチング順: match
   * </ul>
   */
  @Nullable Sort sort;

  /** キーワード. */
  @Nullable String keyword;

  /**
   * 商品ID.
   *
   * <p>商品に振られている content_id.
   */
  @Nullable String cid;

  /**
   * 絞り込み項目.
   *
   * <p>
   *
   * <ul>
   *   <li>女優: actress
   *   <li>作者: author
   *   <li>ジャンル: genre
   *   <li>シリーズ: series
   *   <li>メーカー: maker
   * </ul>
   */
  @Nullable Article article;

  /** 絞り込みID. */
  @Nullable String articleId;

  /** 発売日絞り込み. */
  @Nullable LocalDateTime gteData;

  /** 発売日絞り込み. */
  @Nullable LocalDateTime lteDate;

  /** 在庫絞り込み. */
  @Nullable MonoStock monoStock;

  /** 出力形式. */
  @Nullable String output;

  /** コールバック. */
  @Nullable String callback;

  /** ソート順. */
  @RequiredArgsConstructor
  public enum Sort {
    /** 人気. */
    RANK("rank"),

    /** 価格が高い順. */
    PRICE_DESC("price"),

    /** 価格が安い順. */
    PRICE_ASC("-price"),

    /** 新着. */
    DATE("date"),

    /** 評価. */
    REVIEW("review"),

    /** マッチング順. */
    MATCH("match");

    @Nonnull
    @Getter(onMethod = @__(@JsonValue))
    private final String value;
  }

  /** 絞り込み項目. */
  @RequiredArgsConstructor
  public enum Article {
    ACTRESS("actress"),
    AUTHOR("author"),
    GENRE("genre"),
    SERIES("series"),
    MAKER("maker");

    @Nonnull
    @Getter(onMethod = @__(@JsonValue))
    private final String value;
  }

  /** 在庫絞り込み. */
  @RequiredArgsConstructor
  public enum MonoStock {
    STOCK("stock"),
    RESERVE("reserve"),
    MONO("mono"),
    DMP("dmp");

    @Nonnull
    @Getter(onMethod = @__(@JsonValue))
    private final String value;
  }
}
