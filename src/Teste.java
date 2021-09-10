import java.util.*;

public class Teste {
    
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("o rato roeu");
        list.add("a roupa do rei");
        list.add("de roma");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }

        System.out.println("xxxxxxxxxxxxxx");

        list.remove("a roupa do rei");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
    }
}
