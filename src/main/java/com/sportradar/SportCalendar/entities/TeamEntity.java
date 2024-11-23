package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column()
    private String name;

    @Column()
    private String officialName;

    @Column()
    private String slug;

    @Column()
    private String abbreviation;

    @Column()
    private  String teamCountryCode;

    @Column()
    private String stagePosition;

    @OneToMany(mappedBy = "homeTeam")
    private List<MatchEntity> homeMatches;

    @OneToMany(mappedBy = "awayTeam")
    private List<MatchEntity> awayMatches;

    @Override
    public String toString() {
        return "TeamEntity{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", officialName='" + officialName + '\'' +
                ", slug='" + slug + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", teamCountryCode='" + teamCountryCode + '\'' +
                ", stagePosition='" + stagePosition + '\'' +
                '}';
    }


}
