package net.bytebuddy.pool;

import net.bytebuddy.instrumentation.type.TypeDescription;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypePoolDefaultCacheTest {

    @Test
    public void testCache() throws Exception {
        TypePool typePool = TypePool.Default.ofClassPath();
        TypeDescription typeDescription = typePool.describe(Void.class.getName());
        assertThat(typePool.describe(Void.class.getName()), sameInstance(typeDescription));
        typePool.clear();
        assertThat(typePool.describe(Void.class.getName()), not(sameInstance(typeDescription)));
    }
}