package au.org.ala.names.issues;

import au.org.ala.names.model.LinnaeanRankClassification;
import au.org.ala.names.model.NameSearchResult;
import au.org.ala.names.search.HomonymException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Issue1to20Test extends AbstractIssueTest {
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

    // Test for issue 11
    // Flag non-authoratative
    @Ignore
    public void testIssue11() throws Exception {
    }


    // Test for issue 12
    // Blechnum rupestre (Kaulf. ex Link) Christenh. x Blechnum medium (R.Br.) Christenh. returns error
    @Test
    public void testIssue12() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Blechnum rupestre (Kaulf. ex Link) Christenh. x Blechnum medium (R.Br.) Christenh.");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51405246", result.getLsid());
    }


    // Test for issue 13
    // Pomaderris phylicifolia subsp. ericoides
    @Test
    public void testIssue13() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Pomaderris phylicifolia subsp. ericoides");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2899680", result.getLsid());
    }

    // Test for issue 14
    // How to look up species
    @Ignore
    public void testIssue14() throws Exception {
    }

    // Test for issue 15
    // Thinornis rubricollis to be made synonym of Thinornis cucullatus (Vieillot, 1818)
    @Test
    public void testIssue15() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Thinornis rubricollis");
        assertNotNull(result);
        assertEquals("ALA_DR7933_?", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/1ebf8ec6-9aee-4b58-8789-0be73eb97b2f", result.getAcceptedLsid());

        result = searcher.searchForRecord("Thinornis rubricollis rubricollis");
        assertNotNull(result);
        assertEquals("ALA_DR7933_?", result.getLsid());
        assertEquals("https://biodiversity.org.au/afd/taxa/1ebf8ec6-9aee-4b58-8789-0be73eb97b2f", result.getAcceptedLsid());
    }


    // Test for issue 16
    // Pterostylis cucullata ssp. sylvicola, P. cucullata ssp. cucullata synonyms of P. cucullata
    @Test
    public void testIssue16() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Pterostylis cucullata subsp. sylvicola");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51411222", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51412090", result.getAcceptedLsid());


        result = searcher.searchForRecord("Pterostylis cucullata subsp. cucullata");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51411219", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51412090", result.getAcceptedLsid());

        result = searcher.searchForRecord("Pterostylis cucullata ssp. cucullata");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51411219", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51412090", result.getAcceptedLsid());

        result = searcher.searchForRecord("Pterostylis cucullata ssp. sylvicola");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51411222", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51412090", result.getAcceptedLsid());
    }


    // Test for issue 17
    // Prasophyllum parvicallum, Genoplesium parvicallum need to be synonyms of Corunastylis parvicalla
    @Test
    public void testIssue17() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Prasophyllum parvicallum");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51423009", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441297", result.getAcceptedLsid());


        result = searcher.searchForRecord("Genoplesium parvicallum");
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51423010", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441297", result.getAcceptedLsid());
    }


    // Test for issue 18
    // PHA list unmatched names
    @Ignore
    public void testIssue18() throws Exception {
    }

    // Test for issue 19
    // Petrogale lateralis subsp. (WAM M15135)
    @Ignore
    public void testIssue19() throws Exception {
    }


    // Test for issue 20
    // Petrogale lateralis subsp. (ANWC CM15314)
    @Ignore
    public void testIssue20() throws Exception {
    }


}
