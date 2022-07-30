package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

import java.util.Objects;

public class EndpointTokenHandler extends AbstractTokenHandler {

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (matchEndpoint(token)) {
            return TokenType.ENDPOINT;
        }

        return this.successor(token, ctx);
    }

    private final String[] methods = {"POST", "GET", "PUT", "PATCH", "DELETE"};

    private boolean matchEndpoint(String str) {
        for (String method : methods) {
            if (Objects.equals(method, str)) return true;
        }

        return false;
    }
}
