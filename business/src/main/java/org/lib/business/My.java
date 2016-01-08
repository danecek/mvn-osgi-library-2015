/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

/**
 *
 * @author danecek
 */
public class My implements MyMBean {
    
    long start = System.currentTimeMillis();

    @Override
    public int getTime() {
        return (int) ((System.currentTimeMillis() - start) /1000);
    }
    
}
