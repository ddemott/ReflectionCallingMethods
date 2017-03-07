import java.lang.reflect.Method;

public class StaticMethodReflectionHelper {

    public static Object callStaticMethod(
            /* class that contains the static method */ final Class<?> clazz,
            /* method name */ final String methodName,
            /* optional method parameters */final Object... parameters) throws Exception {

        for (final Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName)) {
                final Class<?>[] paramTypes = method.getParameterTypes();
                if (parameters.length != paramTypes.length) {
                    continue;
                }
                boolean compatible = true;
                for (int i = 0; i < paramTypes.length; i++) {
                    final Class<?> paramType = paramTypes[i];
                    final Object param = parameters[i];
                    if (param != null && !paramType.isInstance(param)) {
                        compatible = false;
                        break;
                    }
                }
                if (compatible) {
                    return method.invoke(/* static invocation */null, parameters);
                }
            }
        }
        throw new NoSuchMethodException(methodName);
    }
    
    public static Object callStaticDynamicMethod(
            /* class that contains the static method */ final Class<?> clazz,
            /* instance of the class */  Object clazzInstance,
            /* method name */ final String methodName,
            /* optional method parameters */final Object... parameters) throws Exception {

        if (clazzInstance.getClass().isInstance(clazz)) {
            System.out.println("true");
        }

        for (final Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName)) {
                final Class<?>[] paramTypes = method.getParameterTypes();
                if (parameters.length != paramTypes.length) {
                    continue;
                }
                boolean compatible = true;
                for (int i = 0; i < paramTypes.length; i++) {
                    final Class<?> paramType = paramTypes[i];
                    final Object param = parameters[i];
                    if (param != null && !paramType.isInstance(param)) {
                        compatible = false;
                        break;
                    }

                }
                if (compatible) {
                    return method.invoke(clazzInstance, parameters);
                }
            }
        }
        throw new NoSuchMethodException(methodName);
    }

}
