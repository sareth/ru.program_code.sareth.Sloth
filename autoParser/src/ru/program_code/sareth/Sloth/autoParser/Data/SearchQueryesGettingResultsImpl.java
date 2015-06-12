package ru.program_code.sareth.Sloth.autoParser.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SearchQueryesGettingResultsImpl implements SearchQueryesGettingResultsIface {
	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;
	private String stringQuery = 	"SELECT sitequeryes.Id as Id, sites.ID as siteID, sites.URL as Url, queryes.ID as queryID, "+
									"queryes.Text as Text, languages.Value as LangID, languages.Name as LangName, regions.Value as RegionID, " +
									"regions.Name as RegionName, searchsystems.Value as SearchSystem, searchsystems.Name as SearchSystemName " +
									"FROM Positions.sitequeryes INNER JOIN sites ON sitequeryes.site = sites.ID " +
									"INNER JOIN queryes " +
									"ON (sitequeryes.query = queryes.id) " +
									"INNER JOIN regions " +
									"ON (sitequeryes.region = regions.id) " +
									"INNER JOIN languages " +
									"ON (sitequeryes.lang = languages.id) " +
									"INNER JOIN searchsystems " +
									"ON (sitequeryes.searchsystem = searchsystems.id) ";
	
	@Override
	public List<SearchQueryesModelClass> getAll() throws SQLException {
		List<SearchQueryesModelClass> result= new LinkedList<SearchQueryesModelClass>();
		
		String selectSQL =	stringQuery +
							"ON (sitequeryes.searchsystem = searchsystems.id)";
	 
			try {
				
				new Connector();
				dbConnection = Connector.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(selectSQL);
				//preparedStatement.setInt(1, 1001);
	 
				// execute select SQL stetement
				ResultSet rs = preparedStatement.executeQuery();
	 
				while (rs.next()) {
					result.add(new SearchQueryesModelClass(rs.getInt("Id"), rs.getInt("siteID"), 
							rs.getString("Url"), rs.getInt("queryID"), rs.getString("Text"),
							rs.getInt("LangID"), rs.getString("LangName"), rs.getInt("RegionID"),
							rs.getString("RegionName"), rs.getInt("SearchSystem"), 
							rs.getString("SearchSystemName"))
					);
				}
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			} finally {
	 
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
	 
			}
	 
		
		if (result.isEmpty()) return null;
		
		return result;
	}

	@Override
	public SearchQueryesModelClass getElementById(int id) throws SQLException {
		SearchQueryesModelClass result;
		String selectSQL =	stringQuery +
							"WHERE sitequeryes.id= " + id;
	 
			try {
				
				new Connector();
				dbConnection = Connector.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(selectSQL);
				//preparedStatement.setInt(1, 1001);
	 
				// execute select SQL stetement
				ResultSet rs = preparedStatement.executeQuery();
	 
				while (rs.next()) {
					result  = new SearchQueryesModelClass(rs.getInt("Id"), rs.getInt("siteID"), 
							rs.getString("Url"), rs.getInt("queryID"), rs.getString("Text"),
							rs.getInt("LangID"), rs.getString("LangName"), rs.getInt("RegionID"),
							rs.getString("RegionName"), rs.getInt("SearchSystem"), 
							rs.getString("SearchSystemName"));
					
					return result;
				}
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			} finally {
	 
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
	 
			}
	 
		
		
		return null;
	}

	@Override
	public List<SearchQueryesModelClass> getElementsWhereEveryDay() throws SQLException {
		List<SearchQueryesModelClass> result= new LinkedList<SearchQueryesModelClass>();
		
		String selectSQL =	stringQuery +
							"WHERE sitequeryes.everyday=1";
	 
			try {
				
				new Connector();
				dbConnection = Connector.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(selectSQL);
				//preparedStatement.setInt(1, 1001);
	 
				// execute select SQL stetement
				ResultSet rs = preparedStatement.executeQuery();
	 
				while (rs.next()) {
					
					result.add(new SearchQueryesModelClass(rs.getInt("Id"), rs.getInt("siteID"), 
							rs.getString("Url"), rs.getInt("queryID"), rs.getString("Text"),
							rs.getInt("LangID"), rs.getString("LangName"), rs.getInt("RegionID"),
							rs.getString("RegionName"), rs.getInt("SearchSystem"), 
							rs.getString("SearchSystemName"))
					);
					
					
				}
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			} finally {
	 
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
	 
			}
	 
		
		if (result.isEmpty()) return null;
		
		return result;
	}

	@Override
	public List<SearchQueryesModelClass> getElementsWhereEveryWeek() throws SQLException {
		List<SearchQueryesModelClass> result= new LinkedList<SearchQueryesModelClass>();
		
		String selectSQL =	stringQuery +
							"WHERE sitequeryes.everyweek=1";
	 
			try {
				
				new Connector();
				dbConnection = Connector.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(selectSQL);
				//preparedStatement.setInt(1, 1001);
	 
				// execute select SQL stetement
				ResultSet rs = preparedStatement.executeQuery();
	 
				while (rs.next()) {
					result.add(new SearchQueryesModelClass(rs.getInt("Id"), rs.getInt("siteID"), 
							rs.getString("Url"), rs.getInt("queryID"), rs.getString("Text"),
							rs.getInt("LangID"), rs.getString("LangName"), rs.getInt("RegionID"),
							rs.getString("RegionName"), rs.getInt("SearchSystem"), 
							rs.getString("SearchSystemName"))
					);
					
				}
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			} finally {
	 
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
	 
			}
	 
		
		if (result.isEmpty()) return null;
		
		return result;
	}

	@Override
	public List<SearchQueryesModelClass> getElementsWhereEveryMonth() throws SQLException {
		List<SearchQueryesModelClass> result= new LinkedList<SearchQueryesModelClass>();
		
		String selectSQL =	stringQuery +
							"WHERE sitequeryes.everymonth=1";
	 
			try {
				
				new Connector();
				dbConnection = Connector.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(selectSQL);
				//preparedStatement.setInt(1, 1001);
	 
				// execute select SQL stetement
				ResultSet rs = preparedStatement.executeQuery();
	 
				while (rs.next()) {
					result.add(new SearchQueryesModelClass(rs.getInt("Id"), rs.getInt("siteID"), 
							rs.getString("Url"), rs.getInt("queryID"), rs.getString("Text"),
							rs.getInt("LangID"), rs.getString("LangName"), rs.getInt("RegionID"),
							rs.getString("RegionName"), rs.getInt("SearchSystem"), 
							rs.getString("SearchSystemName"))
					);
					
				}
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			} finally {
	 
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
	 
			}
	 
		
		if (result.isEmpty()) return null;
		
		return result;
	}

}
