package me.pagar.util;

import me.pagar.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class MapUtilsTest extends BaseTest {

    private String query = "keyWithValue=123&keyWithoutValue=";

    private String queryEscaped = "keyWith%5Bvalue%5D=123&keyWithout%5Bvalue%5D=";

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testQueryToMap() throws Exception {
        final Map<String, String> values = MapUtils.queryToMap(query);

        Assert.assertEquals("123", values.get("keyWithValue"));
        Assert.assertNull(values.get("keyWithoutValue"));
    }

    @Test
    public void testQueryToMapEscaped() throws Exception {
        final Map<String, String> values = MapUtils.queryToMap(queryEscaped);

        Assert.assertEquals("123", values.get("keyWith[value]"));
        Assert.assertNull(values.get("keyWithout[value]"));
    }

}
