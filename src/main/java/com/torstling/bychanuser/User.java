package com.torstling.bychanuser;

import org.bychan.core.dynamic.Language;
import org.bychan.core.dynamic.LanguageBuilder;

public class User {

    private final Language<Integer> l;

    public User() {
        l = new LanguageBuilder<Integer>().named("plus")
                .newToken().named("number").matchesPattern("[0-9]+").prefixParseAs((integer, lexingMatch, userParserCallback) -> Integer.parseInt(lexingMatch.getText()))
                .newToken().named("plus").matchesString("+").infixParseAs((integer, lexingMatch, userParserCallback) -> integer + userParserCallback.subExpression())
                .completeLanguage();
    }

    public Integer calculate(final String s) {
        return l.getLexParser().parse(s);
    }
}
