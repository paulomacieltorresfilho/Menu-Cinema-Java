package model;

public class Snack{

    private String name;
    private double price;
    private int stockQuantity;
    private boolean available;

    public Snack(String name, double price, int stockQuantity) {
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
        this.checkAvailability();
    }

    public void sellSnack(int quantity) {
        int newQuantity = this.getStockQuantity() - quantity;
        if (newQuantity >= 0) {
            this.setStockQuantity(newQuantity);
            this.checkAvailability();
        }
    }
    
    public void checkAvailability() {
    	if (this.stockQuantity <= 0) {
    		this.setAvailable(false);
    		this.stockQuantity = 0;
    	} else {
    		this.setAvailable(true);
    	}
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
