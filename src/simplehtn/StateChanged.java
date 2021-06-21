package simplehtn;

import java.util.ArrayList;
import java.util.List;

public class StateChanged {
    final List<NumberedPredicate> del = new ArrayList<>();
    final List<Predicate> add = new ArrayList<>();

    final List<Predicate> protectionDel = new ArrayList<>();
    final List<Predicate> protectionAdd = new ArrayList<>();

    void clear() {
        del.clear();
        add.clear();
        protectionDel.clear();
        protectionAdd.clear();
    }
}
