package model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.persistence.Table;

@Entity
public class LogModel 
{
	@Id
	private String Id;
	 @JsonIgnore
	private String name;
	private String LogType;
	private String date;
	private String time;
	
	public LogModel(String id, String name, String logType, String date, String time) 
	{
		super();
		this.Id = id;
		this.name = name;
		this.LogType = logType;
		this.date = date;
		this.time = time;
	}

	public LogModel() 
	{
		super();
	}

	public String getId() 
	{
		return Id;
	}

	public void setId(String id) 
	{
		this.Id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getLogType() 
	{
		return LogType;
	}

	public void setLogType(String logType) 
	{
		this.LogType = logType;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}
}
