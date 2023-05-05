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

public class Issue101to120Test extends AbstractIssueTest {
    // Test for issue 101
    // Missing listed phrase name species Portulaca sp. Kununurra (M.D. Barrett MDB 5981)
    @Test
    public void testIssue101() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Portulaca sp. Kununurra (M.D. Barrett MDB 5981)");
        this.reportResult("101", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680206", result.getLsid());
    }

    // Test for issue 102
    // Missing listed phrase name species Solanum sp. W Hamersley Range (S. Colwill & B. Duncan LCR99-01)
    @Test
    public void testIssue102() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Solanum sp. W Hamersley Range (S. Colwill & B. Duncan LCR99-01)");
        this.reportResult("102", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_3183", result.getLsid());
    }

    // Test for issue 103
    // Missing listed phrase name taxa Stackhousia muricata subsp. Perennial (W.R. Barker 3641) PN and Stenanthemum sp. Eganu (S. Patrick 4537) PN
    @Test
    public void testIssue103() throws Exception {
        NameSearchResult result;

        result = searcher.searchForRecord("Stenanthemum sp. Eganu (S. Patrick 4537)");
        this.reportResult("103b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680215", result.getLsid());

        try {
            result = searcher.searchForRecord("Stackhousia muricata subsp. Perennial (W.R. Barker 3641)");
            fail("Expecting homonym exception");
        } catch (HomonymException ex) {
            fail("Homonym exception caused by bad merge");
        }

    }

    // Test for issue 104
    // Missing listed phrase name taxa Streptoglossa sp. South Coast (R.M. Hoggart 16/1113)
    @Test
    public void testIssue104() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Streptoglossa sp. South Coast (R.M. Hoggart 16/1113)");
        this.reportResult("104", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680218", result.getLsid());
    }


    // Test for issue 105
    // New listed species missing Styphelia blackallii, Styphelia carolineae, Styphelia caudata, Styphelia exarata, Styphelia graniticola, Styphelia intricata and Styphelia undulata
    @Test
    public void testIssue105() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Styphelia blackallii");
        this.reportResult("105a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694043", result.getLsid());

        result = searcher.searchForRecord("Styphelia carolineae");
        this.reportResult("105b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631427", result.getLsid());

        result = searcher.searchForRecord("Styphelia caudata");
        this.reportResult("105c", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631355", result.getLsid());

        result = searcher.searchForRecord("Styphelia exarata");
        this.reportResult("105d", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631432", result.getLsid());

        result = searcher.searchForRecord("Styphelia graniticola");
        this.reportResult("105e", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631398", result.getLsid());

        result = searcher.searchForRecord("Styphelia intricata");
        this.reportResult("105f", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631410", result.getLsid());

        result = searcher.searchForRecord("Styphelia undulata");
        this.reportResult("105g", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51424442", result.getLsid());
    }


    // Test for issue 106
    // Missing listed phrase name species Styphelia sp. Watheroo (M. Hislop 4324)
    @Test
    public void testIssue106() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Styphelia sp. Watheroo (M. Hislop 4324)");
        this.reportResult("106", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_3384", result.getLsid());
    }


    // Test for issue 107
    // New listed species (2022) Swainsona picta
    @Test
    public void testIssue107() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Swainsona picta");
        this.reportResult("107", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51687388", result.getLsid());
    }


    // Test for issue 108
    // New listed species (2022) Synostemon arenosus
    @Test
    public void testIssue108() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Synostemon arenosus");
        this.reportResult("108", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51681588", result.getLsid());
    }


    // Test for issue 109
    // Missing Listed phrase name Themeda sp. Panorama (J. Nelson et al. NS 102)
    @Test
    public void testIssue109() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Themeda sp. Panorama (J. Nelson et al. NS 102)");
        this.reportResult("109", result);
        assertNotNull(result);
        assertEquals("ALA_DR467_3537", result.getLsid());
    }

    // Test for issue 110
    // New missing listed taxa - Utricularia baliboongarnang
    @Test
    public void testIssue110() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Utricularia baliboongarnang");
        this.reportResult("110", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680807", result.getLsid());
    }

    // Test for issue 111
    // See issue 129
    @Ignore
    public void testIssue111() throws Exception {
    }

    // Test for issue 112
    // Incorrect junior synonym applied as spelling error Eriachne armittii F.Muell. ex Benth should be spelt Eriachne armitii F.Muell. ex Benth
    @Test
    public void testIssue112() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Eriachne armittii");
        this.reportResult("112", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/916406", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/node/apni/2892656", result.getAcceptedLsid());
    }

    // Test for issue 113
    // See issue 127
    @Ignore
    public void testIssue113() throws Exception {
    }


    // Test for issue 114
    // The page for Bdelloidea (a superfamily of mites) has descriptive text for Bdelloidea (a class of rotifers).
    // Fixed in BIE ansible inventories
    @Ignore
    public void testIssue114() throws Exception {
    }


    // Test for issue 115
    // Incorrect matching to genus - listed species Coprosma X tadgellii should go to Coprosma xtadgelii
    // Record from dr655 not coming through
    @Test
    public void testIssue115() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Coprosma x tadgelii");
        this.reportResult("115a", result);
        assertNotNull(result);
        assertEquals("", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/node/apni/2889042", result.getAcceptedLsid());

        result = searcher.searchForRecord("Coprosma xtadgelii");
        this.reportResult("115b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2889042", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());
    }


    // Test for issue 116
    // Corunastylis arrecta incorrectly referred to Genoplesium arrectum
    @Test
    public void testIssue116() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Corunastylis arrecta");
        this.reportResult("116a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441005", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Genoplesium arrectum");
        this.reportResult("116b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51441001", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441005", result.getAcceptedLsid());
    }

    // Test for issue 117
    // Genoplesium sp. Densum (M.A.Clements 1748) should be Corunastylis densa (Fitzg.) D.L.Jones & M.A.Clem.
    @Test
    public void testIssue117() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Genoplesium sp. Densum (M.A.Clements 1748)");
        this.reportResult("117", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51441084", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441090", result.getAcceptedLsid());
    }

    // Test for issue 118
    // Genoplesium nudum should be Corunastylis nuda (Hook.f.) D.L.Jones & M.A.Clem.
    @Test
    public void testIssue118() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Genoplesium nudum");
        this.reportResult("118", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51441281", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441290", result.getAcceptedLsid());
    }


    // Test for issue 119
    // Genoplesium pumilum is a junior synonym of Corunastylis pumila (Hook.f.) D.L.Jones & M.A.Clem.
    @Test
    public void testIssue119() throws Exception {
        NameSearchResult result;
        result = searcher.searchForRecord("Genoplesium pumilum");
        this.reportResult("119", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/instance/apni/51441311", result.getLsid());
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51441328", result.getAcceptedLsid());
    }


    // Test for issue 120
    // Galaxias Sp 14 incorrectly matches to Galaxias terenasus instead of Galaxias gunaikurnai
    // Galaxias sp. 14 is from CAAB and not longer present
    @Test
    public void testIssue120() throws Exception {
        NameSearchResult result;
        try {
            result = searcher.searchForRecord("Galaxias Sp 14");
            fail("Expecting homonym error");
        } catch (HomonymException ex) {
            assertEquals(1, ex.getResults().size());
            result =  ex.getResults().get(0);
        }
        this.reportResult("120a", result);
        assertNotNull(result);
        assertEquals("https://biodiversity.org.au/afd/taxa/cf9d20e7-5234-4ff3-94a2-23802357365f", result.getLsid());
        assertEquals(null, result.getAcceptedLsid());

        result = searcher.searchForRecord("Galaxias sp. 14");
        this.reportResult("120b", result);
        assertNull(result);

    }

}
