package com.beloin.domain.syntax.interperter.parser.expressions;

public abstract class Expression {

    private ExpressionType type;

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }
}

