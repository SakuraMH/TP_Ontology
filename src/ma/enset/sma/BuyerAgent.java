package ma.enset.sma;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BuyerAgent extends Agent {
    private Ontology catalogOntology = CatalogOntology.getCatalogOntology();
    private Codec codec = new SLCodec();

    public BuyerAgent() {
    }

    protected void setup() {
        this.getContentManager().registerOntology(this.catalogOntology);
        this.getContentManager().registerLanguage(this.codec);
        MessageTemplate messageTemplate = MessageTemplate.and(MessageTemplate.MatchOntology("Catalog-Ontology"), MessageTemplate.MatchLanguage(this.codec.getName()));
        ACLMessage receivedMessage = this.blockingReceive(messageTemplate);

        try {
            Disponible disponible = (Disponible)this.getContentManager().extractContent(receivedMessage);
            System.out.println(disponible.getProduct().getName() + disponible.getProduct().getPrice());
        } catch (Codec.CodecException var4) {
            var4.printStackTrace();
        } catch (OntologyException var5) {
            var5.printStackTrace();
        }

    }
}
