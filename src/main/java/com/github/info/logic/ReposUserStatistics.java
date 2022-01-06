package com.github.info.logic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReposUserStatistics {
    private Repo[] reposList;
    private int allStars;
    private List<Entry<String, Integer>> languagesList;
}
