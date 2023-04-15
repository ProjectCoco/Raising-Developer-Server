package com.developer.processor;

public interface InventoryBookProcessor {
    void checkBook(String characterUUID, String bookUUID);

    void consumeBook(String characterUUID, String bookUUID);
}
