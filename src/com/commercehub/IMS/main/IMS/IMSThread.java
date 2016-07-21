package com.commercehub.IMS.main.IMS;

import com.commercehub.IMS.main.Interfaces.InventoryManagementSystem;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by yoges on 7/20/2016.
 */
public class IMSThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Startign Thread: " + Thread.currentThread().getId());
        InventoryManagementSystem ims = new InventoryManagement();
        Random r = new Random();
        while(true){
            try {
                sleep(r.nextInt(100));
                System.out.println("Pick");
                System.out.println(ims.pickProduct(Integer.toString(r.nextInt(10)), r.nextInt(100)));
                sleep(r.nextInt(100));
                System.out.println("Restock");
                System.out.println(ims.restockProduct(Integer.toString(r.nextInt(10)), r.nextInt(100)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
