package cn.wukun.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_ext")
public class UserExt {
    @Id
    @Column(name = "ext_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer extId;

    @Column(name = "ext_name")
    private String extName;

    @Column(name = "ext_age")
    private Integer extAge;

    public Integer getExtId() {
        return extId;
    }

    public void setExtId(Integer extId) {
        this.extId = extId;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public Integer getExtAge() {
        return extAge;
    }

    public void setExtAge(Integer extAge) {
        this.extAge = extAge;
    }
}
