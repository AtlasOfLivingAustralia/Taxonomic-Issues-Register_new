package au.org.ala.names.issues;

import au.org.ala.names.model.NameSearchResult;
import au.org.ala.names.search.ALANameSearcher;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractIssueTest {
    private static final Logger logger = LoggerFactory.getLogger(AbstractIssueTest.class);
    protected static ALANameSearcher searcher;

    @BeforeClass
    public static void init() throws Exception {
        searcher = new ALANameSearcher("/data/lucene/namematching-20230329-1");
    }

    /**
     * Log a result for an issue so that people can see what's happening
     *
     * @param issue The issue name
     * @param result The result
     */
    public void reportResult(String issue, NameSearchResult result) {
        StringBuilder builder = new StringBuilder();
        builder.append("Issue ");
        builder.append(issue);
        builder.append(": ");
        if (result == null) {
            builder.append("Not Found");
        } else {
            builder.append(result.toMap());
        }
        logger.info(builder.toString());
    }

}
