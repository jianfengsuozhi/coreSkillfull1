package com.tcmc.dis.web.util;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

/**
 * json转换类，继承org.codehaus.jackson.map.ObjectMapper
 *
 * @author oufengfang
 * @version V2.0.0
 * @date 2016-08-12 上午9:44
 */
public class TCMCObjectMapper extends org.codehaus.jackson.map.ObjectMapper {
    public TCMCObjectMapper() {
        super();
        //把java对象的long类型的字段序列化时采用ToStringSerializer序列化器
        SimpleModule simpleModule = new SimpleModule("TCMCLongToString Serializer", new Version(0, 1, 1, "FINAL"));
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        this.registerModule(simpleModule);
    }
}
