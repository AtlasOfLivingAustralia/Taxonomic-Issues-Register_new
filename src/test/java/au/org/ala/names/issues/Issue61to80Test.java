package au.org.ala.names.issues;

import au.org.ala.names.model.*;
import au.org.ala.names.search.HomonymException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Issue61to80Test extends AbstractIssueTest {
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

    // Test for issue 71
    // Errors in sensitivity status - Darwinia and Eutaxia
    // SDS issue
    @Ignore
    public void testIssue71() throws Exception {
    }

    // Test for issue 72
    // Phrase name for listed species Arthrostylis sp. Kalumburu (K.L. Wilson 10101) PN missing from ALA
    @Test
    public void testIssue72() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Arthrostylis sp. Kalumburu (K.L. Wilson 10101)");
        this.reportResult("72", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_433", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 73
    // Incorrect listed species synonym in ALA - Acacia karina/karinae
    @Test
    public void testIssue73() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Acacia karina");
        this.reportResult("73a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2906348", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Acacia karinae");
        this.reportResult("73b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680367", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 74
    // Revision of Genus Balaustion Hook. (including listed species)
    // Require examples of listed species
    @Ignore
    public void testIssue74() throws Exception {
    }


    // Test for issue 75
    // Review of Austrostipa missing from ALA including threatened species
    @Test
    public void testIssue75() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Austrostipa burgesiana");
        this.reportResult("75a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51679893", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Austrostipa everettiana");
        this.reportResult("75b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51679722", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Austrostipa frankliniae");
        this.reportResult("75c", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680089", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Austrostipa heteranthera");
        this.reportResult("75d", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51679759", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Austrostipa koordana");
        this.reportResult("75e", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51679731", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Austrostipa nunaginensis");
        this.reportResult("75f", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680096", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Austrostipa turbinata");
        this.reportResult("75g", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51679736", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 76
    // PMissing phrase name threatened species Calandrinia sp. Bayswater (C. Andrews s.n. 11/1902) PN
    @Test
    public void testIssue76() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Calandrinia sp. Bayswater (C. Andrews s.n. 11/1902)");
        this.reportResult("76a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51725133", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        try {
            result = searcher.searchForRecord("Calandrinia sp. Hamelin Station (F. Obbens FO 02/20)");
            fail("Expecting homonym");
        } catch (HomonymException ex) {
            assertEquals(2, ex.getResults().size());
            result =  ex.getResults().get(0);
            this.reportResult("76b-0", result);
            assertEquals("https://id.biodiversity.org.au/name/apni/51680119", result.getLsid());
            result =  ex.getResults().get(1);
            this.reportResult("76b-1", result);
            assertEquals("https://id.biodiversity.org.au/name/apni/51680122", result.getLsid());
        }

        result = searcher.searchForRecord("Calandrinia sp. Lennard River (W.V. Fitzgerald 739)");
        this.reportResult("76c", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51691509", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Calandrinia sp. Mt Vernon Station (T.L. Setter 427)");
        this.reportResult("76d", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_823", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 77
    // Species described in Calytrix missing from ALA
    @Test
    public void testIssue77() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Calytrix calingiri");
        this.reportResult("77a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694225", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Calytrix sp. Learmonth (S. Fox EMopp 1)");
        this.reportResult("77b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51462053", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Calytrix sp. Wandana (G. Byrne 1750)");
        this.reportResult("77c", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_895", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 78
    // Threatened species missing from ALA Convolvulus pyrophilus
    @Test
    public void testIssue78() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Convolvulus pyrophilus");
        this.reportResult("78", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631139", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 79
    // Threatened species missing from ALA Dielsiodoxa altimontana
    @Test
    public void testIssue79() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Dielsiodoxa altimontana");
        this.reportResult("79", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694038", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }

    // Test for issue 80
    // New species (2020) missing from ALA Dolichocarpa sp. Hamersley Station (A.A. Mitchell PRP 1479) PN
    @Test
    public void testIssue80() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Dolichocarpa sp. Hamersley Station (A.A. Mitchell PRP 1479)");
        this.reportResult("80", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51417735", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
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