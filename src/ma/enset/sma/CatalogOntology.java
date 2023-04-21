package ma.enset.sma;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;

public class CatalogOntology extends Ontology implements CatalogVocabolary {
    public static final String ONTOLOGY_NAME = "Catalog-Ontology";
    public static final Ontology CATALOG_ONTOLOGY = new CatalogOntology();

    public static Ontology getCatalogOntology() {
        return CATALOG_ONTOLOGY;
    }

    private CatalogOntology() {
        super("Catalog-Ontology",BasicOntology.getInstance());//getCatalogOntology());

        try {
            this.add(new ConceptSchema("Product"), Product.class);
            this.add(new ConceptSchema("Computer"), Computer.class);
            this.add(new ConceptSchema("Usb"), Usb.class);
            this.add(new AgentActionSchema("Sell"), Sell.class);
            this.add(new PredicateSchema("Disponible"), Disponible.class);
            ConceptSchema cs = (ConceptSchema)this.getSchema("Product");
            cs.add("name", (PrimitiveSchema)this.getSchema("BO_String"), 1);
            cs.add("price", (PrimitiveSchema)this.getSchema("BO_Float"), 1);
            cs = (ConceptSchema)this.getSchema("Computer");
            cs.addSuperSchema((ConceptSchema)this.getSchema("Product"));
            cs.add("ram", (PrimitiveSchema)this.getSchema("BO_Float"), 1);
            cs.add("disk", (PrimitiveSchema)this.getSchema("BO_Float"), 1);
            cs.add("processors", (PrimitiveSchema)this.getSchema("BO_Integer"), 1);
            cs = (ConceptSchema)this.getSchema("Usb");
            cs.addSuperSchema((ConceptSchema)this.getSchema("Product"));
            cs.add("capacity", (PrimitiveSchema)this.getSchema("BO_Float"));
            PredicateSchema ds = (PredicateSchema)this.getSchema("Disponible");
            ds.add("product", this.getSchema("Product"));
            ds.add("seller", this.getSchema("agent-identifier"));
            AgentActionSchema ss = (AgentActionSchema)this.getSchema("Sell");
            ss.add("product", (ConceptSchema)this.getSchema("Product"));
            ss.add("buyer", (ConceptSchema)this.getSchema("agent-identifier"));
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
