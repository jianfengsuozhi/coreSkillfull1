package com.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weideliang on 2016/9/19.
 */
public interface MyEnums {
    enum Status {
        Delete((short)-1,"删除"),
        Normal((short)1,"正常");

        private final Short code;
        private final String name;

        Status(Short code, String name) {
            this.code = code;
            this.name = name;
        }

        public Short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static Map<Short, String> mapAll() {
            Map<Short, String> maps = new HashMap<Short, String>();
            for (Status v : Status.values())
                maps.put(v.getCode(), v.getName());
            return maps;
        }
    }
}
