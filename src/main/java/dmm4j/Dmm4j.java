package dmm4j;

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
import java.net.http.HttpResponse;

public interface Dmm4j {

  ItemListResponse getItemList(ItemListParameters parameters) throws Dmm4jException;

  HttpResponse<String> getItemListRawResponse(ItemListParameters parameters) throws Dmm4jException;

  FloorListResponse getFloorList(FloorListParameters parameters) throws Dmm4jException;

  HttpResponse<String> getFloorListRawResponse(FloorListParameters parameters)
      throws Dmm4jException;

  ActressSearchResponse getActressSearch(ActressSearchParameters parameters) throws Dmm4jException;

  HttpResponse<String> getActressSearchRawResponse(ActressSearchParameters parameters)
      throws Dmm4jException;

  GenreSearchResponse getGenreSearch(GenreSearchParameters parameters) throws Dmm4jException;

  HttpResponse<String> getGenreSearchRawResponse(GenreSearchParameters parameters)
      throws Dmm4jException;

  MakerSearchResponse getMakerSearch(MakerSearchParameters parameters) throws Dmm4jException;

  HttpResponse<String> getMakerSearchRawResponse(MakerSearchParameters parameters)
      throws Dmm4jException;

  SeriesSearchResponse getSeriesSearch(SeriesSearchParameters parameters) throws Dmm4jException;

  HttpResponse<String> getSeriesSearchRawResponse(SeriesSearchParameters parameters)
      throws Dmm4jException;

  AuthorSearchResponse getAuthorSearch(AuthorSearchParameters parameters) throws Dmm4jException;

  HttpResponse<String> getAuthorSearchRawResponse(AuthorSearchParameters parameters)
      throws Dmm4jException;

  static Dmm4j getInstance() {
    return Dmm4jImpl.INSTANCE;
  }

  /**
   * @param apiId APIID
   * @param affiliateId AFFILIATE ID
   * @return
   */
  static Dmm4j getInstance(String apiId, String affiliateId) {
    return new Dmm4jImpl(apiId, affiliateId);
  }
}
