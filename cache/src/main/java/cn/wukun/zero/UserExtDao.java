package cn.wukun.zero;

import cn.wukun.domain.UserExt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExtDao extends JpaRepository<UserExt, Integer> {
    UserExt save(UserExt userExt);
}
