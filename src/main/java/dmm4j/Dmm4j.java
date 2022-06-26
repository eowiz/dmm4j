package dmm4j;

import dmm4j.exception.Dmm4jException;
import java.net.http.HttpResponse;

public interface Dmm4j {

  ItemListResponse getItemList(ItemListParameters parameters);

  HttpResponse<String> getItemListRawResponse(ItemListParameters parameters) throws Dmm4jException;

  FloorListResponse getFloorList(FloorListParameters parameters);

  HttpResponse<String> getFloorListRawResponse(FloorListParameters parameters)
      throws Dmm4jException;

  ActressSearchResponse getActressSearch(ActressSearchParameters parameters);

  HttpResponse<String> getActressSearchRawResponse(ActressSearchParameters parameters)
      throws Dmm4jException;

  GenreSearchResponse getGenreSearch(GenreSearchParameters parameters);

  HttpResponse<String> getGenreSearchRawResponse(GenreSearchParameters parameters)
      throws Dmm4jException;

  MakerSearchResponse getMakerSearch(MakerSearchParameters parameters);

  HttpResponse<String> getMakerSearchRawResponse(MakerSearchParameters parameters)
      throws Dmm4jException;

  SeriesSearchResponse getSeriesSearch(SeriesSearchParameters parameters);

  HttpResponse<String> getSeriesSearchRawResponse(SeriesSearchParameters parameters)
      throws Dmm4jException;

  AuthorSearchResponse getAuthorSearch(AuthorSearchParameters parameters);

  HttpResponse<String> getAuthorSearchRawResponse(AuthorSearchParameters parameters)
      throws Dmm4jException;

  static Dmm4j getInstance() {
    return Dmm4jImpl.INSTANCE;
  }

  static Dmm4j getInstance(String apiId, String affiliateId) {
    return new Dmm4jImpl(apiId, affiliateId);
  }
}
