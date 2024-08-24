package de.fionera.dmsafai;


public abstract class ErrorReformatMixinBase {
    protected static Object[] cleanArgs(Object o1, Object o2) {
        return cleanArgs(new Object[]{o1, o2});
    }

    protected static Object[] cleanArgs(Object[] o) {
        for (int i = 0; i < o.length; i++) {
            if (o[i] instanceof Exception) {
                o[i] = ((Exception) o[i]).getMessage();
            }
        }
        return o;
    }
}
