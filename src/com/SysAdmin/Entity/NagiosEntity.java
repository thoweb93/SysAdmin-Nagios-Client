package com.SysAdmin.Entity;

import java.util.List;

public class NagiosEntity {
	private String name;
	private String url;
	private List<HostEntity> hostList;
	
	public NagiosEntity(String _name, String _url, List<HostEntity> _hostList){
		this.setName(_name);
		this.setUrl(_url);
		this.setHostList(_hostList);
	}
	
	public void AddHostList(HostEntity _newHost){
		this.hostList.add(_newHost);
	}
	
	public String getName(){
		return name;
	}
	public void setName(String _name){
		this.name = _name;
	}
	
	public String getUrl(){
		return url;
	}
	public void setUrl(String _url){
		this.url = _url;
	}
	
	public List<HostEntity> getHostList(){
		return hostList;
	}
	public void setHostList(List<HostEntity> _hostList){
		this.hostList = _hostList;
	}
}
