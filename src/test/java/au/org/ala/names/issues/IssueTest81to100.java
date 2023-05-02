package au.org.ala.names.issues;

import au.org.ala.names.model.*;
import au.org.ala.names.search.ALANameSearcher;
import au.org.ala.names.search.ExcludedNameException;
import au.org.ala.names.search.MisappliedException;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IssueTest81to100 extends AbstractIssueTest {
    // Test for issue 81
    // New species in Drummondita missing from ALA
    @Test
    public void testIssue81() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Drummondita billyacatting");
        this.reportResult("81a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51679444", result.getLsid());

        result = searcher.searchForRecord("Drummondita rubriviridis");
        this.reportResult("81b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2888760", result.getLsid());
    }


    // Test for issue 82
    // Eragrostis sp. Lake Carey (J. Paterson & J. Warden WB 40825) PN
    // Name not found in sources
    @Ignore
    public void testIssue82() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Eragrostis sp. Lake Carey (J. Paterson & J. Warden WB 40825)");
        this.reportResult("82", result);
        assertNotNull(result);
        assertEquals("", result.getLsid());
    }


    // Test for issue 83
    // New threatened species not in ALA Eriochilus glareosus
    @Test
    public void testIssue83() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Eriochilus glareosus");
        this.reportResult("83", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694057", result.getLsid());
    }

    // Test for issue 84
    // Eucalyptus efflorescens
    @Test
    public void testIssue84() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Eucalyptus efflorescens");
        this.reportResult("84", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51632977", result.getLsid());
    }


    // Test for issue 85
    // Eucalyptus merleae
    @Test
    public void testIssue85() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Eucalyptus merleae");
        this.reportResult("85", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51631057", result.getLsid());
    }


    // Test for issue 86
    // Eucalyptus merleae
    @Test
    public void testIssue86() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Euploca alcyonium");
        this.reportResult("86", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51351288", result.getLsid());
    }


    // Test for issue 87
    // Fitzwillia sp. Newdegate (A. Coates 8766) PN and Gastrolobium sp. Asperum (F. Hort 2864) PN
    @Test
    public void testIssue87() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Fitzwillia sp. Newdegate (A. Coates 8766)");
        this.reportResult("87a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680154", result.getLsid());

        result = searcher.searchForRecord("Gastrolobium sp. Asperum (F. Hort 2864)");
        this.reportResult("87b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680751", result.getLsid());
    }



    // Test for issue 88
    // Spelling error Glycine lactivirens/lactovirens
    // Requires synonym
    @Test
    public void testIssue88() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Glycine lactivirens");
        this.reportResult("88a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/node/apni/2910461", result.getLsid());

        result = searcher.searchForRecord("Glycine lactovirens");
        this.reportResult("88b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51417635", result.getLsid());
    }


    // Test for issue 89
    // Gomphrena axillaris
    @Test
    public void testIssue89() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Gomphrena axillaris");
        this.reportResult("89", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51421947", result.getLsid());
    }


    // Test for issue 90
    // Goodenia sp. Charnley River (M.D. Barrett MDB 5163)
    @Test
    public void testIssue90() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Goodenia sp. Charnley River (M.D. Barrett MDB 5163)");
        this.reportResult("90", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680167", result.getLsid());
    }


    // Test for issue 91
    // Hibiscus sp. Kununurra (K.F. Kenneally 1940)
    @Test
    public void testIssue91() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Hibiscus sp. Kununurra (K.F. Kenneally 1940)");
        this.reportResult("91", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680176", result.getLsid());
    }

    // Test for issue 92
    // Hypocalymma inopinatum, Hypocalymma polyandrum
    @Test
    public void testIssue92() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Hypocalymma inopinatum");
        this.reportResult("92a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694142", result.getLsid());

        result = searcher.searchForRecord("Hypocalymma polyandrum");
        this.reportResult("92b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51694161", result.getLsid());
    }


    // Test for issue 93
    // Indigofera rivularis, Indigofera rotula
    @Test
    public void testIssue93() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Indigofera rivularis");
        this.reportResult("93a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51418227", result.getLsid());

        result = searcher.searchForRecord("Indigofera rotula");
        this.reportResult("93b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51418232", result.getLsid());
    }


    // Test for issue 94
    // Lambertia orbifolia subsp. Bowelling (A. Webb AW 09107)
    // Not found in sources
    @Ignore
    public void testIssue94() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Lambertia orbifolia subsp. Bowelling (A. Webb AW 09107)");
        this.reportResult("94", result);
        assertNotNull(result);
        assertEquals("", result.getLsid());
    }


    // Test for issue 95
    // New taxon incorrectly referred to wrong genus Lemphoria humistrata
    @Test
    public void testIssue95() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Lemphoria humistrata");
        this.reportResult("95", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51695843", result.getLsid());
        assertEquals("Lemphoria", result.getRankClassification().getGenus());
    }


    // Test for issue 96
    // Lindernia sp. Minute-flowered (A.S. George 12433)
    @Test
    public void testIssue96() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Lindernia sp. Minute-flowered (A.S. George 12433)");
        this.reportResult("96", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51438628", result.getLsid());
    }

    // Test for issue 97
    // Microcorys sp. Great Victoria Desert (J. Alford s.n. PERTH 09041567)
    // Not in sources
    @Ignore
    public void testIssue97a() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Microcorys sp. Great Victoria Desert (J. Alford s.n. PERTH 09041567)");
        this.reportResult("97a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51438628", result.getLsid());
    }


    // Test for issue 97
    // Microcorys sp. Great Victoria Desert (J. Alford s.n. PERTH 09041567) PN, Microcorys sp. Mt Holland broad-leaf (G. Barrett s.n. PERTH 04104927) and Microcorys sp. Parker Range (C. Hancock s.n. PERTH 09215123)
    @Test
    public void testIssue97b() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Microcorys sp. Mt Holland broad-leaf (G. Barrett s.n. PERTH 04104927)");
        this.reportResult("97b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51347847", result.getLsid());

        // Fails - not in sources
        result = searcher.searchForRecord("Microcorys sp. Great Victoria Desert (J. Alford s.n. PERTH 09041567)");
        this.reportResult("97a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/taxon/apni/51438628", result.getLsid());
    }

    // Test for issue 97
    // Microcorys sp. Parker Range (C. Hancock s.n. PERTH 09215123)
    @Test
    public void testIssue97c() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Microcorys sp. Parker Range (C. Hancock s.n. PERTH 09215123)");
        this.reportResult("97c", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680189", result.getLsid());
    }


    // Test for issue 98
    // Netrostylis sp. Blackwood River (A.R. Annels 3043)
    @Test
    public void testIssue98a() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Netrostylis sp. Blackwood River (A.R. Annels 3043)");
        this.reportResult("98a", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51682651", result.getLsid());
    }


    // Test for issue 98
    // Netrostylis sp. Chandala (G.J. Keighery 17055)
    @Test
    public void testIssue98b() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Netrostylis sp. Chandala (G.J. Keighery 17055)");
        this.reportResult("98b", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51682655", result.getLsid());
    }

    // Test for issue 98
    // Netrostylis sp. Warren (M. McCallum Webster 23/2/1979)
    @Test
    public void testIssue98c() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Netrostylis sp. Warren (M. McCallum Webster 23/2/1979)");
        this.reportResult("98c", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51682671", result.getLsid());
    }


    // Test for issue 99
    // Nicotiana salina
    @Test
    public void testIssue99() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Nicotiana salina");
        this.reportResult("99", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51421363", result.getLsid());
    }

    // Test for issue 100
    // Paranotis sp. Pilbara (H. Ajduk HAOP04a)
    @Test
    public void testIssue100() throws Exception {
        NameSearchResult result = searcher.searchForRecord("Paranotis sp. Pilbara (H. Ajduk HAOP04a)");
        this.reportResult("100", result);
        assertNotNull(result);
        assertEquals("https://id.biodiversity.org.au/name/apni/51680203", result.getLsid());
    }

}
