package org.greencodeinitiative.creedengo.java.checks;

import java.util.regex.Pattern;

public class AvoidRegexPatternNotStaticValid2 {

    private final Pattern pattern = Pattern.compile("foo"); // Compliant

    public boolean foo() {
        return pattern.matcher("foo").find();
    }
}
