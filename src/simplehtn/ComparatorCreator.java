package simplehtn;

import java.util.Comparator;

public interface ComparatorCreator {
    Comparator<Term[]> create(int varIndex);
}
