import java.util.GregorianCalendar;

import model.*;

public class Testes {
    public static void main(String[] args) {
    	
    	Movie.viewMovies();
    	testMovie();
    	Movie.viewMovies();
    }
    
    public static void testMovie() {
        Movie m;
    
        m = new Movie("As aventuras de pi", 
        "menino ficou preso com um leão num barco texto texto texto texto texto textobarco texto texto texto texto texto textobarco texto texto texto texto texto texto",
        "Aventura",
        135);
        m.register();
    
        m = new Movie("Velozes e Calv(m)os",
        "Os carecas mais velozes do oeste",
        "Corrida vrum vrum",
        200);
        m.register();
    
        m = new Movie("Minions",
        "Banana bananana ba nanaan",
        "Amarelo",
        45);
        m.register();
    
        m = new Movie("TIM, O Filme",
        "Tim maia ou TIM? você decide",
        "Azul da cor do mar",
        222);
        m.register();
    
        m = new Movie("Menino ney",
        "Coletânea das melhores jogadas do nosso centro-avante preferido",
        "Futebol",
        10);
        m.register();
    
        m = Movie.getMovie("TIM, O Filme");
        m.update(2, "AAAAAAAAA SE O MUNDO INTEIRO ME PUDESSE OUVIR");
        m.update(3, 2);
        
        System.out.println("------------------------");
    }

    public static void testSession() {
        Movie m = new Movie("TIM, O Filme",
        "Tim maia ou TIM? você decide",
        "Azul da cor do mar",
        222);
        GregorianCalendar gcal = new GregorianCalendar(2021, 9, 20, 21, 00);
        Session s = new Session(m, gcal, 'a', true, 10.00);
        s.register();

        m = new Movie("Menino ney",
        "Coletânea das melhores jogadas do nosso centro-avante preferido",
        "Futebol",
        10);
        gcal = new GregorianCalendar(2021, 9, 20, 21, 0);
        s = new Session(m, gcal, 'b', false, 8.50);
        s.register();

        m = new Movie("Minions",
        "Banana bananana ba nanaan",
        "Amarelo",
        45);
        gcal = new GregorianCalendar(2021, 9, 20, 20, 14);
        s = new Session(m, gcal, 'b', false, 8.50);
        s.register();
        
        m = new Movie("Velozes e Calv(m)os",
        "Os carecas mais velozes do oeste",
        "Corrida vrum vrum",
        200);
        gcal = new GregorianCalendar(2021, 9, 14, 13, 30);
        s = new Session(m, gcal, 'a', true, 10.00);
        s.register();
    }
}
