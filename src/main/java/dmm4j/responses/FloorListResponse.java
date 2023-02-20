package dmm4j.responses;

import dmm4j.parameters.FloorListParameters;
import jakarta.annotation.Nonnull;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** DMM.com フロアAPI レスポンス. */
@Jacksonized
@Value
@Builder(toBuilder = true)
public class FloorListResponse {

  /** リクエストパラメータ. */
  @Nonnull FloorListRequest request;

  /** レスポンスフィールド. */
  @Nonnull FloorListResult result;

  /** リクエストパラメータ. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class FloorListRequest {

    /** リクエストパラメータ. */
    @Nonnull FloorListParameters parameters;
  }

  /** レスポンスフィールド. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class FloorListResult {

    /** サイト情報リスト. */
    @Nonnull List<Site> site;
  }

  /** サイト情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Site {

    /** サイト名. */
    @Nonnull String name;

    /** サイトコード. */
    @Nonnull String code;

    /** サービス情報リスト. */
    @Nonnull List<Service> service;
  }

  /** サービス情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Service {

    /** サービス名. */
    @Nonnull String name;

    /** コード名. */
    @Nonnull String code;

    /** フロア情報リスト. */
    @Nonnull List<Floor> floor;
  }

  /** フロア情報. */
  @Jacksonized
  @Value
  @Builder(toBuilder = true)
  public static class Floor {

    /** フロアID. */
    @Nonnull String id;

    /** フロア名. */
    @Nonnull String name;

    /** フロアコード. */
    @Nonnull String code;
  }
}
