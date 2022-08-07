package com.beloin.domain.exceptions;

import com.beloin.domain.syntax.interperter.CrudToken;

public class TokenNotAcceptedException extends DomainException{
    public TokenNotAcceptedException(CrudToken tk) {
        super("Token %s not accepted at current position %d".formatted(tk.getText(), tk.getStartPos()));
    }
}
