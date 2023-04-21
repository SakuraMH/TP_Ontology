package ma.enset.sma;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class AgentsContainer {
    public AgentsContainer() {
    }

    public static void main(String[] args) throws StaleProxyException {
        Runtime instance = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter("host", "localhost");
        AgentContainer agentContainer = instance.createAgentContainer(profile);
        AgentController agentSeller = agentContainer.createNewAgent("seller", "ma.enset.sma.SellerAgent", new Object[0]);
        AgentController agentBuyer = agentContainer.createNewAgent("buyer", "ma.enset.sma.BuyerAgent", new Object[0]);
        agentSeller.start();
        agentBuyer.start();
    }
}
