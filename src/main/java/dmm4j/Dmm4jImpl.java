package dmm4j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import dmm4j.exception.Dmm4jException;
import dmm4j.parameters.ActressSearchParameters;
import dmm4j.parameters.AuthorSearchParameters;
import dmm4j.parameters.FloorListParameters;
import dmm4j.parameters.GenreSearchParameters;
import dmm4j.parameters.ItemListParameters;
import dmm4j.parameters.MakerSearchParameters;
import dmm4j.parameters.SeriesSearchParameters;
import dmm4j.responses.ActressSearchResponse;
import dmm4j.responses.AuthorSearchResponse;
import dmm4j.responses.FloorListResponse;
import dmm4j.responses.GenreSearchResponse;
import dmm4j.responses.ItemListResponse;
import dmm4j.responses.MakerSearchResponse;
import dmm4j.responses.SeriesSearchResponse;
import jakarta.annotation.Nonnull;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kong.unirest.Unirest;
import kong.unirest.jackson.JacksonObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

public final class Dmm4jImpl implements Dmm4j {

  static final Dmm4j INSTANCE = new Dmm4jImpl();

  private static final String SCHEMA = "https";

  private static final String HOST = "api.dmm.com";

  private static final String BASE_PATH = "/affiliate/v3";

  private static final String BASE_URL = SCHEMA + "://" + HOST + BASE_PATH;

  private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

  /** API ID. */
  @Getter @Setter private String apiId;

  /** アフィリエイトID. */
  @Getter @Setter private String affiliateId;

  Dmm4jImpl() {
    val objectMapper =
        new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    final var jacksonObjectMapper = new JacksonObjectMapper(objectMapper);
    Unirest.config().setObjectMapper(jacksonObjectMapper);
  }

  Dmm4jImpl(String apiId, String affiliateId) {
    this();

    this.apiId = apiId;
    this.affiliateId = affiliateId;
  }

  @Nonnull
  private URI buildURI(String pathSegment, Stream<Map.Entry<String, String>> parameters)
      throws Dmm4jException {
    val nameValuePairs =
        parameters
            .map(entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
            .collect(Collectors.<NameValuePair>toList());

    try {
      return new URIBuilder()
          .setScheme(SCHEMA)
          .setHost(HOST)
          .setPath(BASE_PATH + "/" + pathSegment)
          .setParameters(nameValuePairs)
          .build();
    } catch (URISyntaxException e) {
      throw new Dmm4jException(e);
    }
  }

  @Override
  public ItemListResponse getItemList(ItemListParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/ItemList")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(ItemListResponse.class)
        .getBody();
  }

  @Override
  public HttpResponse<String> getItemListRawResponse(ItemListParameters parameters)
      throws Dmm4jException {
    return this.get("ItemList", parameters, this::buildQuery);
  }

  @Nonnull
  private Stream<Map.Entry<String, String>> buildQuery(ItemListParameters parameters) {
    return Stream.of(
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
            Map.entry("offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
            Map.entry(
                "sort",
                Optional.ofNullable(parameters.getSort()).map(ItemListParameters.Sort::getValue)),
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
            Map.entry("output", Optional.ofNullable(parameters.getOutput()).map(Output::getValue)),
            Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
        .filter(entry -> entry.getValue().isPresent())
        .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));
  }

  @Override
  public FloorListResponse getFloorList(FloorListParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/FloorList")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(FloorListResponse.class)
        .getBody();
  }

  @Override
  public HttpResponse<String> getFloorListRawResponse(FloorListParameters parameters)
      throws Dmm4jException {
    return this.get("FloorList", parameters, this::buildQuery);
  }

  @Nonnull
  private Stream<Map.Entry<String, String>> buildQuery(FloorListParameters parameters) {
    return Stream.of(
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
  }

  @Override
  public ActressSearchResponse getActressSearch(ActressSearchParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/ActressSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(ActressSearchResponse.class)
        .getBody();
  }

  public HttpResponse<String> getActressSearchRawResponse(ActressSearchParameters parameters)
      throws Dmm4jException {
    return this.get("ActressSearch", parameters, this::buildQuery);
  }

  private Stream<Map.Entry<String, String>> buildQuery(ActressSearchParameters parameters) {
    return Stream.of(
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
                "gte_bust", Optional.ofNullable(parameters.getGteBust()).map(Objects::toString)),
            Map.entry(
                "lte_bust", Optional.ofNullable(parameters.getLteBust()).map(Objects::toString)),
            Map.entry(
                "gte_waist", Optional.ofNullable(parameters.getGteWaist()).map(Objects::toString)),
            Map.entry(
                "lte_waist", Optional.ofNullable(parameters.getLteWaist()).map(Objects::toString)),
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
                Optional.ofNullable(parameters.getGteBirthday()).map(LOCAL_DATE_FORMATTER::format)),
            Map.entry(
                "lte_birthday",
                Optional.ofNullable(parameters.getLteBirthday()).map(LOCAL_DATE_FORMATTER::format)),
            Map.entry("hits", Optional.ofNullable(parameters.getHits()).map(Objects::toString)),
            Map.entry("offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
            Map.entry(
                "sort",
                Optional.ofNullable(parameters.getSort())
                    .map(ActressSearchParameters.Sort::getValue)),
            Map.entry("output", Optional.ofNullable(parameters.getOutput()).map(Output::getValue)),
            Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
        .filter(entry -> entry.getValue().isPresent())
        .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));
  }

  @Override
  public GenreSearchResponse getGenreSearch(GenreSearchParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/GenreSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(GenreSearchResponse.class)
        .getBody();
  }

  public HttpResponse<String> getGenreSearchRawResponse(GenreSearchParameters parameters)
      throws Dmm4jException {
    return this.get("GenreSearch", parameters, this::buildQuery);
  }

  @Nonnull
  private Stream<Map.Entry<String, String>> buildQuery(GenreSearchParameters parameters) {
    return Stream.of(
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
            Map.entry("offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
            Map.entry("output", Optional.ofNullable(parameters.getOutput()).map(Output::getValue)),
            Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
        .filter(entry -> entry.getValue().isPresent())
        .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));
  }

  @Override
  public MakerSearchResponse getMakerSearch(MakerSearchParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/MakerSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(MakerSearchResponse.class)
        .getBody();
  }

  public HttpResponse<String> getMakerSearchRawResponse(MakerSearchParameters parameters)
      throws Dmm4jException {
    return this.get("MakerSearch", parameters, this::buildQuery);
  }

  @Nonnull
  private Stream<Map.Entry<String, String>> buildQuery(MakerSearchParameters parameters) {
    return Stream.of(
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
            Map.entry("offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
            Map.entry("output", Optional.ofNullable(parameters.getOutput()).map(Output::getValue)),
            Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
        .filter(entry -> entry.getValue().isPresent())
        .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));
  }

  @Override
  public SeriesSearchResponse getSeriesSearch(SeriesSearchParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/SeriesSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(SeriesSearchResponse.class)
        .getBody();
  }

  public HttpResponse<String> getSeriesSearchRawResponse(SeriesSearchParameters parameters)
      throws Dmm4jException {
    return this.get("SeriesSearch", parameters, this::buildQuery);
  }

  @Nonnull
  private Stream<Entry<String, String>> buildQuery(SeriesSearchParameters parameters) {
    return Stream.of(
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
            Map.entry("offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
            Map.entry("output", Optional.ofNullable(parameters.getOutput()).map(Output::getValue)),
            Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
        .filter(entry -> entry.getValue().isPresent())
        .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));
  }

  @Override
  public AuthorSearchResponse getAuthorSearch(AuthorSearchParameters parameters) {
    val params = this.buildQuery(parameters);

    return Unirest.get(BASE_URL + "/AuthorSearch")
        .queryString(params.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        .asObject(AuthorSearchResponse.class)
        .getBody();
  }

  public HttpResponse<String> getAuthorSearchRawResponse(AuthorSearchParameters parameters)
      throws Dmm4jException {
    return this.get("AuthorSearch", parameters, this::buildQuery);
  }

  @Nonnull
  private Stream<Entry<String, String>> buildQuery(AuthorSearchParameters parameters) {
    return Stream.of(
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
            Map.entry("offset", Optional.ofNullable(parameters.getOffset()).map(Objects::toString)),
            Map.entry("output", Optional.ofNullable(parameters.getOutput()).map(Output::getValue)),
            Map.entry("callback", Optional.ofNullable(parameters.getCallback())))
        .filter(entry -> entry.getValue().isPresent())
        .map(entry -> Map.entry(entry.getKey(), entry.getValue().get()));
  }

  private <T> HttpResponse<String> get(
      String pathSegment, T parameter, Function<T, Stream<Entry<String, String>>> buildQueryFunc)
      throws Dmm4jException {
    val request =
        HttpRequest.newBuilder()
            .GET()
            .uri(this.buildURI(pathSegment, buildQueryFunc.apply(parameter)))
            .build();

    final var client = HttpClient.newHttpClient();

    try {
      return client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new Dmm4jException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new Dmm4jException(e);
    }
  }
}
