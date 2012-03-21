package com.SysAdmin.Entity;

import java.util.List;

public class HostEntity {
	
	private String hostName;	
	private Integer currentState;
	private List<ServiceEntity> services;
	
	public HostEntity(String _hostName, Integer _currentState, List<ServiceEntity> _services){
		this.hostName = _hostName;
		this.currentState = _currentState;
		this.services = _services;
	}
	
	public void AddService(ServiceEntity _newService){
		this.services.add(_newService);
	}
	
	public String getHostName(){
		return hostName;
	}
	public void setHostName(String _hostName){
		this.hostName = _hostName;
	}
	
	public Integer getCurrentState(){
		return currentState;
	}
	public void setCurrentState(Integer _state){
		this.currentState = _state;
	}
	
	public List<ServiceEntity> getServices(){
		return services;
	}
	public void setServices(List<ServiceEntity> _services){
		this.services = _services;
	}
}


