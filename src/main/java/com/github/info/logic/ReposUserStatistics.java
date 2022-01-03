package com.github.info.logic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReposUserStatistics {
    private Repo[] reposList;
    private int allStars;
}
