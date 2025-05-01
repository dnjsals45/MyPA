USE mypa;

-- Member 테이블 정의
CREATE TABLE IF NOT EXISTS member
(
    id               BIGINT         NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 ID',
    email            VARCHAR(255)   NOT NULL COMMENT '회원 이메일',
    social_type      VARCHAR(20)    NOT NULL COMMENT '소셜 로그인 타입',
    social_id        VARCHAR(100)   NOT NULL COMMENT '소셜 로그인 ID',
    created_at       DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at       DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    deleted_at       DATETIME       NULL COMMENT '삭제일'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='회원 테이블';