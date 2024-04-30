package com.easyfind.easyfindserver.modules.account.jpa.models;

import com.easyfind.easyfindserver.modules.account.dtos.CityDTO;
import com.easyfind.easyfindserver.modules.account.dtos.CreateCityDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_cities")
public class City implements Serializable {
    protected City() {}

    public City(CreateCityDTO createCityDTO, State state) {
        this.cityName = createCityDTO.city_name();
        this.cityState = state;
        this.cityCreatedAt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;

    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_state_id")
    private State cityState;

    private LocalDateTime cityCreatedAt;

    public CityDTO toCityDTO() {
        return new CityDTO(
                this.cityId,
                this.cityName,
                this.cityState.getStateId(),
                this.cityCreatedAt
        );
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getCityState() {
        return cityState;
    }

    public void setCityState(State cityState) {
        this.cityState = cityState;
    }

    public LocalDateTime getCityCreatedAt() {
        return cityCreatedAt;
    }

    public void setCityCreatedAt(LocalDateTime cityCreatedAt) {
        this.cityCreatedAt = cityCreatedAt;
    }
}
