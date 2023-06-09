package com.developer.service;

import com.developer.processor.BookFindProcessor;
import com.developer.processor.CharacterStatProcessor;
import com.developer.processor.InventoryBookProcessor;
import reactor.core.publisher.Mono;

public class CharacterServiceImpl implements CharacterService{

    private final CharacterStatProcessor characterStatProcessor;

    private final BookFindProcessor bookFindProcessor;

    private final InventoryBookProcessor inventoryBookProcessor;

    public CharacterServiceImpl(CharacterStatProcessor characterStatProcessor, BookFindProcessor bookFindProcessor, InventoryBookProcessor inventoryBookProcessor) {
        this.characterStatProcessor = characterStatProcessor;
        this.bookFindProcessor = bookFindProcessor;
        this.inventoryBookProcessor = inventoryBookProcessor;
    }

    @Override
    public Mono<Boolean> readBook(String characterUUID, String bookUUID) {
        inventoryBookProcessor.checkBook(characterUUID, bookUUID);
        bookFindProcessor.getBook(bookUUID);
        characterStatProcessor.updateStat(1);
        inventoryBookProcessor.consumeBook(characterUUID, bookUUID);
        return Mono.just(Boolean.TRUE);
    }

}
