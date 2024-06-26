CREATE TABLE tb_users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    user_email VARCHAR(250) NOT NULL UNIQUE,
    user_cpf BIGINT NOT NULL UNIQUE,
    user_birth_date DATE NOT NULL,
    user_password VARCHAR NOT NULL,
    user_gender_id SMALLINT NOT NULL REFERENCES tb_genders(gender_id),
    user_role_id SMALLINT NOT NULL REFERENCES tb_roles(role_id) ON UPDATE CASCADE,
    user_created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);