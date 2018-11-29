package install.ui.Toolbox;

import org.springframework.context.ApplicationContext;

public class ValueTB {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        ValueTB.context = context;
    }
}
