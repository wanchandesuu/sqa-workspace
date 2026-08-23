package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 * Instructor: Asst.Prof. Chitsutha Soomlek
 *
 */

import java.util.List;

public interface MovieService {

	public List<String> getMovies(String location, String date);

}
