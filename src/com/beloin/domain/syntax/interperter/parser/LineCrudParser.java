package com.beloin.domain.syntax.interperter.parser;

import com.beloin.domain.syntax.interperter.CrudToken;

import java.util.List;

// TODO: CREATE A STATE MACHINE
class LineCrudParser {

    public LineCrudParser(List<CrudToken> tokens) {

        this.tokens = tokens;
    }

    private final List<CrudToken> tokens;

    public void parse() {

    }
}
