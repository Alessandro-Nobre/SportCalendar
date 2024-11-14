package com.sportradar.SportCalendar.dto.stage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StageSaveRequest {
        private String name;
        private int ordering;
}
