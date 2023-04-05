package cl.corona.bbooksize.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bbook_talla")
public class BbookEnviaSize {

    @Id
    @Column(name = "idd", columnDefinition = "varchar2(100)")
    private String id;

    @Column(name = "type_id", columnDefinition = "number(20)")
    private int typeId;

    @Column(name = "type_name", columnDefinition = "varchar2(50)")
    protected String typeName;

    @Column(name = "sizes", columnDefinition = "varchar2(1000)")
    protected String sizes;

    @Column(name = "inactive", columnDefinition = "varchar2(50)")
    protected String inactive;

    @Column(name="tran_type" ,columnDefinition = "varchar2(1)")
    protected String tranType;


    public BbookEnviaSize() {
        super();
    }

    public BbookEnviaSize(String id, int typeId, String typeName, String sizes, String inactive, String tranType) {
        super();
        this.id = id;
        this.typeId = typeId;
        this.typeName = typeName;
        this.sizes = sizes;
        this.inactive = inactive;
        this.tranType = tranType;

    }

    @Override
    public String toString() {
        return "BbookEnviaSize{" +
                "id='" + id + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", sizes='" + sizes + '\'' +
                ", inactive='" + inactive + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

