package au.org.ala.names.issues;

import au.org.ala.names.model.NameSearchResult;
import au.org.ala.names.search.ALANameSearcher;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
