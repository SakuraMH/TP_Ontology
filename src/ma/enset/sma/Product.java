package ma.enset.sma;

import jade.content.Concept;

public class Product implements Concept {
    private String name;
    private float price;

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
