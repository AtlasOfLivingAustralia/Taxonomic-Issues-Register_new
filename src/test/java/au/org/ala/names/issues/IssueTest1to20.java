package au.org.ala.names.issues;

import au.org.ala.names.model.LinnaeanRankClassification;
import au.org.ala.names.model.NameSearchResult;
import au.org.ala.names.search.ALANameSearcher;
import au.org.ala.names.search.HomonymException;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IssueTest1to20 {
    private static ALANameSearcher searcher;

    @BeforeClass
    public static void init() throws Exception {
        searcher = new ALANameSearcher("/data/lucene/namematching-20230329-1");
    }

    // Test for issue 1
    // Not required, as a query over identifier conventions
    @Ignore
    public void testIssue1() throws Exception {
    }

    // Test for issue 2
    // ALA is not correctly representing APC taxonomy in Eriochilus
    @Test
    public void testIssue2() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Eriochilus dilatatus subsp. undulatus");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441698", result.getLsid());

        result = searcher.searchForRecord("Eriochilus sp. Roleystone (G. Brockman 1140)");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441703", result.getLsid());

        result = searcher.searchForRecord("Eriochilus glareosus");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694057", result.getLsid());

        result = searcher.searchForRecord("Eriochilus dilatatus subsp. brevifolius");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51405074", result.getLsid());
    }

    // Test for issue 3
    // Goodenia pritzelii should be matched
    @Test
    public void testIssue3() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Goodenia pritzelii");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51437035", result.getLsid());
    }

    // Test for issue 1
    // Requires changes to the list format and pipelines code
    @Ignore
    public void testIssue4() throws Exception {
    }


    // Test for issue 5
    // Acacia lasiocarpa var. lasiocarpa Cockleshell Gully variant (E.A. Griffin 2039) should be matched
    @Test
    public void testIssue5() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Acacia lasiocarpa var. lasiocarpa Cockleshell Gully variant (E.A. Griffin 2039)");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2911917", result.getLsid());
    }

    // Test for issue 6
    // Lindernia eremophiloides incorrectly showing as a synonym of Vandellia eremophiloides
    @Test
    public void testIssue6() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Lindernia eremophiloides");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51438554", result.getLsid());

        result = searcher.searchForRecord("Vandellia eremophiloides");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51302407", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51438554", result.getAcceptedLsid());
    }


    // Test for issue 7
    // Lindernia macrosiphonia incorrectly showing as a synonym of Vandella eremophiloides
    @Test
    public void testIssue7() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Lindernia macrosiphonia");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51438578", result.getLsid());
    }


    // Test for issue 8
    // Lomandra acicularis incorrectly referred to Lomandra sp. Kimberley (M.D.Barrett 1036)
    @Test
    public void testIssue8() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Lomandra acicularis");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51439083", result.getLsid());

        result = searcher.searchForRecord("Lomandra acicularis M.D.Barrett MS");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51439077", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51439083", result.getAcceptedLsid());

        result = searcher.searchForRecord("Lomandra acicularis ms M.D.Barrett");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51439077", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51439083", result.getAcceptedLsid());

        result = searcher.searchForRecord("Lomandra sp. Kimberley (M.D.Barrett 1036)");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51439078", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51439083", result.getAcceptedLsid());
    }


    // Test for issue 9
    // Multiple entries of Thalassarche chlororhynchos
    @Test
    public void testIssue9() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Thalassarche chlororhynchos");
        assertNotNull(result);
        assertEquals("NZOR-6-102565", result.getLsid());
    }

    // Test for issue 10
    // Taxon names matching to wrong Kingdom
    @Test
    public void testIssue10() throws Exception {
        // No longer present
        NameSearchResult result = searcher.searchForRecord("Mitrella dictua");
        assertNull(result);

        try {
            result = searcher.searchForRecord("Ficus");
            fail("Expecting homonym exception");
        } catch (HomonymException ex) {
        }

        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Ficus");
        cl.setKingdom("Plantae");
        result = searcher.searchForRecord(cl, false);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51439476", result.getLsid());

        cl.setKingdom("Animalia");
        result = searcher.searchForRecord(cl, false);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/3b379a3e-4407-4a4f-988d-f1b49e7d98e0", result.getLsid());

    }

}
