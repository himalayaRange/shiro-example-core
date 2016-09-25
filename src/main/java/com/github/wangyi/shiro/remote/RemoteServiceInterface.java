package com.github.wangyi.shiro.remote;

import java.io.Serializable;

import org.apache.shiro.session.Session;

/**
 * 远程服务接口 <客户端---用户/权限服务器>
 * Client调用core,Server端实现core
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */

public interface RemoteServiceInterface {

	/**
	 * 根据应用KEY,sessionID获取当前会话
	 * @param appKey
	 * @param sessionId
	 * @return
	 */
	public Session getSession(String appKey, Serializable sessionId) ;
	
	
	/**
	 *创建会话
	 * @param session
	 * @return
	 */
	public Serializable createSession(Session session);
	
	
	/**
	 * 根据应用KEY,Session更新会话
	 * @param appKey
	 * @param session
	 */
	public void updateSession(String appKey,Session session);
	
	
	/**
	 * 根据appKey,Session删除对应应用上的会话
	 * @param appKey
	 * @param session
	 */
	public void deleteSession(String appKey,Session session);
	
	
}
