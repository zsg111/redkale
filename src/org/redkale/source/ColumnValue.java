/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.source;

import java.io.Serializable;
import static org.redkale.source.ColumnExpress.*;

/**
 * ColumnValue主要用于多个字段更新的表达式。
 *
 * <p>
 * 详情见: https://redkale.org
 *
 * @author zhangjx
 */
public class ColumnValue {

    private String column;

    private ColumnExpress express;

    private Serializable value;

    public ColumnValue() {
    }

    public ColumnValue(String column, Serializable value) {
        this(column, ColumnExpress.MOV, value);
    }

    public ColumnValue(String column, ColumnExpress express, Serializable value) {
        this.column = column;
        this.express = express == null ? ColumnExpress.MOV : express;
        this.value = value;
    }

    public static ColumnValue create(String column, Serializable value) {
        return new ColumnValue(column, value);
    }

    public static ColumnValue createMov(String column, Serializable value) {
        return new ColumnValue(column, MOV, value);
    }

    public static ColumnValue createInc(String column, Serializable value) {
        return new ColumnValue(column, INC, value);
    }

    public static ColumnValue createMul(String column, Serializable value) {
        return new ColumnValue(column, MUL, value);
    }

    public static ColumnValue createAnd(String column, Serializable value) {
        return new ColumnValue(column, AND, value);
    }

    public static ColumnValue createOrr(String column, Serializable value) {
        return new ColumnValue(column, ORR, value);
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public ColumnExpress getExpress() {
        return express;
    }

    public void setExpress(ColumnExpress express) {
        this.express = express;
    }

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{\"column\":\"" + column + "\", \"express\":" + express + ", \"value\":" + ((value instanceof CharSequence) ? ("\"" + value + "\"") : value) + "}";
    }
}