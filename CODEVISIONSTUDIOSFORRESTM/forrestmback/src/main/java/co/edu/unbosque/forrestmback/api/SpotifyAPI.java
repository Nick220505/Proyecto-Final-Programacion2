package co.edu.unbosque.forrestmback.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.SearchItemRequest;

@RestController
@RequestMapping("/spotify")
public class SpotifyAPI {
	private static final String clientId = "f1d23c9acc7242d1b26e245e2a8d060d";
	private static final String clientSecret = "016750b67d6b4ef282136965971973e4";

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId)
			.setClientSecret(clientSecret).build();

	private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

	@GetMapping("track/{trackName}/{artistName}")
	public String getTrackId(@PathVariable String trackName, @PathVariable String artistName) throws Exception {
		refreshAccessToken();
		SearchItemRequest searchItemRequest = spotifyApi.searchItem(trackName, "track").build();
		SearchResult searchResult = searchItemRequest.execute();
		return Arrays.stream(searchResult.getTracks().getItems())
				.filter(track -> Arrays.stream(track.getArtists())
						.anyMatch(artist -> artist.getName().equalsIgnoreCase(artistName)))
				.findFirst()
				.map(track -> track.getId())
				.orElseThrow(() -> new NotFoundException());
	}

	@GetMapping("tracks/{name}")
	public List<String> searchTracks(@PathVariable String name) throws Exception {
		refreshAccessToken();
		SearchItemRequest searchItemRequest = spotifyApi.searchItem(name, "track").build();
		SearchResult searchResult = searchItemRequest.execute();
		return Arrays.stream(searchResult.getTracks().getItems())
				.map(track -> track.getName())
				.distinct()
				.collect(Collectors.toList());
	}

	@GetMapping("artists/{trackName}/{artistName}")
	public List<String> searchArtists(@PathVariable("trackName") String trackName,
			@PathVariable("artistName") String artistName) throws Exception {
		refreshAccessToken();
		SearchItemRequest trackSearchRequest = spotifyApi.searchItem(trackName, "track").build();
		SearchResult trackSearchResult = trackSearchRequest.execute();
		if (trackSearchResult.getTracks().getTotal() > 0) {
			return Arrays.stream(trackSearchResult.getTracks().getItems())
					.flatMap(track -> Arrays.stream(track.getArtists()))
					.filter(artist -> artist.getName().toLowerCase().contains(artistName.toLowerCase()))
					.map(artist -> artist.getName())
					.distinct()
					.collect(Collectors.toList());
		} else {
			throw new NotFoundException();
		}
	}

	private void refreshAccessToken() throws Exception {
		ClientCredentials clientCredentials = clientCredentialsRequest.execute();
		// Set access token for further "spotifyApi" object usage
		spotifyApi.setAccessToken(clientCredentials.getAccessToken());
	}

}
