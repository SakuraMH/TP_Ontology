package ma.enset.sma;
import jade.content.AgentAction;
import jade.core.AID;

public class Sell implements AgentAction {
    private AID buyer;
    private Product product;

    public Sell() {
    }

    public AID getBuyer() {
        return this.buyer;
    }

    public void setBuyer(AID buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
