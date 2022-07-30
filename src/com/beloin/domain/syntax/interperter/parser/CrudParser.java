package com.beloin.domain.syntax.interperter.parser;

import com.beloin.domain.syntax.interperter.CrudToken;

import java.util.List;

// TODO: SEE INTERPRETER DESIGN PATTERN
// This Parser
public class CrudParser {

    public CrudParser(List<List<CrudToken>> tokens) {
        this.tokensPerLine = tokens;

    }

    private final List<List<CrudToken>> tokensPerLine;
    private CrudToken lastToken;
    private LineCrudParser lineCrudParser;

    public void parse() {
        for (List<CrudToken> tokens : tokensPerLine) {
            this.parse(tokens);
        }
    }

    private void parse(List<CrudToken> tokens) {
        lineCrudParser = new LineCrudParser(tokens);
        lineCrudParser.parse();
    }
}
