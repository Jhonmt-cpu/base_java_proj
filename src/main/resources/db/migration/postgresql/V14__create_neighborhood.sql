CREATE TABLE tb_neighborhoods (
    neighborhood_id SERIAL PRIMARY KEY,
    neighborhood_name VARCHAR (60) NOT NULL,
    neighborhood_city_id INTEGER NOT NULL REFERENCES tb_cities (city_id),
    neighborhood_created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);