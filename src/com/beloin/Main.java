package com.beloin;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.CrudLexer;
import com.beloin.domain.syntax.interperter.token.CrudToken;
import com.beloin.domain.syntax.interperter.token.TokenParser;
import com.beloin.domain.syntax.interperter.token.parsers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws DomainException {
        // write your code here
        // We need a Lexical Analysis, Syntax Analysis and Semantic?
        // Following: https://www.toptal.com/scala/writing-an-interpreter#:~:text=To%20create%20an%20interpreter%20first,interprets%20it%20in%20some%20way.
        TokenParser tokenParser = new TokenParser(generateHandlers());
        CrudLexer lexer = new CrudLexer(tokenParser);

        List<String> arr = new ArrayList<>(10);
        arr.add("resource user mappedby user, name, birthdate, photo");
        arr.add("dto user mappedby user, name, password, birthdate");
        lexer.lex(arr);

        for (List<CrudToken> tokenArray : lexer.getTokensPerLine()) {
            for (CrudToken token : tokenArray) {
                System.out.println(token.toString());
            }
            System.out.println();
        }
    }

    private static TokenParserHandler generateHandlers() {
        // MODEL -> RESOURCE -> STOPTOKEN -> CONFIGURATION -> ENDPOINT -> DTO -> MAPPEDBY -> LITERAL

        TokenParserHandler modelHandler = new ModelTokenHandler();
        TokenParserHandler resourceHandler = new ResourceTokenHandler();
        TokenParserHandler stopTokenHandler = new StopTokenHandler();
        TokenParserHandler configurationTokenHandler = new ConfigurationTokenHandler();
        TokenParserHandler endpointTokenHandler = new EndpointTokenHandler();
        TokenParserHandler dtoTokenHandler = new DTOTokenHandler();
        TokenParserHandler mappedbyTokenHandler = new MappedByTokenHandler();
        TokenParserHandler literalTokenHandler = new LiteralTokenHandler();

        modelHandler.setSuccessor(resourceHandler);
        resourceHandler.setSuccessor(stopTokenHandler);
        stopTokenHandler.setSuccessor(configurationTokenHandler);
        configurationTokenHandler.setSuccessor(endpointTokenHandler);
        endpointTokenHandler.setSuccessor(dtoTokenHandler);
        dtoTokenHandler.setSuccessor(mappedbyTokenHandler);
        mappedbyTokenHandler.setSuccessor(literalTokenHandler);

        return modelHandler;
    }
}
