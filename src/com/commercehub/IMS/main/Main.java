package com.commercehub.IMS.main;

import com.commercehub.IMS.main.IMS.IMSapp;

public class Main {

    private static int numberOfTerminals;

    public static void main(String[] args) {
        numberOfTerminals = 10;
        IMSapp imsApp = new IMSapp(numberOfTerminals);
        int i=0;
        while(i++<2000){
            // wait
        }
        imsApp.stop();
    }
}
