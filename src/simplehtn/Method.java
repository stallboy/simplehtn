package simplehtn;


import java.util.Set;

public class Method extends DomainElement {

    static class MethodSub {
        String label;
        Precondition pre;
        TaskList tasklist;
    }

    MethodSub[] subs;

    public Method(Domain domain, Set<String> vars) {
        super(domain, vars);
    }
}
