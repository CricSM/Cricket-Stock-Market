package com.cricket.stockmarket.service;

import com.cricket.stockmarketdatamodel.model.Category;
import com.cricket.stockmarketdatamodel.player.model.PlayerType;
import com.cricket.stockmarketdatamodel.player.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;


@Service
@RequiredArgsConstructor
public class T20ServiceImpl implements T20Service {

    @Override
    public void calculatePlayerInitialStockValue(Player player) {
        Map<Format, BigDecimal> formatWiseValueMap = new HashMap<>();

        BigDecimal value = BigDecimal.ZERO;

        //Currently for international teams, later we will add ipl and other tournaments also.
        for (PlayerTeamStats playerTeamStats : player.getTeamBasisStats()) {
            if (Team.INTERNATIONAL_TEAM_SET.contains(playerTeamStats.getTeam())) {
                for (PlayerStats playerStats : playerTeamStats.getPlayerStats()) {
                    if (Format.T20.equals(playerStats.getFormat())) {
                        value =  calculatePlayerStockValueForT20(playerStats, player.getPlayerType());
                        formatWiseValueMap.put(Format.T20, value);
                    }
                }
            }
        }

        createPlayerStock(formatWiseValueMap, player.getId());

    }

    private void createPlayerStock(Map<Format, BigDecimal> formatWiseValueMap, String id) {
        PlayerStock playerStock = new PlayerStock();
        playerStock.setId(id);
        playerStock.setNoOfStock(1000L);
        playerStock.setCurrentValue(formatWiseValueMap.get(Format.T20));
        playerStock.setNoOfStockLeft(1000L);
        playerStock.setDebutValue(formatWiseValueMap.get(Format.T20));
    }

    private BigDecimal calculatePlayerStockValueForT20(PlayerStats playerStats, PlayerType playerType) {

        Category category = null;

        if (PlayerType.BATSMAN.equals(playerType)) {
            category = getT20CategoriesForBatsman(playerStats);
        } else if (PlayerType.BOWLER.equals(playerType)) {
            category = getT20CategoryForBowler(playerStats);
        } else if (PlayerType.ALLROUNDER.equals(playerType)) {
            category = getT20CategoryForAllRounder(playerStats);
        }

        if (Objects.isNull(category)) {
            throw new RuntimeException("Category Undefined");
        }

        BigDecimal value = BigDecimal.ZERO;

        if (Category.CATEGORY_A.equals(category)) {
            value = BigDecimal.valueOf(80);
        } else if (Category.CATEGORY_B.equals(category)) {
            value = BigDecimal.valueOf(60);
        } else if (Category.CATEGORY_C.equals(category)) {
            value = BigDecimal.valueOf(40);
        }

        return value;
    }

    private Category getT20CategoriesForBatsman(PlayerStats playerStats) {
        Category category = null;
        if (playerStats.getBattingAverage() > 30.0 && playerStats.getBattingStrikeRate() > 130.0
                && playerStats.getMatchesPlayed() >= 50) {
            category = Category.CATEGORY_A;
        } else if (playerStats.getBattingAverage() <= 30.0 && playerStats.getBattingAverage() > 15.0
                && playerStats.getBattingStrikeRate() <= 130.0 && playerStats.getBattingStrikeRate() > 120
                && playerStats.getMatchesPlayed() < 50 && playerStats.getMatchesPlayed() >= 30) {
            category = Category.CATEGORY_B;
        } else if (playerStats.getBattingAverage() <= 15.0 && playerStats.getMatchesPlayed() <= 15
                && playerStats.getBattingStrikeRate() <= 120 && playerStats.getBattingStrikeRate() >= 100) {
            category = Category.CATEGORY_C;
        }

        return category;
    }

    private Category getT20CategoryForBowler(PlayerStats playerStats) {
        Category category = null;
        if (playerStats.getBowlingEconomy() < 7.0 && playerStats.getBowlingStrikeRate() < 20.0
                && playerStats.getMatchesPlayed() >= 50) {
            category = Category.CATEGORY_A;
        } else if (playerStats.getBowlingEconomy() >= 7.0 && playerStats.getBowlingEconomy() < 8.5
                && playerStats.getBowlingStrikeRate() >= 20.0 && playerStats.getBowlingStrikeRate() < 30.0
                && playerStats.getMatchesPlayed() < 50 && playerStats.getMatchesPlayed() >= 30) {
            category = Category.CATEGORY_B;
        } else if (playerStats.getBowlingEconomy() >= 8.5 && playerStats.getBowlingEconomy() < 11.0
                && playerStats.getMatchesPlayed() <= 15 && playerStats.getBowlingStrikeRate() >= 30
                && playerStats.getBowlingStrikeRate() <= 50) {
            category = Category.CATEGORY_C;
        }

        return category;
    }

    private Category getT20CategoryForAllRounder(PlayerStats playerStats) {
        Category batterCategory = getT20CategoriesForBatsman(playerStats);
        Category bowlerCategory = getT20CategoryForBowler(playerStats);

        if (Objects.isNull(batterCategory) || Objects.isNull(bowlerCategory)) {
            throw new RuntimeException("Either Batter or Bowler Category is not defined");
        }

        Category category = null;

        if ((Category.CATEGORY_A.equals(batterCategory) || Category.CATEGORY_B.equals(batterCategory))
                && (Category.CATEGORY_A.equals(bowlerCategory) || Category.CATEGORY_B.equals(bowlerCategory))) {
            category = Category.CATEGORY_A;
        } else if ((Category.CATEGORY_B.equals(batterCategory) && Category.CATEGORY_C.equals(bowlerCategory))
                || (Category.CATEGORY_C.equals(batterCategory) || Category.CATEGORY_B.equals(bowlerCategory))) {
            category = Category.CATEGORY_B;
        } else {
            category = Category.CATEGORY_C;
        }

        return category;
    }
}
