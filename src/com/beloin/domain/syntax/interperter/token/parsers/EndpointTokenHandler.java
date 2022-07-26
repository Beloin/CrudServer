package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

import java.util.Objects;

public class EndpointTokenHandler extends AbstractTokenHandler {
    public EndpointTokenHandler(TokenParserHandler successor) {
        super(successor);
    }

    public EndpointTokenHandler() {
    }

    @Override
    public TokenType handle(String token) throws DomainException {
        if (matchEndpoint(token)) {
            return TokenType.ENDPOINT;
        }

        return this.successor(token);
    }

    private final String[] methods = {"POST", "GET", "PUT", "PATCH", "DELETE"};

    private boolean matchEndpoint(String str) {
        for (String method : methods) {
            if (Objects.equals(method, str)) return true;
        }

        return false;
    }
}
