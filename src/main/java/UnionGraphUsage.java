import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

public class UnionGraphUsage {
    private void createUnionModel() {
        Model referred = RDFDataMgr.loadModel("referred.ttl");

        Reasoner reasoner = new GenericRuleReasoner(Rule.rulesFromURL("align.sse"));
        Model aligned = ModelFactory.createDefaultModel();
        Model union = ModelFactory.createUnion(aligned, referred);
        InfModel infModel = ModelFactory.createInfModel(reasoner, union);

        RDFDataMgr.read(infModel, "new_triples.ttl");

        printModel(referred, "referred");
        printModel(aligned, "aligned");
        printModel(union, "union");
        printModel(infModel, "inference");
    }

    private void printModel(Model model, String description) {
        System.out.println(" >>>>>>>>>>>>>>>>>>>>> " + description);
        RDFDataMgr.write(System.out, model, Lang.N3);
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        new UnionGraphUsage().createUnionModel();
    }
}
