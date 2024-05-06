package co.edu.unbosque.forrestmback.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neovisionaries.i18n.CountryCode;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.special.FeaturedPlaylists;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistsAlbumsRequest;
import se.michaelthelin.spotify.requests.data.browse.GetListOfFeaturedPlaylistsRequest;
import se.michaelthelin.spotify.requests.data.search.SearchItemRequest;

@RestController
@RequestMapping("/spotify")
public class SpotifyAPI {
	private static final String clientId = "f1d23c9acc7242d1b26e245e2a8d060d";
	private static final String clientSecret = "016750b67d6b4ef282136965971973e4";

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId(clientId)
			.setClientSecret(clientSecret)
			.build();

	private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

	@GetMapping("track/{trackName}/{artistName}")
	public String getTrackId(@PathVariable String trackName, @PathVariable String artistName) throws Exception {
		refreshAccessToken();
		return Arrays.stream(spotifyApi.searchTracks(trackName).build().execute().getItems())
				.filter(track -> Arrays.stream(track.getArtists())
				.anyMatch(artist -> artist.getName().equalsIgnoreCase(artistName)))
				.findFirst()
				.map(Track::getId)
				.orElseThrow(() -> new NotFoundException());
	}

	@GetMapping("tracks/{trackName}")
	public List<String> searchTracksByName(@PathVariable String trackName) throws Exception {
		refreshAccessToken();
		return Arrays.stream(spotifyApi.searchTracks(trackName).build().execute().getItems())
				.map(Track::getName)
				.distinct()
				.collect(Collectors.toList());
	}

	@GetMapping("tracks/{trackName}/{artistName}")
	public List<String> searchTracksByNameAndArtist(@PathVariable("trackName") String trackName,
			@PathVariable("artistName") String artistName) throws Exception {
		refreshAccessToken();
		SearchItemRequest artistItemRequest = spotifyApi.searchItem(artistName, "artist").build();
		SearchResult searchResult = artistItemRequest.execute();
		String artistId = Arrays.stream(searchResult.getArtists().getItems())
				.findFirst()
				.map(Artist::getId)
				.orElseThrow(() -> new NotFoundException());

		GetArtistsAlbumsRequest artistsAlbumsRequest = spotifyApi.getArtistsAlbums(artistId).build();
		Paging<AlbumSimplified> artistsAlbumsResult = artistsAlbumsRequest.execute();

		List<String> trackNames = new ArrayList<>();
		for (AlbumSimplified album : artistsAlbumsResult.getItems()) {
			GetAlbumsTracksRequest albumTracksRequest = spotifyApi.getAlbumsTracks(album.getId()).build();
			Paging<TrackSimplified> albumTracksResult = albumTracksRequest.execute();
			trackNames.addAll(Arrays.stream(albumTracksResult.getItems())
					.filter(track -> track.getName().toLowerCase().contains(trackName.toLowerCase())
							&& !track.getName().contains("-"))
					.map(TrackSimplified::getName)
					.distinct()
					.collect(Collectors.toList()));
		}

		if (trackNames.isEmpty()) {
			throw new NotFoundException();
		}

		return trackNames.stream()
				.distinct()
				.collect(Collectors.toList());
	}

	@GetMapping("artists/{artistName}")
	public List<String> searchArtistsByName(@PathVariable String artistName) throws Exception {
		refreshAccessToken();
		return Arrays.stream(spotifyApi.searchArtists(artistName).build().execute().getItems())
				.map(Artist::getName)
				.distinct()
				.collect(Collectors.toList());
	}

	@GetMapping("artists/{trackName}/{artistName}")
	public List<String> searchArtistsByNameAndTrack(@PathVariable("trackName") String trackName,
			@PathVariable("artistName") String artistName) throws Exception {
		refreshAccessToken();
		SearchItemRequest trackSearchRequest = spotifyApi.searchItem(trackName, "track").build();
		SearchResult trackSearchResult = trackSearchRequest.execute();
		if (trackSearchResult.getTracks().getTotal() > 0) {
			return Arrays.stream(trackSearchResult.getTracks().getItems())
					.flatMap(track -> Arrays.stream(track.getArtists()))
					.filter(artist -> artist.getName().toLowerCase().contains(artistName.toLowerCase()))
					.map(ArtistSimplified::getName)
					.distinct()
					.collect(Collectors.toList());
		} else {
			throw new NotFoundException();
		}
	}

	@GetMapping("genres")
	public List<String> searchAllGenres() throws Exception {
		refreshAccessToken();
		return Arrays.asList(spotifyApi.getAvailableGenreSeeds().build().execute());
	}

	@GetMapping("genres/{genre}")
	public List<String> searchGenres(@PathVariable String genre) throws Exception {
		return searchAllGenres().stream()
				.filter(searchedGenre -> searchedGenre.toLowerCase().contains(genre.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("playlists")
	public List<String> searchFeaturedPlaylists() throws Exception {
		refreshAccessToken();
		GetListOfFeaturedPlaylistsRequest getListOfFeaturedPlaylistsRequest = spotifyApi.getListOfFeaturedPlaylists()
				.country(CountryCode.CO)
				.limit(6)
				.offset(0)
				.build();
		final FeaturedPlaylists featuredPlaylists = getListOfFeaturedPlaylistsRequest.execute();
		return Arrays.stream(featuredPlaylists.getPlaylists().getItems())
				.map(PlaylistSimplified::getId)
				.collect(Collectors.toList());
	}

	private void refreshAccessToken() throws Exception {
		ClientCredentials clientCredentials = clientCredentialsRequest.execute();
		spotifyApi.setAccessToken(clientCredentials.getAccessToken());
	}

}
