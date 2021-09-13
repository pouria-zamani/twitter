package base.domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity<ID> {
    public static final String IS_DELETED = "is_deleted";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private ID id;

    @Column(name = IS_DELETED, columnDefinition = "TINYINT(1)")
    private Boolean isDeleted;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
