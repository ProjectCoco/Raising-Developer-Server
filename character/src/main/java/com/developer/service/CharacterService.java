package com.developer.service;

import reactor.core.publisher.Mono;

public interface CharacterService {
    Mono<Boolean> readBook(String characterUUID, String bookUUID);
}
