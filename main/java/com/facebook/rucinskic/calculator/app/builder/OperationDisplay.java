package com.facebook.rucinskic.calculator.app.builder;

import java.util.EnumMap;
import java.util.Map;

import static com.facebook.rucinskic.calculator.app.logic.BinaryOperation.*;

/**
 * Created by Christopher on 8/11/2014.
 */
public class OperationDisplay {

    private final EnumMap<Display, String> map;

    private OperationDisplay(final EnumMap<Display, String> map) { this.map = map; }

    public String getString(final Display key) { return map.get(key); }

    public static class Builder {

        private final EnumMap<Display, String> map = new EnumMap<>(Display.class);

        public Builder setString(final Display key, final String value) {

            map.put(key, value);
            return this;

        }

        public OperationDisplay build() { return new OperationDisplay(map); }

    }

}
