package com.terseinc.FacebookAPITesting;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement
public class MeBean{

    public String id;
    public String name;

    public MeBean(){};
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
