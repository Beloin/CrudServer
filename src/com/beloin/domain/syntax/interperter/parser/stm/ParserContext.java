package com.beloin.domain.syntax.interperter.parser.stm;

import com.beloin.domain.syntax.interperter.parser.expressions.Expression;

public class ParserContext {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
