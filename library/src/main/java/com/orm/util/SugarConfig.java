package com.orm.util;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SugarConfig {

    static Map<Class<?>, List<Field>> fields = new HashMap<>();

    static void setFields(Class<?> clazz, List<Field> fieldz) {
         fields.put(clazz, fieldz);
    }

    static List<Field> getFields(Class<?> clazz) {
        if (fields.containsKey(clazz)) {
            List<Field> list = fields.get(clazz);
            return Collections.synchronizedList(list);
        }

        return null;
    }

    static void clearCache() {
        fields.clear();
        fields = new HashMap<>();
    }
}
