package company.com.co.resolvers;

import company.com.co.flows.*;

import java.util.Map;

public class LoginFlowResolver {

    private static final Map<String, LoginFlow> flows = Map.ofEntries(
            Map.entry("demoblaze", new DemoblazeLoginFlow()),
            Map.entry("guru", new DefaultLoginFlow()),
            Map.entry("guru99", new DefaultLoginFlow())
            // Agrega más alias aquí según lo necesites
    );

    public static LoginFlow resolve(String alias) {
        return flows.getOrDefault(alias.toLowerCase(), new DefaultLoginFlow());
    }
}
