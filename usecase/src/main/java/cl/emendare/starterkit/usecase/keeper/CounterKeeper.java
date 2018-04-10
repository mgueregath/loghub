/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.keeper;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class CounterKeeper {

    private static int services = 0;
    private static int methods = 0;

    private CounterKeeper() {
        // Prevent instantation
    }

    /**
     * @return the services
     */
    public static int getServices() {
        return services;
    }

    /**
     * @param aServices the services to set
     */
    public static void setServices(int aServices) {
        if (services < aServices) {
            services = aServices;
        }
    }

    /**
     * @return the methods
     */
    public static int getMethods() {
        return methods;
    }

    /**
     * @param aMethods the methods to set
     */
    public static void setMethods(int aMethods) {
        if (methods < aMethods) {
            methods = aMethods;
        }
    }
}
