package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class JpaBaseEntity {

    @Column(updatable = false) //컬럼 값 변경 못하게 셋팅
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist //persist 하기 전에 실행
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now; //초기값 셋팅(쿼리에 null 들어가는 것 비 권장)
    }

}
