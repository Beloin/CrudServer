package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public class DTOTokenHandler extends AbstractTokenHandler {
    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.matches("dto")) {
            return TokenType.DTO;
        }

        return this.successor(token, ctx);
    }
}
