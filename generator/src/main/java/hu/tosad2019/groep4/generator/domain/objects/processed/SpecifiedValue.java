package hu.tosad2019.groep4.generator.domain.objects.processed;

public class SpecifiedValue {
    Object value;
    SpecifiedValue(Object value){
        this.value = value;
    }

    public Object get(){
        return value;
    }
}
