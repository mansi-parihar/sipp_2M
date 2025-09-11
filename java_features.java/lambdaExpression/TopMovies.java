package lambdaExpression;
import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int year;

    Movie(String title, double rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }

    public String toString() {
        return title + " (" + year + ") - Rating: " + rating;
    }
}

public class TopMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 7.8, 2021),
            new Movie("Movie C", 9.0, 2024),
            new Movie("Movie D", 8.2, 2022),
            new Movie("Movie E", 9.1, 2024),
            new Movie("Movie F", 7.9, 2023),
            new Movie("Movie G", 8.8, 2024)
        );

        movies.stream()
              .filter(m -> m.year >= 2022)
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed())
              .limit(5)
              .forEach(System.out::println);
    }
}

    
}
