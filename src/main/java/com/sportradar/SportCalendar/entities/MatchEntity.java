package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "match")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    @Column()
    private int season;

    @Column()
    private String status;

    @Column()
    private LocalDateTime dateTime;

    @Column()
    private String stadium;

    @Column()
    private String matchGroup;

    @Column()
    private String originCompetitionId;

    @Column()
    private String originCompetitionName;

    @Column()
    private Timestamp created_at;

    @ManyToOne()
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;

    @ManyToOne()
    @JoinColumn(name = "away_team_id")
    private TeamEntity awayTeam;

    @OneToOne()
    @JoinColumn(name = "result_id")
    private ResultEntity resultEntity;

    @OneToOne()
    @JoinColumn(name = "stage_id")
    private StageEntity stageEntity;

    @Override
    public String toString() {
        return "MatchEntity{" +
                "matchId=" + matchId +
                ", season='" + season + '\'' +
                ", status='" + status + '\'' +
                ", dateTime=" + dateTime +
                ", stadium='" + stadium + '\'' +
                ", matchGroup='" + matchGroup + '\'' +
                ", originCompetitionId='" + originCompetitionId + '\'' +
                ", originCompetitionName='" + originCompetitionName + '\'' +
                ", created_at=" + created_at +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", resultEntity=" + resultEntity +
                ", stageEntity=" + stageEntity +
                '}';
    }
}
