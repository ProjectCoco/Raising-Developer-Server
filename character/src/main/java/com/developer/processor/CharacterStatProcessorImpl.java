package com.developer.processor;

import com.developer.domainmodel.CharacterDomain;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

public class CharacterStatProcessorImpl implements CharacterStatProcessor{

    @Override
    public Mono<CharacterDomain> updateStat(CharacterDomain character, String targetStat, int point) {
        if (targetStat.equals("backend")) {
            return Mono.just(
                    new CharacterDomain(character.id(),character.backend()+point,character.frontend(),character.ops(),character.health(),character.teamwork()));
        } else if (targetStat.equals("frontend")) {
            return Mono.just(
                    new CharacterDomain(character.id(),character.backend(),character.frontend()+point,character.ops(),character.health(),character.teamwork()));
        } else if (targetStat.equals("ops")) {
            return Mono.just(
                    new CharacterDomain(character.id(),character.backend(),character.frontend(),character.ops()+point,character.health(),character.teamwork()));
        } else if (targetStat.equals("health")) {
            return Mono.just(
                    new CharacterDomain(character.id(),character.backend(),character.frontend(),character.ops(),character.health()+point,character.teamwork()));
        } else if (targetStat.equals("teamwork")) {
            return Mono.just(
                    new CharacterDomain(character.id(),character.backend(),character.frontend(),character.ops(),character.health(),character.teamwork()+point));
        } else {
            throw new IllegalArgumentException("Not Support Stat");
        }
    }
}
