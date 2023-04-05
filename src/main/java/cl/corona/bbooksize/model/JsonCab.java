package cl.corona.bbooksize.model;

import java.util.ArrayList;
import java.util.List;

public class JsonCab {
    private List<JsonDet> data;

    public JsonCab() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "JsonCab{" +
                ", data=" + data +
                '}';
    }

    public JsonCab(List<JsonDet> size) {
        this.data = size;
    }

    public List<JsonDet> getSize() {
        return data;
    }

    public void setSize(List<JsonDet> size) {
        this.data = size;
    }

}
