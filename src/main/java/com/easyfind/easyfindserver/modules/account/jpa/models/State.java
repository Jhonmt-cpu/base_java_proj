package com.easyfind.easyfindserver.modules.account.jpa.models;

import com.easyfind.easyfindserver.modules.account.dtos.CreateStateDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name="tb_states")
public class State implements Serializable {
    protected State() {}

    public State(CreateStateDTO createStateDTO) {
        this.stateName = createStateDTO.state_name();
        this.stateUf = createStateDTO.state_uf();
        this.stateCreatedAt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stateId;

    private String stateName;

    private String stateUf;

    @OneToMany(mappedBy= "cityState", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<City> stateCities;

    private LocalDateTime stateCreatedAt;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateUf() {
        return stateUf;
    }

    public void setStateUf(String stateUf) {
        this.stateUf = stateUf;
    }

    public Collection<City> getStateCities() {
        return stateCities;
    }

    public void setStateCities(Collection<City> stateCities) {
        this.stateCities = stateCities;
    }

    public LocalDateTime getStateCreatedAt() {
        return stateCreatedAt;
    }

    public void setStateCreatedAt(LocalDateTime stateCreatedAt) {
        this.stateCreatedAt = stateCreatedAt;
    }
}
