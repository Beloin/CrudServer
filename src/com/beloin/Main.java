package com.beloin;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.lexer.CrudLexer;
import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.TokenIdentifier;
import com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.handlers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws DomainException {
        // write your code here
        // We need a Lexical Analysis, Syntax Analysis and Semantic?
        // Following: https://www.toptal.com/scala/writing-an-interpreter#:~:text=To%20create%20an%20interpreter%20first,interprets%20it%20in%20some%20way.
        // https://www.twilio.com/blog/abstract-syntax-trees
        TokenIdentifier tokenParser = new TokenIdentifier(generateHandlers());

        List<String> arr = new ArrayList<>(10);
        arr.add("auth.roles ADMIN; USER");
        arr.add("resource user mappedby user, name, birthdate, photo");
        arr.add("dto user mappedby user, name, password, birthdate");
        arr.add("model user, string name 255, string password lenght:255, date birthdate, media.url photo, role role");
        CrudLexer lexer = new CrudLexer(tokenParser, arr);
        lexer.lex();

        int index = 0;
        for (List<CrudToken> tokenArray : lexer.getTokensPerLine()) {
            System.out.println(arr.get(index));
            index++;
            for (CrudToken token : tokenArray) {
                System.out.println(token.toString());
            }
            System.out.println();
        }
    }

    private static TokenIdentifierHandler generateHandlers() {
        // MODEL -> RESOURCE -> ARRAYTOKEN -> VALUABLETOKEN -> STOPTOKEN -> CONFIGURATION -> ENDPOINT -> DTO -> MAPPEDBY -> LITERAL
        TokenIdentifierHandler modelHandler = new ModelTokenHandler();
        TokenIdentifierHandler resourceHandler = new ResourceTokenHandler();
        TokenIdentifierHandler arrayTokenHandler = new ArrayTokenHandler();
        TokenIdentifierHandler valuableTokenHandler = new ValuableTokenHandler();
        TokenIdentifierHandler stopTokenHandler = new StopTokenHandler();
        TokenIdentifierHandler configurationTokenHandler = new ConfigurationTokenHandler();
        TokenIdentifierHandler endpointTokenHandler = new EndpointTokenHandler();
        TokenIdentifierHandler dtoTokenHandler = new DTOTokenHandler();
        TokenIdentifierHandler mappedbyTokenHandler = new MappedByTokenHandler();
        TokenIdentifierHandler literalTokenHandler = new LiteralTokenHandler();

        modelHandler.setSuccessor(resourceHandler);
        resourceHandler.setSuccessor(arrayTokenHandler);
        arrayTokenHandler.setSuccessor(valuableTokenHandler);
        valuableTokenHandler.setSuccessor(stopTokenHandler);
        stopTokenHandler.setSuccessor(configurationTokenHandler);
        configurationTokenHandler.setSuccessor(endpointTokenHandler);
        endpointTokenHandler.setSuccessor(dtoTokenHandler);
        dtoTokenHandler.setSuccessor(mappedbyTokenHandler);
        mappedbyTokenHandler.setSuccessor(literalTokenHandler);

        return modelHandler;
    }
}
