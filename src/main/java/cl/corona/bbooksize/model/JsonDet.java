package cl.corona.bbooksize.model;

import java.util.ArrayList;
import java.util.List;

public class JsonDet {
    private String type_id;
    private String type_name;
    private String sizes;
    //ArrayList<Object> sizes = new ArrayList<Object>();
    private String inactive;

    public JsonDet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public JsonDet(String type_id, String type_name, String sizes, String inactive) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.sizes = sizes;
        this.inactive = inactive;
    }

    @Override
    public String toString() {
        return "JsonDet{" +
                "type_id='" + type_id + '\'' +
                ", type_name='" + type_name + '\'' +
                ", sizes='" + sizes + '\'' +
                ", inactive=" + inactive +
                '}';
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }
}
