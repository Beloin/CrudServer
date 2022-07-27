package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

public interface TokenParserHandler {
    TokenType handle(String token, HandlerContext ctx) throws DomainException;
    TokenType successor(String token, HandlerContext ctx) throws DomainException;
    void setSuccessor(TokenParserHandler tokenParserHandler);
}
