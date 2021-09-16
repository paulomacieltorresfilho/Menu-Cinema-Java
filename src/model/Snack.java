package model;
import java.util.ArrayList;

public class Snack implements Entity {
    
    private static ArrayList<Snack> snackList = new ArrayList<Snack>();

    private String name;
    private double price;
    private int stockQuantity;

    public Snack(String name, double price, int stockQuantity) {
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
    }

    public void sellSnack(int quantity) {
        int newQuantity = this.getStockQuantity() - quantity;
        if (newQuantity >= 0) {
            this.setStockQuantity(newQuantity);
        }
    }
    
    @Override
    public void register() {
        if (!snackList.contains(this)){
            snackList.add(this);
        } else {
            System.out.println("Lanche já cadastrado!");
        }
    }

    @Override
    public void update(int option, Object e) {
        switch (option) {
            case 0: // Update Name
                this.setName((String) e);
                break;
            case 1: // Update Price
                this.setPrice((double) e);
                break;
            case 2: // Update Quantity
                this.setStockQuantity((int) e);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    
    @Override
    public void view() {
        System.out.println(this);
    }

    public static void viewSnacks() {
        System.out.println("Nome | Quantidade disponível");
        for (Snack s : snackList) {
            System.out.println(s.getName() + " | " + s.getStockQuantity());
        }
    }
    
    @Override
    public void delete() {
        snackList.remove(this);
    }

    @Override
    public String toString() {
        String text = "";
        text += "Nome: " + this.name + "\n";
        text += "Preço: " + this.price + "\n";
        text += "Quantidade em estoque: " + this.stockQuantity;
        return text;
    }

    public static Snack getSnack(int index) {
        return snackList.get(index);
    }
    public static Snack getSnack(String name) {
        for (Snack s : snackList) {
            if (s.getName().equals(name)) {
                return s;
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
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
    
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
