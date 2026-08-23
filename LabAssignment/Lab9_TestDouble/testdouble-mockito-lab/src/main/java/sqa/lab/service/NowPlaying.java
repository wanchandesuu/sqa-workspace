package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 * Instructor: Asst.Prof. Chitsutha Soomlek
 *
 */

import java.util.ArrayList;
import java.util.List;

public class NowPlaying {

	private MovieService movieService;

	public NowPlaying(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	public String getMoviesByCinemaType(String location, String date, String cinemaType) {
		List<String> allMovies = movieService.getMovies(location, date);
		List<String> filteredMovies = new ArrayList<String>();

		for (String movie : allMovies) {
			if (movie.contains(cinemaType)) {
				String title = movie.substring(0, movie.indexOf("[")).trim();
				filteredMovies.add(title);
			}
		}
		return String.join(", ", filteredMovies);
	}
}
