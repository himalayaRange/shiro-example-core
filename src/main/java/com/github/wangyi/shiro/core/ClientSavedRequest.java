package com.github.wangyi.shiro.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.SavedRequest;

/**
 * 扩展了SavedRequest:
 * 
 * 场景：当需要保存某些需要登录的请求时，自动把请求保存下来，重定向到服务器端进行登录再回来，
 * 		默认不保存schema://domain:port部分，登录成功后不能重定向到指定的应用上，所以需要拓展schema://domain:port
 * 
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */
public class ClientSavedRequest extends SavedRequest {

	private static final long serialVersionUID = 7325975909713772178L;

	private String schema;//协议
	
	private String domain;//IP
	
	private int port;//端口
	
	private String contextpath;//上下文
	
	private String backurl;//服务回调地址
	
	
	
	public String getSchema() {
		return schema;
	}


	public String getDomain() {
		return domain;
	}


	public int getPort() {
		return port;
	}


	public String getContextpath() {
		return contextpath;
	}


	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}


	public ClientSavedRequest(HttpServletRequest request,  String backurl) {
		super(request);
		this.schema = request.getScheme();
		this.domain = request.getServerName();
		this.port = request.getServerPort();
		this.backurl = backurl;
		this.contextpath = request.getContextPath();
	}


	public ClientSavedRequest(HttpServletRequest request) {
		super(request);
	}
	
	/**
	 * 获取请求地址
	 */
	public String getRequestUrl(){
		String requestURI=getRequestURI();
		if(backurl!=null){
			if(backurl.toLowerCase().startsWith("http://") || backurl.toLowerCase().startsWith("https://")){
				return backurl;
			}else if(!backurl.startsWith(contextpath)){
				requestURI=contextpath+backurl;
			}else{
				requestURI=backurl;
			}
		}
		
		StringBuilder requestUrl = new StringBuilder(schema);
		requestUrl.append("://");
		requestUrl.append(domain);
		
		if("http".equalsIgnoreCase(schema)&&port!=80){
			requestUrl.append(":").append(String.valueOf(port));
		}else if("https".equalsIgnoreCase(schema)&&port!=443){
			requestUrl.append(":").append(String.valueOf(port));
		}
		
		requestUrl.append(requestURI);
		
		if(backurl!=null && getQueryString()!=null){
			requestUrl.append("?").append(getQueryString());
		}
		
		return requestUrl.toString();
	}

}
