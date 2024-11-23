package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TeamEntity homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TeamEntity awayTeam;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", referencedColumnName = "resultId")
    private ResultEntity resultEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id", referencedColumnName = "stageId")
    private StageEntity stageEntity;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

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
                ", created_at=" + createdAt +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", resultEntity=" + resultEntity +
                ", stageEntity=" + stageEntity +
                '}';
    }
}
