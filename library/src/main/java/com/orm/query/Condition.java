package com.orm.query;

import com.orm.SugarRecord;

public class Condition {

    private String property;
    private Object value;
    private Check check;

    enum Check {
        EQUALS(" = "),
        GREATER_THAN(" > "),
        LESSER_THAN(" < "),
        NOT_EQUALS (" != "),
        LIKE(" LIKE "),
        NOT_LIKE(" NOT LIKE "),
        IS_NULL(" IS NULL "),
        IS_NOT_NULL(" IS NOT NULL ");

        private String symbol;

        Check(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    enum Type {
        AND,
        OR,
        NOT
    }

    private Condition(String property) {
        this.property = property;
    }

    static Condition prop(String property) {
        return new Condition(property);
    }

    Condition eq(Object value) {
        if (value == null) {
            return isNull();
        }
        setValue(value);
        check = Check.EQUALS;
        return this;
    }

    public Condition like(Object value) {
        setValue(value);
        check = Check.LIKE;
        return this;
    }

    public Condition notLike(Object value) {
        setValue(value);
        check = Check.NOT_LIKE;
        return this;
    }

    Condition notEq(Object value) {
        if (value == null) {
            return isNotNull();
        }
        setValue(value);
        check = Check.NOT_EQUALS;
        return this;
    }

    public Condition gt(Object value) {
        setValue(value);
        check = Check.GREATER_THAN;
        return this;
    }

    public Condition lt(Object value) {
        setValue(value);
        check = Check.LESSER_THAN;
        return this;
    }

    Condition isNull() {
        setValue(null);
        check = Check.IS_NULL;
        return this;
    }

    Condition isNotNull() {
        setValue(null);
        check = Check.IS_NOT_NULL;
        return this;
    }

    String getProperty() {
        return property;
    }

    public Object getValue() {
        return value;
    }

    Check getCheck() {
        return check;
    }

    String getCheckSymbol() {
        return check.getSymbol();
    }

    private void setValue(Object value) {
        if (value instanceof SugarRecord) {
            this.value = ((SugarRecord)value).getId();
        } else {
            this.value = value;
        }
    }

}
