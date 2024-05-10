package javamodelefinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmTest {

	private Film film;
	
	@Before
	public void setUp() throws Exception {
		film = new Film("0","titanic","drame","3h14","1997","James Cameron","16","17","18","15","10","2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetScore() {
		assertEquals(13, film.getScore(),0);	

	}
	
	@Test
	public void testCompareTo() {
		Film filmIdentique = new Film("0","titanic","drame","3h14","1997","James Cameron","16","17","18","15","10","2");
		assertEquals(0, film.compareTo(filmIdentique));
		
		Film filmeDiffrent = new Film("1","matrix","science fiction","3h14","1997","James Cameron","16","17","18","15","10","2");
		assertNotEquals(0, film.compareTo(filmeDiffrent));
	}
	
	

	@Test
	public void testGetScoreDelta() {
		assertEquals(13, film.getScore(),0.2);
	}
	
}
