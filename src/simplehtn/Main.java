package simplehtn;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void solve(String domainFn, String problemFn, int planNo, boolean verbose, Object... funcs) {
        CreateArgs createArgs = new CreateArgs();
        for (Object func : funcs) {
            if (func instanceof Calculate cal) {
                createArgs.getCallMap().put(cal.getClass().getSimpleName(), cal);
            } else if (func instanceof ComparatorCreator cc) {
                createArgs.getSortMap().put(cc.getClass().getSimpleName(), cc);
            } else if (func instanceof Domain d) {
                createArgs.getKnownDomainMap().put(d.name, d);
            } else {
                throw new IllegalArgumentException(func + " 无法注册");
            }
        }


        Creator creator;
        try {
            creator = Creator.createFromFile(domainFn, createArgs);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        if (!creator.isDomain()) {
            throw new IllegalArgumentException("第一个文件应该是domain");
        }

        Domain domain = creator.getDomain();
        createArgs.getKnownDomainMap().put(domain.name, domain);

        try {
            creator = Creator.createFromFile(problemFn, createArgs);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        if (creator.isDomain()) {
            throw new IllegalArgumentException("第二个文件应该是problem");
        }

        Problem problem = creator.getProblem();
        PlanStepListener lis = verbose ? PlanStepListener.PRINT_TO_CONSOLE : PlanStepListener.NULL;
        Planner planner = new Planner(problem, planNo, lis);
        List<Plan> plans = planner.findPlans();

        System.out.println("共找到 " + plans.size() + " 计划");
        for (Plan plan : plans) {
            System.out.println("-----------------");
            System.out.println(plan);
        }
    }


    private static void usage(String err) {
        System.err.println(err);
        System.err.println("usage:  java -jar simplehtn.jar <domain file> <problem file> <plan number>? <-v>?");
        System.err.println("            <plan number> 不存在默认为1，all表示全部");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) {
            usage("");
        }

        String df = args[0];
        String pf = args[1];
        int planNo = 1;
        if (args.length >= 3) {
            if (args[2].equals("all")) {
                planNo = Integer.MAX_VALUE;
            } else {
                try {
                    planNo = Integer.parseInt(args[2]);
                } catch (NumberFormatException e) {
                    usage(e.toString());
                }
            }
        }
        boolean verbose = false;
        if (args.length >= 4) {
            if (args[3].equals("-v")) {
                verbose = true;
            } else {
                usage("");
            }
        }

        solve(df, pf, planNo, verbose);

    }
}
