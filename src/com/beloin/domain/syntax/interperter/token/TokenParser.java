package com.beloin.domain.syntax.interperter.token;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.parsers.TokenParserHandler;

// TODO: CHAIN OF RESPONSIBILITY
public class TokenParser {
    private final TokenParserHandler mainHandler;

    public TokenParser(TokenParserHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    public TokenType parse(String tokenStr) throws DomainException {
        return this.mainHandler.handle(tokenStr);
    }

}
