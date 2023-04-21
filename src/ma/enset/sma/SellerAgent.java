package ma.enset.sma;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class SellerAgent extends Agent {
    private Ontology catalogOntology = CatalogOntology.getCatalogOntology();
    private Codec codec = new SLCodec();

    public SellerAgent() {
    }

    protected void setup() {
        this.getContentManager().registerOntology(this.catalogOntology);
        this.getContentManager().registerLanguage(this.codec);
        Usb usb = new Usb();
        usb.setName("SAMSUNG A30");
        usb.setPrice(2500.0F);
        usb.setCapacity(39999.0F);
        Disponible disponible = new Disponible();
        disponible.setProduct(usb);
        disponible.setSeller(new AID("buyer", false));
        ACLMessage message = new ACLMessage(12);
        message.addReceiver(new AID("buyer", false));
        message.setOntology(this.catalogOntology.getName());
        message.setLanguage(this.codec.getName());

        try {
            this.getContentManager().fillContent(message, disponible);
            this.send(message);
        } catch (Codec.CodecException var5) {
            var5.printStackTrace();
        } catch (OntologyException var6) {
            var6.printStackTrace();
        }

    }
}

