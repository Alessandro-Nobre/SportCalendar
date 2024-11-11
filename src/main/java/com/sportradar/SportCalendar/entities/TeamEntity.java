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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column()
    private String name;

    @Column()
    private String status;

    @Column()
    private String officialName;

    @Column()
    private String slug;

    @Column()
    private String abbreviation;

    @Column()
    private String stagePosition;

    @Column()
    private int playersId;

    @Override
    public String toString() {
        return "TeamEntity{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", officialName='" + officialName + '\'' +
                ", slug='" + slug + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", stagePosition='" + stagePosition + '\'' +
                ", playersId=" + playersId +
                '}';
    }


}
