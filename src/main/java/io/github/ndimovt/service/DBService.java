package io.github.ndimovt.service;

import io.github.ndimovt.model.dto.LongestPlayingPairDto;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Processing final result required by the app conditions
 */
@Service
public class DBService {
    private static final String STATEMENT = """
                    SELECT p.name, p.id, r.from_min, r.to_min, t.team_name
                    FROM record r
                    JOIN player p ON r.player_id = p.id
                    JOIN team t ON p.team_id = t.id;
                    """;

    /**
     * Gets the two longest participation players from different teams
     * @return List of LongestPlayingPairDto objects
     */
    public List<LongestPlayingPairDto> longestPlayingPlayers(){
        List<LongestPlayingPairDto> players = new ArrayList<>();
        LinkedHashMap<Integer, LongestPlayingPairDto> listOfRecords = sortedResult();
        LongestPlayingPairDto firstPlayer = null;
        LongestPlayingPairDto secondPlayer = null;

        for(Map.Entry<Integer, LongestPlayingPairDto> entry : listOfRecords.entrySet()){
            LongestPlayingPairDto currentPlayer = entry.getValue();
            if(firstPlayer == null){
                firstPlayer = currentPlayer;
                players.add(firstPlayer);
            } else if (!currentPlayer.getTeamName().equals(firstPlayer.getTeamName())) {
                secondPlayer = currentPlayer;
                players.add(secondPlayer);
                break;
            }
        }
        return players;
    }
    private LinkedHashMap<Integer, LongestPlayingPairDto> sortedResult(){
        return unsortedResult().entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().getTotalPlayTime(), entry1.getValue().getTotalPlayTime()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    private Map<Integer, LongestPlayingPairDto> unsortedResult(){
        Map<Integer, LongestPlayingPairDto> list = new TreeMap<>();
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/football_statistics", "postgres", "pass")){
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement(STATEMENT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int start = rs.getInt("from_min");
                String end = String.valueOf(rs.getString("to_min"));
                String teamName = rs.getString("team_name");

                int finalResult = nullToNumConvertor(end) - start;
                if(list.containsKey(id)){
                    LongestPlayingPairDto dto = list.get(id);
                    int updateValue = dto.getTotalPlayTime() + finalResult;
                    dto.setTotalPlayTime(updateValue);
                }else{
                    LongestPlayingPairDto longestPlayingPairDto = new LongestPlayingPairDto();
                    longestPlayingPairDto.setName(name);
                    longestPlayingPairDto.setTotalPlayTime(finalResult);
                    longestPlayingPairDto.setTeamName(teamName);
                    list.put(id, longestPlayingPairDto);
                }
            }
            closeConnection(rs, ps);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    private void closeConnection(ResultSet set, PreparedStatement statement) throws SQLException{
        if(set != null){
            set.close();
        }
        if(statement != null){
            statement.close();
        }
    }
    private int nullToNumConvertor(String record){
        if(record.equalsIgnoreCase("NULL")){
            return 90;
        }else{
            return Integer.parseInt(record);
        }
    }
}
