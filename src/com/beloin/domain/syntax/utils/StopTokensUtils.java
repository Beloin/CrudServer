package com.beloin.domain.syntax.utils;

public class StopTokensUtils {
    private static final char[] stopTokens = {' ', ',', ';', ':', '\n'};

    public static boolean isStopToken(char character) {
        for (char stopSign : stopTokens) {
            if (character == stopSign) {
                return true;
            }
        }

        return false;
    }

}
