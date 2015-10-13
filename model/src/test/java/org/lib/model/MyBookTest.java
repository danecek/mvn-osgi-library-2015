/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.model;

import static org.junit.Assert.*;

/**
 *
 * @author danecek
 */
public class MyBookTest {

    public MyBookTest() {
    }

    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        MyBook instance = new MyBook(new MyBookId(2), "xxx", "xxx");
        MyBookId expResult = new MyBookId(2);
        MyBookId result = instance.getId();
        assertEquals(expResult, result);
    }


}
