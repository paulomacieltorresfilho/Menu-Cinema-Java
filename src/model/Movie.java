package model;
public class Movie{
    
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
    public String toString() {
        String text = "";
        text += "Nome: " + this.name + "\n";
        text += "Sinopse: " + this.synopsis + "\n";
        text += "Gênero: " + this.genre + "\n";
        text += "Duração : " + this.duration + "min";
        return text;
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
