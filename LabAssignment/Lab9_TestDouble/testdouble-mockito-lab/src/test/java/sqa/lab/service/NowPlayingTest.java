package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import sqa.lab.data.stub.MovieServiceStub;

class NowPlayingTest {

	@Test
	void test_getMoviesByCinemaType_VIP_withStub() {
		MovieService movieService = new MovieServiceStub();
		NowPlaying nowPlaying = new NowPlaying(movieService);

		String result = nowPlaying.getMoviesByCinemaType("Central Khon Kaen", "2025-09-01", "VIP");

		assertEquals("Mission Impossible 8, Jurassic World Rebirth, Thunderbolts", result);
	}

	@Test
	void test_getMoviesByCinemaType_IMAX_withStub() {
		MovieService movieService = new MovieServiceStub();
		NowPlaying nowPlaying = new NowPlaying(movieService);

		String result = nowPlaying.getMoviesByCinemaType("Central Khon Kaen", "2025-09-01", "IMAX with Laser");

		assertEquals("The Odyssey, Spider-Man: Brand New Day, The End of Oak Street", result);
	}

	@Test
	void test_getMoviesByCinemaType_VIP_withMockito() {
		MovieService movieService = mock(MovieService.class);
		List<String> movieList = Arrays.asList(
			"Mission Impossible 8 [VIP]",
			"Jurassic World Rebirth [VIP]",
			"Thunderbolts [VIP]",
			"The Odyssey [IMAX with Laser]",
			"How to Train Your Dragon [4DX]"
		);

		when(movieService.getMovies("Central Khon Kaen", "2025-09-01")).thenReturn(movieList);

		NowPlaying nowPlaying = new NowPlaying(movieService);
		String result = nowPlaying.getMoviesByCinemaType("Central Khon Kaen", "2025-09-01", "VIP");

		assertEquals("Mission Impossible 8, Jurassic World Rebirth, Thunderbolts", result);
	}

	@Test
	void test_getMoviesByCinemaType_IMAX_withMockito() {
		MovieService movieService = mock(MovieService.class);
		List<String> movieList = Arrays.asList(
			"The Odyssey [IMAX with Laser]",
			"Spider-Man: Brand New Day [IMAX with Laser]",
			"The End of Oak Street [IMAX with Laser]",
			"Mission Impossible 8 [VIP]"
		);

		when(movieService.getMovies("Central Khon Kaen", "2025-09-01")).thenReturn(movieList);

		NowPlaying nowPlaying = new NowPlaying(movieService);
		String result = nowPlaying.getMoviesByCinemaType("Central Khon Kaen", "2025-09-01", "IMAX with Laser");

		assertEquals("The Odyssey, Spider-Man: Brand New Day, The End of Oak Street", result);
	}

	@Test
	void test_getMoviesByCinemaType_noMatch_withMockito() {
		MovieService movieService = mock(MovieService.class);
		List<String> movieList = Arrays.asList(
			"The Odyssey [IMAX with Laser]",
			"Mission Impossible 8 [VIP]"
		);

		when(movieService.getMovies("Central Khon Kaen", "2025-09-01")).thenReturn(movieList);

		NowPlaying nowPlaying = new NowPlaying(movieService);
		String result = nowPlaying.getMoviesByCinemaType("Central Khon Kaen", "2025-09-01", "4DX");

		assertEquals("", result);
	}
}
