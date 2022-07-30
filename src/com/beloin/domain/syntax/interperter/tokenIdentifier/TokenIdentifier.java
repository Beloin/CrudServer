package com.beloin.domain.syntax.interperter.tokenIdentifier;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.tokenIdentifier.handlers.HandlerContext;
import com.beloin.domain.syntax.interperter.tokenIdentifier.handlers.TokenIdentifierHandler;

// TODO: CHAIN OF RESPONSIBILITY
public class TokenIdentifier {
    private final TokenIdentifierHandler mainHandler;

    public TokenIdentifier(TokenIdentifierHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    public TokenType parse(String tokenStr, int currentPosition) throws DomainException {
        HandlerContext context = new HandlerContext(currentPosition);
        return this.mainHandler.handle(tokenStr, context);
    }

}
