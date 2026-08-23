package sqa.lab.data.stub;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 * Instructor: Asst.Prof. Chitsutha Soomlek
 *
 */

import java.util.Arrays;
import java.util.List;

import sqa.lab.service.MovieService;

public class MovieServiceStub implements MovieService {

	public List<String> getMovies(String location, String date) {
		return Arrays.asList(
			"The Odyssey [IMAX with Laser]",
			"Spider-Man: Brand New Day [IMAX with Laser]",
			"The End of Oak Street [IMAX with Laser]",
			"Mission Impossible 8 [VIP]",
			"Jurassic World Rebirth [VIP]",
			"Thunderbolts [VIP]",
			"How to Train Your Dragon [4DX]",
			"Lilo & Stitch [Normal]"
		);
	}
}
