package com.orm;

import static org.junit.Assert.assertFalse;

import android.database.sqlite.SQLiteDatabase;

import com.orm.app.ClientApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @author jonatan.salas
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = ClientApp.class, manifest = Config.NONE)
public final class SugarDbTest {
    private final SugarDb sugarDb = SugarDb.getInstance();

    @Test
    //TODO check this better!
    public void testGetReadableDatabase() {
        final SQLiteDatabase db = sugarDb.getReadableDatabase();
        assertFalse(db.isReadOnly());
    }

    @Test
    public void testGetWritableDatabase() {
        final SQLiteDatabase db = sugarDb.getWritableDatabase();
        assertFalse(db.isReadOnly());
    }

    @Test
    public void testGetDB() {
        final SQLiteDatabase db = sugarDb.getDB();
        assertFalse(db.isReadOnly());
    }
}
