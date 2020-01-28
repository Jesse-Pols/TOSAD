package hu.tosad2019.groep4.generator.application.domain.objects;

public class SpecifiedValue {

    Object value;
    public SpecifiedValue(Object value){
        this.value = value;
    }

    public Object get(){
        return value;
    }
}
