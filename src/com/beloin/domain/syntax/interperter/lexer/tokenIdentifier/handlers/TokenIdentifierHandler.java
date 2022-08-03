package com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public interface TokenIdentifierHandler {
    TokenType handle(String token, HandlerContext ctx) throws DomainException;
    TokenType successor(String token, HandlerContext ctx) throws DomainException;
    void setSuccessor(TokenIdentifierHandler tokenParserHandler);
}
