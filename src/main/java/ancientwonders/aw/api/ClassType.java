package ancientwonders.aw.api;

import java.util.HashMap;
import java.util.Objects;

public class ClassType {
    public String name;
    private HashMap<String, Integer> parameters;
    public ClassType(String name){
        this.name = name;
        parameters = new HashMap<String, Integer>();
    }
    public ClassType setParamerter(String name, int value){
        parameters.put(name, new Integer(value));
        return this;
    }
    public ClassType addParameter(String name, int min, int max){
        setParamerter(name, min);
        setParamerter(name+"Max", max);
        return this;
    }

    public HashMap<String, Integer> getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassType classType = (ClassType) o;
        return Objects.equals(name, classType.name) && Objects.equals(parameters, classType.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parameters);
    }
}
