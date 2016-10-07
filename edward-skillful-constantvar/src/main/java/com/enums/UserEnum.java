package com.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edward on 2016/10/7.
 */
public class UserEnum {
    enum Enable{
        Can_User((short)1,"可以使用"),
        Cannot_User((short)-1,"不可以使用");

        private final short code;
        private final String name;

        Enable(short code, String name) {
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static Map<Short, String> mapAll() {
            Map<Short, String> maps = new HashMap<Short, String>();
            for (MyEnums.Status v : MyEnums.Status.values())
                maps.put(v.getCode(), v.getName());
            return maps;
        }
    }
}
