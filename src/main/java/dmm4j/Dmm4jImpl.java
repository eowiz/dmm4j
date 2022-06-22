package dmm4j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kong.unirest.Unirest;
import kong.unirest.jackson.JacksonObjectMapper;
import lombok.Getter;
import lombok.Setter;

public final class Dmm4jImpl implements Dmm4j {

  static Dmm4j INSTANCE = new Dmm4jImpl();

  private static final String BASE_URL = "https://api.dmm.com/affiliate/v3";

  private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

  /** API ID. */
  @Getter @Setter private String apiId;

  /** アフィリエイトID. */
  @Getter @Setter private String affiliateId;

  Dmm4jImpl() {
    var objectMapper =
        new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    var jacksonObjectMapper = new JacksonObjectMapper(objectMapper);
    Unirest.config().setObjectMapper(jacksonObjectMapper);
  }

  Dmm4jImpl(String apiId, String affiliateId) {
    this();

    this.apiId = apiId;
    this.affiliateId = affiliateId;
  }

  @Override
  public ItemListResponse getItemList(ItemListParameters parameters) {
    Stream<Map.Entry<String, String>> params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("site", Optional.of(parameters.getSite().getValue())),
                Map.entry("service", Optional.ofNullable(parameters.getService())),
                Map.entry("floor", Optional.ofNullable(parameters.getFloor())),
                Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
                Map.entry(
                    "offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
                Map.entry(
                    "sort",
                    Optional.ofNullable(parameters.getSort())
                        .map(ItemListParameters.Sort::getValue)),
                Map.entry("keyword", Optional.ofNullable(parameters.getKeyword())),
                Map.entry("cid", Optional.ofNullable(parameters.getCid())),
                Map.entry(
                    "article",
                    Optional.ofNullable(parameters.getArticle())
                        .map(ItemListParameters.Article::getValue)),
                Map.entry("article_id", Optional.ofNullable(parameters.getArticleId())),
                Map.entry(
                    "gte_date",
                    Optional.ofNullable(parameters.getGteData())
                        .map(LOCAL_DATE_TIME_FORMATTER::format)),
                Map.entry(
                    "lte_date",
                    Optional.ofNullable(parameters.getLteDate())
                        .map(LOCAL_DATE_TIME_FORMATTER::format)),
                Map.entry(
                    "mono_stock",
                    Optional.ofNullable(parameters.getMonoStock())
                        .map(ItemListParameters.MonoStock::getValue)),
                Map.entry("output", Optional.ofNullable(parameters.getOutput())),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/ItemList")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(ItemListResponse.class)
        .getBody();
  }

  @Override
  public FloorListResponse getFloorList(FloorListParameters parameters) {
    Stream<Map.Entry<String, String>> params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/FloorList")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(FloorListResponse.class)
        .getBody();
  }

  @Override
  public ActressSearchResponse getActressSearch(ActressSearchParameters parameters) {
    Stream<Map.Entry<String, String>> params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("initial", Optional.ofNullable(parameters.getInitial())),
                Map.entry("actress_id", Optional.ofNullable(parameters.getActressId())),
                Map.entry("keyword", Optional.ofNullable(parameters.getKeyword())),
                Map.entry(
                    "gte_bust",
                    Optional.ofNullable(parameters.getGteBust()).map(Objects::toString)),
                Map.entry(
                    "lte_bust",
                    Optional.ofNullable(parameters.getLteBust()).map(Objects::toString)),
                Map.entry(
                    "gte_waist",
                    Optional.ofNullable(parameters.getGteWaist()).map(Objects::toString)),
                Map.entry(
                    "lte_waist",
                    Optional.ofNullable(parameters.getLteWaist()).map(Objects::toString)),
                Map.entry(
                    "gte_hip", Optional.ofNullable(parameters.getGteHip()).map(Objects::toString)),
                Map.entry(
                    "lte_hip", Optional.ofNullable(parameters.getLteHip()).map(Objects::toString)),
                Map.entry(
                    "gte_height",
                    Optional.ofNullable(parameters.getGteHeight()).map(Objects::toString)),
                Map.entry(
                    "lte_height",
                    Optional.ofNullable(parameters.getLteHeight()).map(Objects::toString)),
                Map.entry(
                    "gte_birthday",
                    Optional.ofNullable(parameters.getGteBirthday())
                        .map(LOCAL_DATE_FORMATTER::format)),
                Map.entry(
                    "lte_birthday",
                    Optional.ofNullable(parameters.getLteBirthday())
                        .map(LOCAL_DATE_FORMATTER::format)),
                Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
                Map.entry(
                    "offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
                Map.entry(
                    "sort",
                    Optional.ofNullable(parameters.getSort())
                        .map(ActressSearchParameters.Sort::getValue)),
                Map.entry("output", Optional.ofNullable(parameters.getOutput())),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/ActressSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(ActressSearchResponse.class)
        .getBody();
  }

  @Override
  public GenreSearchResponse getGenreSearch(SeriesSearchParameters parameters) {
    var params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("floor_id", Optional.of(parameters.getFloorId())),
                Map.entry("initial", Optional.ofNullable(parameters.getInitial())),
                Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
                Map.entry(
                    "offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
                Map.entry("output", Optional.ofNullable(parameters.getOutput())),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/GenreSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(GenreSearchResponse.class)
        .getBody();
  }

  @Override
  public MakerSearchResponse getMakerSearch(MakerSearchParameters parameters) {
    Stream<Map.Entry<String, String>> params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("floor_id", Optional.of(parameters.getFloorId())),
                Map.entry("initial", Optional.ofNullable(parameters.getInitial())),
                Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
                Map.entry(
                    "offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
                Map.entry("output", Optional.ofNullable(parameters.getOutput())),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/MakerSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(MakerSearchResponse.class)
        .getBody();
  }

  @Override
  public SeriesSearchResponse getSeriesSearch(SeriesSearchParameters parameters) {
    Stream<Map.Entry<String, String>> params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("floor_id", Optional.of(parameters.getFloorId())),
                Map.entry("initial", Optional.ofNullable(parameters.getInitial())),
                Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
                Map.entry(
                    "offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
                Map.entry("output", Optional.ofNullable(parameters.getOutput())),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/SeriesSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(SeriesSearchResponse.class)
        .getBody();
  }

  @Override
  public AuthorSearchResponse getAuthorSearch(AuthorSearchParameters parameters) {
    Stream<Map.Entry<String, String>> params =
        Stream.of(
                Map.entry(
                    "api_id",
                    Optional.ofNullable(parameters.getApiId())
                        .or(() -> Optional.ofNullable(this.apiId))),
                Map.entry(
                    "affiliate_id",
                    Optional.ofNullable(parameters.getAffiliateId())
                        .or(() -> Optional.ofNullable(this.affiliateId))),
                Map.entry("floor_id", Optional.of(parameters.getFloorId())),
                Map.entry("initial", Optional.ofNullable(parameters.getInitial())),
                Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
                Map.entry(
                    "offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
                Map.entry("output", Optional.ofNullable(parameters.getOutput())),
                Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
            .filter(entry -> entry.getValue().isPresent())
            .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));

    return Unirest.get(BASE_URL + "/AuthorSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(AuthorSearchResponse.class)
        .getBody();
  }
}
