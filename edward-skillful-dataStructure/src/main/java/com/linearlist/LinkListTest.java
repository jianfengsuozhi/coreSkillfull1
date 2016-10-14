package com.linearlist;

/**
 * Created by weideliang on 2016/10/13.
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList02 linkList02 = new LinkList02();
        String[] strArray = new String[]{"testAdd1","testAdd2","testAdd3"};
        linkList02.addAll(strArray);

        System.out.println(linkList02.toArray());
        System.out.println(linkList02.toArray());
        linkList02.removeFirst("testAdd2");
        System.out.println(linkList02.toArray());
    }
}
