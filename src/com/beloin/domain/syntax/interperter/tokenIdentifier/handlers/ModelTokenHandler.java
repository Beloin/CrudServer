package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

import java.util.Objects;

public class ModelTokenHandler extends AbstractTokenHandler {
    private static final String MODEL = "model";

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (Objects.equals(token, MODEL)) {
            return TokenType.MODEL;
        }

        return this.successor(token, ctx);
    }

}
