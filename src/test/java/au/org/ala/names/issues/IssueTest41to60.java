package au.org.ala.names.issues;

import au.org.ala.names.model.*;
import au.org.ala.names.search.ALANameSearcher;
import au.org.ala.names.search.ExcludedNameException;
import au.org.ala.names.search.HomonymException;
import au.org.ala.names.search.MisappliedException;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IssueTest41to60 {
    private static ALANameSearcher searcher;

    @BeforeClass
    public static void init() throws Exception {
        searcher = new ALANameSearcher("/data/lucene/namematching-20230329-1");
    }

    // Test for issue 41
    // Calyptorhynchus lathami lathami duplicates
    @Test
    public void testIssue41() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Calyptorhynchus lathami lathami");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/a7578d10-e7ae-48c2-9deb-bab619125a6c", result.getLsid());
    }

    // Test for issue 42
    // Duplicate entries of Calyptorhynchus lathami halmaturinus
    @Test
    public void testIssue42() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Calyptorhynchus lathami halmaturinus");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/3ea16688-8600-4d08-a362-1d5bd33af2aa", result.getLsid());
    }


    // Test for issue 43
    // Caladenia vulgaris var. nunguensis request to add to Tas Sensitive Species list
    // Caladenia vulgaris currently in species list
    @Test
    public void testIssue43() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Caladenia vulgaris");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51399454", result.getLsid());

        result = searcher.searchForRecord("Caladenia vulgaris var. nunguensis");
        assertNull(result);

        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Caladenia vulgaris var. nunguensis");
        cl.setGenus("Caladenia");
        cl.setSpecificEpithet("vulgaris");
        result = searcher.searchForRecord(cl, true);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51399454", result.getLsid());
    }


    // Test for issue 44
    // Caladenia dilatata matching to Genus
    @Test
    public void testIssue44() throws Exception {
        try {
            NameSearchResult result = searcher.searchForRecord("Caladenia dilatata");
            fail("Expecting misapplied exception");
        } catch (MisappliedException ex) {
        }
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Caladenia dilatata");
        MetricsResultDTO metrics = searcher.searchForRecordMetrics(cl, true, true);
        assertNotNull(metrics.getResult());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51398946", metrics.getResult().getLsid());
        assertTrue(metrics.getErrors().contains(ErrorType.MATCH_MISAPPLIED));
    }


    // Test for issue 45
    // Bryobium irukandjianum is listed as a synonym of Eria irukandjiana
    @Test
    public void testIssue45() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Bryobium irukandjianum");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51440902", result.getLsid());

        result = searcher.searchForRecord("Eria irukandjiana");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51427382", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51440902", result.getAcceptedLsid());
    }


    // Test for issue 46
    // Bettongia lesueur subspecies duplicated
    // See issue 4
    @Ignore
    public void testIssue46() throws Exception {
    }

    // Test for issue 47
    // Bellamya heudei guangdungensis synonym of Sinotaia heudei guangdungensis (Kobelt, 1906)
    // Bellamya heudei guangdungensis no longer present
    @Test
    public void testIssue47() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Bellamya heudei guangdungensis");
        assertNull(result);

        result = searcher.searchForRecord("Sinotaia heudei guangdungensis");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/addde9fa-4a57-4762-8bae-c717fa24ea43", result.getLsid());
    }

    // Test for issue 48
    // Anilios torresianus attributed to genus - should be attributed to Anilios polygrammicus
    @Test
    public void testIssue48() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Anilios torresianus");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/c68aa3bd-c67a-497e-bb0f-1d2c571d7f6c", result.getLsid());

        try {
            result = searcher.searchForRecord("Anilios polygrammicus");
            fail("Expecting excluded name");
        } catch (ExcludedNameException ex) {
            assertEquals("https://biodiversity.org.au/afd/taxa/44d34161-b9b5-4e54-bc4f-f6cab3db2bb3", ex.getExcludedName().getLsid());
       }
    }


    // Test for issue 49
    // Anilios sp. 'Cape Range' unranked - should be matched to Ramphotyphlops sp. Cape Range/A. splendidus
    @Test
    public void testIssue49() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Anilios sp. 'Cape Range'");
        assertNotNull(result);
        assertEquals("ALA_DR2201_3596", result.getLsid());

        result = searcher.searchForRecord("Ramphotyphlops sp. Cape Range");
        assertNull(result);

        result = searcher.searchForRecord("Anilios splendidus");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/ff9233d1-1bc3-4909-a90a-c6fc89e188d3", result.getLsid());
    }



    // Test for issue 50
    // Amytornis (Magnamytis) striatus whitei Mathews, 1910 incorrect
    @Test
    public void testIssue50() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Amytornis striatus whitei");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/6938d696-70e3-4521-b49d-b9da91740fcb", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/0ad00f36-f0e2-41b4-81b0-12f4b1211ad5", result.getAcceptedLsid());
    }
}
