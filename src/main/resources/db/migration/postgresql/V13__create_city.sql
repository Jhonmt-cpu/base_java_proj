CREATE TABLE tb_cities (
    city_id SERIAL PRIMARY KEY,
    city_name VARCHAR (60) NOT NULL,
    city_state_id SMALLINT NOT NULL REFERENCES tb_states (state_id),
    city_created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
