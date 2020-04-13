package com.orm;

import java.util.Locale;

/**
 * @author jonatan.salas
 */
public class SugarDbConfiguration {

    /**
     * Tells SQLite which is the database default locale
     */
    private Locale databaseLocale;

    /**
     * Tells SQLite how much it can grow
     */
    private Long maxSize;

    /**
     * Tells SQLite the page size that have
     */
    private Long pageSize;

    SugarDbConfiguration() { }

    Locale getDatabaseLocale() {
        return databaseLocale;
    }

    SugarDbConfiguration setDatabaseLocale(Locale databaseLocale) {
        this.databaseLocale = databaseLocale;
        return this;
    }

    Long getMaxSize() {
        return maxSize;
    }

    SugarDbConfiguration setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    Long getPageSize() {
        return pageSize;
    }

    SugarDbConfiguration setPageSize(Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public String toString() {
        return "SugarDbConfiguration{" +
                ", databaseLocale=" + databaseLocale +
                ", maxSize=" + maxSize +
                ", pageSize=" + pageSize +
                '}';
    }
}
