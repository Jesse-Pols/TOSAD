package hu.tosad2019.groep4.designer.application.domain.objects;

public class SpecifiedValue {
    Object value;
    String type;

    public SpecifiedValue(Object value){
        this.value = value;
    }

    public Object get(){
        return value;
    }

    public String getType(){return  this.type;}
}