package dmm4j;

public interface Dmm4j {

    ItemListResponse getItemList(ItemListParameters parameters);

    FloorListResponse getFloorList(FloorListParameters parameters);

    ActressSearchResponse getActressSearch(ActressSearchParameters parameters);

    GenreSearchResponse getGenreSearch(SeriesSearchParameters parameters);

    MakerSearchResponse getMakerSearch(MakerSearchParameters parameters);

    SeriesSearchResponse getSeriesSearch(SeriesSearchParameters parameters);

    AuthorSearchResponse getAuthorSearch(AuthorSearchParameters parameters);

    static Dmm4j getInstance() {
        return Dmm4jImpl.INSTANCE;
    }
}
