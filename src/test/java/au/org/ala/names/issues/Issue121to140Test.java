package au.org.ala.names.issues;

import au.org.ala.names.model.ErrorType;
import au.org.ala.names.model.LinnaeanRankClassification;
import au.org.ala.names.model.MetricsResultDTO;
import au.org.ala.names.model.NameSearchResult;
import au.org.ala.names.search.HomonymException;
import au.org.ala.names.search.MisappliedException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Issue121to140Test extends AbstractIssueTest {
    // Test for issue 121
    // Junior synonym incorrectly shown as senior - Leichhardtia australis R.Br. Is the correct synonym of Marsdenia leichhardtiana F.Muell. nom. illeg., nom. superfl.
    @Test
    public void testIssue121() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Leichhardtia australis");
        this.reportResult("121a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51688935", result.getLsid());

        result = searcher.searchForRecord("Marsdenia leichhardtiana");
        this.reportResult("121b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51402198", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51688935", result.getAcceptedLsid());
    }

    // Test for issue 122
    // Junior nomenclatural synonym shown as senior - Machaerina laxa (Nees) T.Koyama is the correct current name for Baumea laxa (Nees) Boeckeler
    @Test
    public void testIssue122() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Machaerina laxa");
        this.reportResult("122a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51434593", result.getLsid());

        result = searcher.searchForRecord("Baumea laxa");
        this.reportResult("122b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51434588", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51434593", result.getAcceptedLsid());
    }


    // Test for issue 123
    // Species incorrectly matched - Olearia sp. 1 (Victoria) to Olearia sp. Mt Barker (R.B.Filson 829) Vic. Herbarium not Olearia gordonii
    @Test
    public void testIssue123() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Olearia sp. 1");
        this.reportResult("123a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/936703", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/node/apni/2908253", result.getAcceptedLsid());

        result = searcher.searchForRecord("Olearia sp. 1 (Victoria)");
        this.reportResult("123b", result);
        assertNull(result);
    }


    // Test for issue 124
    // Wrong species. Olearia sp. 2 is a nomenclatural synonym of Olearia sp. Mornington Peninsula (V.Stajsic 4293) Vic. Herbarium (already in ALA) not Olearia rosmarinifolia
    @Test
    public void testIssue124() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Olearia sp. 2");
        this.reportResult("124", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/937071", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/node/apni/2917814", result.getAcceptedLsid());
    }


    // Test for issue 125
    // Threatened species - localised epiphet has dropped off - the listed species is Pseudemoia pagenstecheri (High Country) not Pseudemoia pagenstecheri (which is widespread).
    // See issue 4. Conflation of location and species
    @Ignore
    public void testIssue125() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Pseudemoia pagenstecheri (High Country)");
        this.reportResult("125", result);
        assertNotNull(result);
        assertEquals("ALA_DR655_1925", result.getLsid());
    }


    // Test for issue 126
    // Wrong species - Pterostylis sp. aff. plumosa (Anglesea) and Pterostylis sp. Anglesea (V.Stajsic 355) should both match to Pterostylis unicornis (D.L.Jones) D.L.Jones
    @Test
    public void testIssue126() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Pterostylis sp. aff. plumosa (Anglesea)");
        this.reportResult("126a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51441985", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441988", result.getAcceptedLsid());

        result = searcher.searchForRecord("Pterostylis sp. Anglesea (V.Stajsic 355)");
        this.reportResult("126b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51441984", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441988", result.getAcceptedLsid());
    }


    // Test for issue 127
    // Junior synonym incorrectly shown: Pyrrholaemus sagittata (Latham, 1801) instead of Pyrrholaemus sagittatus (Latham, 1801)
    @Test
    public void testIssue127() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Pyrrholaemus sagittata");
        this.reportResult("127a", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/29ef1670-1ccf-4186-a58d-637a65596102", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/924778ad-245b-400f-a497-af8700c22674", result.getAcceptedLsid());

        result = searcher.searchForRecord("Pyrrholaemus sagittatus");
        this.reportResult("127b", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/924778ad-245b-400f-a497-af8700c22674", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 128
    // Threatened species - localised epiphet has dropped off - the listed species is Rankinia diemensis (Grampians) not Rankinia diemensis
    // See issue 4. Conflation of location and species
    @Ignore
    public void testIssue128() throws Exception {
        NameSearchResult result = searcher.searchForRecord("ankinia diemensis (Grampians)");
        this.reportResult("125", result);
        assertNotNull(result);
        assertEquals("ALA_DR655_1944", result.getLsid());
    }


    // Test for issue 129
    // Junior synonym shown instead of accepted name - Thelymitra mackibbinii F.Muell. not Thelymitra x mackibbinii
    @Test
    public void testIssue129() throws Exception {
        NameSearchResult result, misapplied;
        try {
            result = searcher.searchForRecord("Thelymitra x mackibbinii");
            misapplied = null;
            fail("Expecting misapplied exception");
        } catch (MisappliedException ex) {
            this.reportResult("129a", ex.getMatchedResult());
            this.reportResult("129x", ex.getMisappliedResult());
            result = ex.getMatchedResult();
            misapplied = ex.getMisappliedResult();
        }
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51414342", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51414340", misapplied.getLsid());
        assertEquals(null, misapplied.getAcceptedLsid());

        try {
            result = searcher.searchForRecord("Thelymitra mackibbinii");
            misapplied = null;
            fail("Expecting misapplied exception");
        } catch (MisappliedException ex) {
            this.reportResult("129b", ex.getMatchedResult());
            this.reportResult("129y", ex.getMisappliedResult());
            result = ex.getMatchedResult();
            misapplied = ex.getMisappliedResult();
        }
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51414342", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51414340", misapplied.getLsid());
        assertEquals(null, misapplied.getAcceptedLsid());
    }


    // Test for issue 130
    // Hydrochus genus appearing within family Hydophilidae - should be in Family Hydrochidae
    @Test
    public void testIssue130() throws Exception {
        NameSearchResult result;

        try {
            result = searcher.searchForRecord("Hydrochus");
        } catch (HomonymException ex) {
        }
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Hydrochus");
        cl.setOrder("Coleoptera");
        MetricsResultDTO metrics = searcher.searchForRecordMetrics(cl, false);
        assertTrue(metrics.getErrors().contains(ErrorType.NONE));
        this.reportResult("130", metrics.getResult());
        assertNotNull(metrics.getResult());
        assertEquals("https://biodiversity.org.au/afd/taxa/c0c6bb3c-d92a-48b1-8911-95becfecba7a", metrics.getResult().getLsid());
        assertEquals("Hydrochidae", metrics.getResult().getRankClassification().getFamily());
    }


    // Test for issue 130
    // Hydrochus genus appearing within family Hydophilidae - should be in Family Hydrochidae
    @Test
    public void testIssue131() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Lepus capensis");
        this.reportResult("131a", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/6240deca-2f4f-4bcd-a944-c49df0ae83b5", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        result = searcher.searchForRecord("Lepus europaeus");
        this.reportResult("131b", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/c14a6934-5603-4bdd-aef8-ccb48df8bd8e", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/6240deca-2f4f-4bcd-a944-c49df0ae83b5", result.getAcceptedLsid());
        result = searcher.searchForRecord("Lepus capensis occidentalis");
        this.reportResult("131c", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/c521424d-2add-47a9-98b2-a4de4affe739", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        result = searcher.searchForRecord("Lepus europaeus occidentalis");
        this.reportResult("131d", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/ab2ce457-c400-44e2-86cf-108d10f425d7", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/c521424d-2add-47a9-98b2-a4de4affe739", result.getAcceptedLsid());
    }

}