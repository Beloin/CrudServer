package com.beloin.domain.syntax.interperter;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.CrudToken;
import com.beloin.domain.syntax.interperter.token.TokenParser;
import com.beloin.domain.syntax.interperter.token.TokenType;
import com.beloin.domain.syntax.utils.StopTokensUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CrudLexer {
    public CrudLexer(TokenParser parser) {
        this.tokenParser = parser;
    }

    private final TokenParser tokenParser;
    private List<List<CrudToken>> tokensPerLine;

    public void lex(List<String> lines) throws DomainException {
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
