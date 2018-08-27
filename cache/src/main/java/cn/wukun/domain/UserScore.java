package cn.wukun.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_score")
public class UserScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_mobile")
    private String userMobile;

    @Column(name = "score_value")
    private Integer scoreValue;

    @Column(name = "create_time")
    private Timestamp createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(Integer scoreValue) {
        this.scoreValue = scoreValue;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserScore{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", scoreValue=" + scoreValue +
                ", createTime=" + createTime +
                '}';
    }
}
