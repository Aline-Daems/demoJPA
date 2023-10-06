package be.technobel.adae;

import Entities.Cinemas;
import Entities.Movies;
import repositories.CRUD;

import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CRUD movieRepo = new CRUD();
        Movies movie1 = new Movies("Star wars", "Georges Lucas", 1977, new Cinemas("UGC", "Bruxelles"));
        Movies movie2 = new Movies("Harry Potter à l'école des sorciers", "Chris Columbus", 2001, new Cinemas("Kinepolis", "Liège"));
        Movies movie3 = new Movies("Le Seigneur des Anneaux les deux tours", "Peter Jackson", 2002,new Cinemas("Kinepolis", "Liège"));

        movie1 = movieRepo.add(movie1);
        movie2 = movieRepo.add(movie2);

        Movies movieResult = movieRepo.getOne(1L);

        System.out.println(movieResult);

        List<Movies> moviesList = movieRepo.getAll();

        moviesList.forEach(System.out::println);

        movieRepo.update(movie3);

        movieRepo.delete(movie1);

        List<Movies> result = movieRepo.search("Le Seigneur des Anneaux les deux tours");

        result.forEach(System.out::println);
    }
}
