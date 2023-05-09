package au.org.ala.names.issues;

import au.org.ala.names.model.*;
import au.org.ala.names.search.HomonymException;
import au.org.ala.names.search.MisappliedException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Issue161to80Test extends AbstractIssueTest {
    // Test for issue 61
    // Philomachus pugnax is a synonym of Calidris pugnax
    @Test
    public void testIssue61() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Philomachus pugnax");
        this.reportResult("61a", result);
        assertNotNull(result);
        assertEquals("NZOR-6-59078", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Calidris pugnax");
        this.reportResult("61b", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/177fbe63-4e52-4dd1-9f05-cf64ab8c48c8", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());


        result = searcher.searchForRecord("Tringa pugnax");
        this.reportResult("61c", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/eabb284d-2d15-4ce3-b295-61787b3c72a4", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/177fbe63-4e52-4dd1-9f05-cf64ab8c48c8", result.getAcceptedLsid());
    }

    // Test for issue 62
    // Tympanocryptis pinguicolla split
    @Test
    public void testIssue62() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Tympanocryptis pinguicolla");
        this.reportResult("62a", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/6d07b827-6e19-4c67-adc5-f9ec123cc905", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Tympanocryptis condaminensis");
        this.reportResult("62b", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/4a561829-9930-4541-a402-bf51d00b831b", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Tympanocryptis wilsoni");
        this.reportResult("61c", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/6ba12889-0ada-46b0-a48e-37c234ccee55", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Tympanocryptis lineata");
        this.reportResult("61d", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/b4be2ab2-8076-4b79-8059-4aac068538f1", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Tympanocryptis osbornei");
        this.reportResult("61e", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/b94c2226-bffb-44aa-87f0-f01f11435677", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Tympanocryptis mccartneyi");
        this.reportResult("61f", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/6dcc8e1c-6421-4f50-9bd3-d92475909489", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 63
    // Leucoptera (Lepidoptera) vs Leucoptera (Asteraceae)
    // BIE/EoL issue
    @Ignore
    public void testIssue63() throws Exception {
    }

    // Test for issue 64
    // Names matching does not handle botanical sections and series
    // Requires specific test
    @Ignore
    public void testIssue64() throws Exception {
    }

    // Test for issue 65
    // The plant Lotus maculatus has been matched against a spider Callevophthalmus maculatus
    @Test
    public void testIssue65() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Lotus maculatus");
        this.reportResult("65a", result);
        assertNull(result);

        result = searcher.searchForRecord("Lotus maculatus", null, true);
        this.reportResult("65b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51436215", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        assertEquals(MatchType.RECURSIVE, result.getMatchType());
    }


    // Test for issue 66
    // Ptilotus exaltatus incorrectly displaying as Ptilotus nobilis
    @Test
    public void testIssue66() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Ptilotus exaltatus");
        this.reportResult("66a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51430680", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Ptilotus nobilis");
        this.reportResult("66b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51430713", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 67
    // ALA showing Bossiaea ornata (Lindl.) Benth as the preferred name for Bossiaea lalagoides F.Muell
    @Test
    public void testIssue67() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Bossiaea lalagoides");
        this.reportResult("67a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51702970", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Bossiaea ornata");
        this.reportResult("67b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51702959", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 68
    // Missing names in Drosera
    @Test
    public void testIssue68() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Drosera sp. Yampi Peninsula (A.J.M. Hopkins BA 0248)");
        this.reportResult("68a", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_1295", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Drosera sp. Kentdale (G.J. Bourke 458)");
        this.reportResult("68b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680139", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Drosera sp. Lesueur National Park (C.A. Gardner 9350)");
        this.reportResult("68c", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680144", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 69
    // Names matching Grevillea (plant, misspelling) to Grevillia (beetle genus)
    @Test
    public void testIssue69() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Grevillea striata");
        this.reportResult("69a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2911702", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Grevillia striata");
        result = searcher.searchForRecord(cl, true, false, true);
        this.reportResult("69b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2911702", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 70
    // Mismatch of taxon with species page information: Acanthocephala (worms) with Acanthocephala (hemiptera)
    // BIE/EoL issue
    @Ignore
    public void testIssue70() throws Exception {
    }

    // Pseudomys pilligaensis synonym check
    @Test
    public void testIssuePseudomyspilligaensi() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Pseudomys pilligaensis");
        this.reportResult("Pp", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/f526474e-e026-41bf-8532-766deaf58848", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/a6a91fbd-77f4-4440-ba66-7d043f27a297", result.getAcceptedLsid());
    }
}