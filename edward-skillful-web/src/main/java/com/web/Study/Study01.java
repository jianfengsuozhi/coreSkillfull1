package com.web.Study;

import com.exception.MyIllegalArgumentException;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by weideliang on 2016/11/9.
 */
@Controller
@RequestMapping("/study01")
public class Study01 {
    private static Logger logger = LoggerFactory.getLogger(Study01.class);
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2);//根据参数得到list
        List<Integer> natures = Lists.newArrayList(1,2);

//        nCount = super.insertSelectiveWithPK(updateBauMaterial, baseAuthorizeMaterialDao); 对象 dao

        //String.format
        //1.1格式化字符串
        String.format("%05d", Integer.parseInt("123"));//不足4位时,前面加0补足4位   0 代表前面补充0  4 代表长度为4 d 代表参数为正数型

//        System.out.println(String.format("Hi,%s:%s.%s", "王南","王力","王张"));//Hi,王南:王力.王张

//        System.out.println(String.format("格式参数$的使用：%1$d,%2$s", 99,"abc"));//格式参数$的使用：99,abc 1$第一个参数
//        System.out.println(String.format("格式参数$的使用：%2$s,%1$s", "99","abc"));//格式参数$的使用：abc,99 1$第一个参数 2$:第二个参数

//        System.out.println(String.format("%1$3s", "1"));//  1 最小宽度
//        System.out.println(String.format("%1$3s", "22"));// 22
//        System.out.println(String.format("%1$3s", "222"));//222
//        System.out.println(String.format("%1$3s", "3333"));//3333

        //校验
        MyIllegalArgumentException.checkTrue(LessAndEqualZero(-1l),logger,"id不能小于或等于0");

        //多字段枚举
        //MaterialAtt("M001","物资属性","base_material_att")
        //SupplierGoods((short)1,"供货商","供应商","S")
        //获取值 BaseContactCompanyEnum.Nature.mapPrefixAll().get(natrue);

    }

    /**
     * 校验id
     * @param curValue
     * @return
     */
    protected static boolean LessAndEqualZero(Long curValue){
        return curValue == null || curValue <= 0;
    }

    private Boolean testBoolean;
    private boolean testboolean;//生成的是isTestboolean 而不是getTestboolean

    public Boolean getTestBoolean() {
        return testBoolean;
    }

    public void setTestBoolean(Boolean testBoolean) {
        this.testBoolean = testBoolean;
    }

    public boolean isTestboolean() {
        return testboolean;
    }

    public void setTestboolean(boolean testboolean) {
        this.testboolean = testboolean;
    }
}
