package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

public class ResourceTokenHandler extends AbstractTokenHandler {

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.equals("resource")) {
            return TokenType.RESOURCE;
        }

        return this.successor(token, ctx);
    }
}
