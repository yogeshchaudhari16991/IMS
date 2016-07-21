package com.commercehub.IMS.main.Abstracts;

import com.commercehub.IMS.main.Models.Location;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yoges on 7/20/2016.
 */
public abstract class AbstractProduct {
    private Location location;
    private volatile int level;
    private String productID;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock read = lock.readLock();
    private Lock write = lock.writeLock();

    public AbstractProduct() {
        super();
    }

    public AbstractProduct(Location location, int level, String productID) {
        this();
        this.location = location;
        this.level = level;
        this.productID = productID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getLevel() {
        try {
            this.read.tryLock(50L, TimeUnit.MILLISECONDS);
            return this.level;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            this.read.unlock();
        }
    }

    public void setLevel(int level) {
        try {
            this.write.tryLock(50L, TimeUnit.MILLISECONDS);
            this.level = level;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.write.unlock();
        }
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public boolean pick(int amountToPick) {
        try {
            this.write.tryLock(50L, TimeUnit.MILLISECONDS);
            if (this.getLevel() < amountToPick) {
                return false;
            } else {
                this.setLevel(this.getLevel() - amountToPick);
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.write.unlock();
        }
    }

    public boolean restock(int amountToPick) {
        try {
            this.write.tryLock(50L, TimeUnit.MILLISECONDS);
            this.setLevel(this.getLevel() + amountToPick);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.write.unlock();
        }
    }
}
