package com.developer.domainmodel;


import java.util.UUID;

public record CharacterDomain(
        UUID id,
        int backend,
        int frontend,
        int ops,
        int health,
        int teamwork
        ) {
    public CharacterDomain(UUID id){
        this(id,0,0,0 ,0,0);
    }
}
