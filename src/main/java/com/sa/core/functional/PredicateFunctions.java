package com.sa.core.functional;

import java.util.List;
import java.util.function.BiPredicate;

public interface PredicateFunctions {

    static BiPredicate<List<?extends Enum>, Enum> isInList = List::contains;
}
