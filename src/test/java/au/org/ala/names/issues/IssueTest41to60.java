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

public class IssueTest41to60 extends AbstractIssueTest {
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

    // Test for issue 51
    // Acanthaster solaris attributed to genus - synonym of Acanthaster planci
    @Test
    public void testIssue51() throws Exception {
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Acanthaster solaris");
        MetricsResultDTO metrics = searcher.searchForRecordMetrics(cl, true, true);
        assertNotNull(metrics.getResult());
        assertEquals("https://biodiversity.org.au/afd/taxa/cdbfad4a-50c8-40e7-b323-f12573eb8d5d", metrics.getResult().getLsid());
        assertEquals(MatchType.RECURSIVE, metrics.getResult().getMatchType());
    }

    // Test for issue 52
    // Error in Synonomy in Corbicula
    @Test
    public void testIssue52() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Corbicula maroubra");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/a7b519c2-f77d-4409-ba55-a39d8f85c688", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/67d61422-5628-483a-8cc4-37f0b602e5df", result.getAcceptedLsid());
    }

    // Issue 53 deleted
    @Ignore
    public void testIssue53() throws Exception {
    }

    // Test for issue 54
    // Glyptophysa (Glyptophysa) gibbosa (Gould, 1846) is a junior synonym and names matching incorrectly to family
    @Test
    public void testIssue54a() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Glyptophysa gibbosa");
        assertNull(result);
    }

    // Test for issue 54
    // Glyptophysa (Glyptophysa) gibbosa (Gould, 1846) is a junior synonym and names matching incorrectly to family
    @Test
    public void testIssue54b() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Glyptophysa novaehollandica");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/3eac177e-0794-4194-820d-1295bd0411bb", result.getLsid());
        assertNull(result.getAcceptedLsid());

        // Missing d
        result = searcher.searchForRecord("Physa novaehollanica");
        assertNull(result);

        result = searcher.searchForRecord("Physa novaehollanica", RankType.SPECIES, true);
        assertNull(result);

        result = searcher.searchForRecord("Physa novaehollandica");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/aa70fbae-93e8-4134-9cd6-edf250c62cdf", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/3eac177e-0794-4194-820d-1295bd0411bb", result.getAcceptedLsid());
    }


    // Test for issue 55
    // Multiple entries of Thalassarche eremita in taxonomic tree
    @Test
    public void testIssue55() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Thalassarche eremita");
        assertNotNull(result);
        assertEquals("NZOR-6-106266", result.getLsid());
        assertNull(result.getAcceptedLsid());
    }


    // Test for issue 56
    // EPBC listed Acanthiza lineata whitei incorrectly synonomised with Acanthiza lineata alberti
    @Test
    public void testIssue56() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Acanthiza lineata whitei");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/100c3467-3b6e-45be-a2d6-1a3f2250a88b", result.getLsid());
        assertNull(result.getAcceptedLsid());

        result = searcher.searchForRecord("Acanthiza lineata alberti");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/06316e09-60d8-4ad5-bea3-e822d3fe52de", result.getLsid());
        assertNull(result.getAcceptedLsid());
    }

    // Test for issue 57
    // Acanthiza (Acanthiza) pusilla magnirostris duplicated with Acanthiza pusilla archibaldi Mathews
    @Test
    public void testIssue57() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Acanthiza pusilla magnirostris");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/fe7de157-e9c1-4672-be08-71b411847570", result.getLsid());
        assertNull(result.getAcceptedLsid());

        result = searcher.searchForRecord("Acanthiza pusilla archibaldi");
        assertNotNull(result);
        assertEquals("ALA_DR654_614", result.getLsid());
        assertNull(result.getAcceptedLsid());
    }


    // Test for issue 58
    // Multiple versions of Thalassarche bulleri platei
    @Test
    public void testIssue58() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Thalassarche bulleri platei");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/c6d51093-2855-44d1-a72b-b612305c7bd3", result.getLsid());
        assertNull(result.getAcceptedLsid());
    }


    // Test for issue 59
    // Multiple versions of Tyto novaehollandiae castanops
    @Test
    public void testIssue59() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Tyto novaehollandiae castanops");
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/2c30d58b-572b-4dab-8644-b222c28eb0ec", result.getLsid());
        assertNull(result.getAcceptedLsid());
    }


    // Test for issue 60
    // Calyptorhynchus latirostris incorrectly attached to family Cacatuidae instead of Zanda latrirostris
    @Test
    public void testIssue60() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Calyptorhynchus latirostris");
        assertNotNull(result);
        assertEquals("ALA_DR2201_3924", result.getLsid());
        assertNull(result.getAcceptedLsid());
        assertEquals("Calyptorhynchus", result.getRankClassification().getGenus());
    }

}
