package com.beloin.domain.syntax.interperter.lexer;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.TokenIdentifier;
import com.beloin.domain.syntax.utils.StopTokensUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CrudLexer {
    public CrudLexer(TokenIdentifier parser, List<String> lines) {
        this.tokenParser = parser;
        this.lines = lines;
    }

    private final TokenIdentifier tokenParser;
    private final List<String> lines;
    private List<List<CrudToken>> tokensPerLine;

    public void lex() throws DomainException {
        tokensPerLine = new ArrayList<>(lines.size());
        for (String currentLine : lines) {
            readLine(currentLine);
        }
    }


    private void readLine(String currentLine) throws DomainException {
        StringBuilder tokenBuilder = new StringBuilder();
        List<CrudToken> tokens = new LinkedList<>();
        int startAt = 0;
        for (int j = 0; j < currentLine.length(); j++) {
            char currentChar = currentLine.charAt(j);
            if (StopTokensUtils.isStopToken(currentChar)) {
                String token = tokenBuilder.toString();

                // If is not stop token:
                if (token.length() >= 1) {
                    if (!StopTokensUtils.isStopToken(token.charAt(0))) {
                        CrudToken crudToken = createCrudToken(token, startAt);
                        tokens.add(crudToken);
                    }
                }

                CrudToken stopToken = createCrudToken(String.valueOf(currentChar), j);
                tokens.add(stopToken);

                tokenBuilder = new StringBuilder();
                startAt = j + 1;
                continue;
            }

            tokenBuilder.append(currentChar);
        }

        String token = tokenBuilder.toString();
        if (token.length() >= 1) {
            CrudToken crudToken = createCrudToken(token, startAt);
            tokens.add(crudToken);
        }

        this.tokensPerLine.add(tokens);
    }

    private CrudToken createCrudToken(String token, int position) throws DomainException {
        TokenType type = tokenParser.parse(token, position);
        return new CrudToken(type, token, position);
    }

    public List<List<CrudToken>> getTokensPerLine() {
        return tokensPerLine;
    }
}
