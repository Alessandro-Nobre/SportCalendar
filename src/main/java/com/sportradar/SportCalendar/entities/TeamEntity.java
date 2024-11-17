package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "team")
public class TeamEntity {

    @Id
    @SequenceGenerator(
            name = "teamId_sequence",
            sequenceName = "teamId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teamhId_sequence"
    )
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
