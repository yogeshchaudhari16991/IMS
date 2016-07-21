package com.commercehub.IMS.main.IMS;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yoges on 7/20/2016.
 */
public class IMSapp {
    private static ExecutorService ex;
    public IMSapp(int numberOfTerminals) {
        generateRandomProducts();
        ex = Executors.newCachedThreadPool();
        for (int i = 0; i < numberOfTerminals; i++) {
            ex.submit(new IMSThread());
        }

    }

    private void generateRandomProducts(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            addProduct(Integer.toString(i), "Product-" + i, "Description for Product-" + i, "Zone-" + i, "Section-" + i, r.nextInt(100));
        }
    }

    public static void addProduct(String productId, String name, String description, String zone, String section, int level){
        InventoryManagement.addToInventory(productId, name, description, zone, section, level);
    }

    public static void addTerminal(int numberOfTerminals){
        for (int i = 0; i < numberOfTerminals; i++) {
            ex.submit(new IMSThread());
        }
    }

    public static void stop(){
        ex.shutdown();
    }
}
