package jmyparser;

@FunctionalInterface
public interface Parser<T> {

    T parse(SourceTest s) throws Exception;

}
