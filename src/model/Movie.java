package model;
import java.util.ArrayList;

public class Movie implements Entity{

    private static ArrayList<Movie> movieList = new ArrayList<Movie>();
    
    private String name;
    private String synopsis;
    private String genre;
    private int duration;

    public Movie(String name, String synopsis, String genre, int duration) {
        this.setName(name);
        this.setSynopsis(synopsis);
        this.setGenre(genre);
        this.setDuration(duration);
    }

    @Override
    public void register() {
        if (!movieList.contains(this)) {
            movieList.add(this);
        } else {
            System.out.println("Filme já cadastrado!");
        }
    }

    @Override
    public void update(int option, Object e) {
        switch (option) {
            case 0:
                this.setName((String) e);
                break;
            case 1:
                this.setSynopsis((String) e);
                break;
            case 2:
                this.setGenre((String) e);
                break;
            case 3:
                this.setDuration((int) e);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    @Override
    public void view() {
        System.out.println(this);
    }

    public static void viewMovies() {
        System.out.println("Filme | Duração");
        for (Movie m : movieList) {
            System.out.println(m.getName() + " | " + m.getDuration() + "min");
        }
    }

    @Override
    public void delete() {
        movieList.remove(this);
    }
    
    @Override
    public String toString() {
        String text = "";
        text += "Nome: " + this.name + "\n";
        text += "Sinopse: " + this.synopsis + "\n";
        text += "Gênero: " + this.genre + "\n";
        text += "Duração : " + this.duration + "min";
        return text;
    }

    public static Movie getMovie(int index) {
        return movieList.get(index);
    }

    public static Movie getMovie(String name) {
        for (Movie m : movieList) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    // Gets & Sets
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getSynopsis() {
        return synopsis;
    }
    
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
}
