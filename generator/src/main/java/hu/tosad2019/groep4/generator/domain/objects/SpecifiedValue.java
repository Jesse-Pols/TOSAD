package hu.tosad2019.groep4.generator.domain.objects;

public class SpecifiedValue {
    Object value;
    SpecifiedValue(Object value){
        this.value = value;
    }

    public Object get(){
        return value;
    }
}
