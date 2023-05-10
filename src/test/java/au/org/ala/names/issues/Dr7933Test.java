package au.org.ala.names.issues;

import au.org.ala.names.model.*;
import au.org.ala.names.search.HomonymException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the ALA-introduced taxa.
 */
public class Dr7933Test extends AbstractIssueTest {
    // Test for Proboscidea
    // Expect elephants to not mastch
    @Test
    public void testProboscidea() throws Exception {
        MetricsResultDTO metrics;
        NameSearchResult result;
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Loxodonta africana");
        cl.setGenus("Loxodonta");
        cl.setFamily("Elephantidae");
        cl.setOrder("Proboscidea");
        cl.setKlass("Mammalia");
        cl.setPhylum("Chordata");
        cl.setKingdom("Animalia");
        metrics = searcher.searchForRecordMetrics(cl, true, true);
        result = metrics.getResult();
        this.reportResult("Proboscidea", result);
        assertNotNull(result);
        assertEquals("ALA_DR7933_1", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        assertTrue(metrics.getErrors().contains(ErrorType.EXCLUDED));
    }

    // Test for Myrina
    @Test
    public void testMyrina() throws Exception {
        MetricsResultDTO metrics;
        NameSearchResult result;
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Myrina");
        metrics = searcher.searchForRecordMetrics(cl, true, true);
        result = metrics.getResult();
        this.reportResult("Myrina", result);
        assertNotNull(result);
        assertEquals("ALA_DR7933_2", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
        assertTrue(metrics.getErrors().contains(ErrorType.EXCLUDED));
    }

    // Test for Cracticus tibicen
    // Missing species-level synonym
    @Test
    public void testCracticusTibicen() throws Exception {
        MetricsResultDTO metrics;
        NameSearchResult result;
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Cracticus tibicen");
        metrics = searcher.searchForRecordMetrics(cl, true, true);
        result = metrics.getResult();
        this.reportResult("Cracticus tibicen", result);
        assertNotNull(result);
        assertEquals("ALA_DR7933_3", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/5291343e-fdeb-4a65-8ba5-928f5b96acf5", result.getAcceptedLsid());
    }

    // Test for Tephrosia sp. Bungaroo Ck (M.E.Trudgen 11601)
    // Orthographic variant
    @Test
    public void testTephrosiaSp() throws Exception {
        MetricsResultDTO metrics;
        NameSearchResult result;
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Tephrosia sp. Bungaroo Ck (M.E.Trudgen 11601)");
        metrics = searcher.searchForRecordMetrics(cl, true, true);
        result = metrics.getResult();
        this.reportResult("Tephrosia sp.", result);
        assertNotNull(result);
        assertEquals("ALA_DR7933_4", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/node/apni/2887630", result.getAcceptedLsid());
    }

    // Test for Megalurus gramineus
    //Missing species-level synonym
    @Test
    public void testMegalurusGramineus() throws Exception {
        MetricsResultDTO metrics;
        NameSearchResult result;
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Megalurus gramineus");
        metrics = searcher.searchForRecordMetrics(cl, true, true);
        result = metrics.getResult();
        this.reportResult("Megalurus gramineus", result);
        assertNotNull(result);
        assertEquals("ALA_DR7933_5", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/b4c2ec8d-918d-4fb4-8ef9-f6d5d3bbceda", result.getAcceptedLsid());
    }


    // Test for Calyptorhynchus funereu
    // Synonym for Zanda funera that appears in several conservation lists
    @Test
    public void testCalyptorhynchusFunereus() throws Exception {
        MetricsResultDTO metrics;
        NameSearchResult result;
        LinnaeanRankClassification cl = new LinnaeanRankClassification();
        cl.setScientificName("Calyptorhynchus funereus");
        metrics = searcher.searchForRecordMetrics(cl, true, true);
        result = metrics.getResult();
        this.reportResult("Calyptorhynchus funereus", result);
        assertNotNull(result);
        assertEquals("ALA_DR7933_6", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/145b081d-eca7-4d9b-9171-b97e2d061536", result.getAcceptedLsid());
    }

}