package simplehtn;

import java.util.HashMap;
import java.util.Map;

public class CreateArgs {
    private final Map<String, Calculate> callMap = new HashMap<>();
    private final Map<String, ComparatorCreator> sortMap = new HashMap<>();
    private final Map<String, Domain> knownDomainMap = new HashMap<>();

    public CreateArgs() {
        callMap.put("/", Calculates.div);
        callMap.put("=", Calculates.equal);
        callMap.put("<", Calculates.less);
        callMap.put("<=", Calculates.lessEq);
        callMap.put("member", Calculates.member);
        callMap.put("-", Calculates.minus);
        callMap.put(">", Calculates.more);
        callMap.put(">=", Calculates.moreEq);
        callMap.put("*", Calculates.mult);
        callMap.put("!=", Calculates.notEq);
        callMap.put("+", Calculates.plus);
        callMap.put("^", Calculates.power);

        sortMap.put("<", ComparatorCreators.less);
        sortMap.put(">", ComparatorCreators.more);
    }

    public Map<String, Calculate> getCallMap() {
        return callMap;
    }

    public Map<String, ComparatorCreator> getSortMap() {
        return sortMap;
    }

    public Map<String, Domain> getKnownDomainMap() {
        return knownDomainMap;
    }

    public Calculate assureGetCall(String call) {
        Calculate r = callMap.get(call);
        if (r == null) {
            throw new IllegalArgumentException("找不到call = " + call);
        }
        return r;
    }

    public ComparatorCreator assureGetSort(String sort) {
        ComparatorCreator r = sortMap.get(sort);
        if (r == null) {
            throw new IllegalArgumentException("找不到sort = " + sort);
        }
        return r;
    }

    public Domain assureGetKnownDomain(String domain) {
        Domain r = knownDomainMap.get(domain);
        if (r == null) {
            throw new IllegalArgumentException("找不到domain = " + domain);
        }
        return r;
    }
}
