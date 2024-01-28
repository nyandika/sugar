package com.orm.record;

import static com.orm.SugarRecord.delete;
import static com.orm.SugarRecord.save;
import static org.junit.Assert.assertFalse;

import android.database.sqlite.SQLiteException;

import com.orm.app.ClientApp;
import com.orm.model.IncompleteAnnotatedModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(application = ClientApp.class, packageName = "com.orm.model", manifest = Config.NONE)
public final class IncompleteAnnotatedModelTests {

    @Test(expected = SQLiteException.class)
    public void saveNoIdFieldTest() {
        save(new IncompleteAnnotatedModel());
    }

    @Test
    public void deleteNoIdFieldTest() {
        assertFalse(delete(new IncompleteAnnotatedModel()));
    }
}
