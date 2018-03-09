package tyro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Movie {

  public static void main(String[] args) throws Exception{
    getMovieTitles("spiderman");
  }

  static String[] getMovieTitles(final String substr) {

    Integer start = 1;
    Integer totalPages = 1;
    final java.util.List<String> titles = new java.util.ArrayList<>();

    while(totalPages >= start){
      final FetchReponse res = fetchMovieTitles(substr,start);

      if(res.response.length > 0){
        titles.addAll(java.util.Arrays.asList(res.response));
      }
      start++;
      totalPages = res.totalPages;
    }

    final java.util.List<String> uniqueTitles =
        titles.stream().sorted().collect(java.util.stream.Collectors.toList());

    return uniqueTitles.toArray(new String[uniqueTitles.size()]);


  }

  static FetchReponse fetchMovieTitles(final String substr, final Integer page) {

    try{

      final String s = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d";

      final java.net.URL url = new java.net.URL(String.format(s,substr,page));
      java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");

      final Integer status = conn.getResponseCode();

      if(status >= 200){

        final com.google.gson.Gson gson = new com.google.gson.Gson();
        MovieResponse response = null;

        try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()))) {
          response = gson.fromJson(in,MovieResponse.class);
        }

        final java.util.List<String> titles = response.getData().stream().map(m -> m.getTitle()).collect(
            java.util.stream.Collectors.toList());

        return new FetchReponse(titles.toArray(new String[titles.size()]), response.getTotal_pages());

      }

    }catch (java.io.IOException ioe){
      return new FetchReponse();
    }

    return new FetchReponse();

  }


  class MovieResponse{
    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer total_pages;
    private java.util.List<MovieData> data;

    public Integer getPage() {
      return page;
    }

    public void setPage(Integer page) {
      this.page = page;
    }

    public Integer getPerPage() {
      return perPage;
    }

    public void setPerPage(Integer perPage) {
      this.perPage = perPage;
    }

    public Integer getTotal() {
      return total;
    }

    public void setTotal(Integer total) {
      this.total = total;
    }

    public Integer getTotal_pages() {
      return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
      this.total_pages = total_pages;
    }

    public java.util.List<MovieData> getData() {
      return data;
    }

    public void setData(java.util.List<MovieData> data) {
      this.data = data;
    }
  }

  class MovieData{
    private String Poster;
    private String Title;
    private String Type;
    private String Year;
    private String imdbID;

    public String getPoster() {
      return Poster;
    }

    public void setPoster(String poster) {
      Poster = poster;
    }

    public String getTitle() {
      return Title;
    }

    public void setTitle(String title) {
      Title = title;
    }

    public String getType() {
      return Type;
    }

    public void setType(String type) {
      Type = type;
    }

    public String getYear() {
      return Year;
    }

    public void setYear(String year) {
      Year = year;
    }

    public String getImdbID() {
      return imdbID;
    }

    public void setImdbID(String imdbID) {
      this.imdbID = imdbID;
    }
  }

  static class FetchReponse{
    public String[] response = new String[]{};
    public Integer totalPages = 0;

    public FetchReponse(String[] response, Integer totalPages) {
      this.response = response;
      this.totalPages = totalPages;
    }

    public FetchReponse(){

    }

  }

}
