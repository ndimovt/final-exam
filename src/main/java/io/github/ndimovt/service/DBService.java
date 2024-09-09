package io.github.ndimovt.service;

import io.github.ndimovt.model.dto.LongestPlayingPairDto;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class DBService {
    private static final String STATEMENT = """
                    SELECT p.name, p.id, r.from_min, r.to_min, t.team_name
                    FROM record r
                    JOIN player p ON r.player_id = p.id
                    JOIN team t ON p.team_id = t.id;
                    """;
    public Map<Integer, LongestPlayingPairDto> unsortedResult(){
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
    public LinkedHashMap<Integer, LongestPlayingPairDto> sortedResult(Map<Integer, LongestPlayingPairDto> toSort){
        return toSort.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().getTotalPlayTime(), entry1.getValue().getTotalPlayTime()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
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
