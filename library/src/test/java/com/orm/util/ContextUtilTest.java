package com.orm.util;

import static com.orm.util.ContextUtil.getAssets;
import static com.orm.util.ContextUtil.getContext;
import static com.orm.util.ContextUtil.getPackageManager;
import static com.orm.util.ContextUtil.getPackageName;
import static com.orm.util.ContextUtil.getSharedPreferences;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.app.ClientApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @author jonatan.salas
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = ClientApp.class, packageName = "com.orm.model", manifest = Config.NONE)
public final class ContextUtilTest {

    @Test(expected = IllegalAccessException.class)
    public void testPrivateConstructor() throws Exception {
        ContextUtil contextUtil = ContextUtil.class.getDeclaredConstructor().newInstance();
        assertNull(contextUtil);
    }


    @Test
    public void testInitContext() {
        assertNotNull(getContext());
    }

    @Test
    public void testGetAssets() {
        assertNotNull(getAssets());
    }

    @Test
    public void testGetPackageManager() {
        assertNotNull(getPackageManager());
    }

    @Test
    public void testGetPackageName() {
        assertNotNull(getPackageName());
    }

    @Test
    public void testGetPreferences() {
        assertNotNull(getSharedPreferences("lala", Context.MODE_PRIVATE));
    }

    @Test
    public void testTerminateContext() {
        SugarContext.terminate();
        assertNull(getContext());
    }
}
