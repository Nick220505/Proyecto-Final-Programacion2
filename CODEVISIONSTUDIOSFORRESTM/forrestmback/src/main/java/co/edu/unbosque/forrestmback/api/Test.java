package co.edu.unbosque.forrestmback.api;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Category;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.browse.GetListOfCategoriesRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.Arrays;

public class Test {
	private static final String clientId = "f1d23c9acc7242d1b26e245e2a8d060d";
	private static final String clientSecret = "016750b67d6b4ef282136965971973e4";

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId(clientId)
			.setClientSecret(clientSecret)
			.build();

	private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
	
//          .country(CountryCode.SE)
//          .limit(10)
//          .offset(0)
//          .locale("sv_SE")

  public static void getListOfCategories_Sync() {
	  try {		  
		  ClientCredentials clientCredentials = clientCredentialsRequest.execute();
		  spotifyApi.setAccessToken(clientCredentials.getAccessToken());
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
    try {
    	GetListOfCategoriesRequest getListOfCategoriesRequest = spotifyApi.getListOfCategories().build();
      final Paging<Category> categoryPaging = getListOfCategoriesRequest.execute();

      Arrays.stream(categoryPaging.getItems()).forEach(c -> System.out.println(c.getName()));
      
      System.out.println("Total: " + categoryPaging.getTotal());
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    getListOfCategories_Sync();
  }
}