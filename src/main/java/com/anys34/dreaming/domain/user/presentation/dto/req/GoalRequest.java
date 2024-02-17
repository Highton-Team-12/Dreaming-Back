package com.anys34.dreaming.domain.user.presentation.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoalRequest {
    @NotNull(message = "목표가 비어있습니다.")
    private String goal;
}
