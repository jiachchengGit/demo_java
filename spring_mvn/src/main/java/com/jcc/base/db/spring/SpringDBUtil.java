/*
 * @(#) dpm DBUtil.java Jan 20, 2011
 * 
 * Copyright 2011 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base.db.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.web.context.ContextLoader;

/**
 * <p>
 * Title: DBUtil.java
 * </p>
 * <p>
 * Description: 数据库相关工具类，主要用于获取SqlSession
 * </p>
 * <p>
 * Copyright:Copyright(c)2013
 * </p>
 * <p>
 * Company: 成都四方
 * </p>
 * <p>
 * CreateTime:2013-6-4 下午2:43:57
 * </p>
 * 
 * @author liushuai
 * @version 1.0
 **/
public class SpringDBUtil {

	private static SqlSessionFactory sessionFactory;
	private static ThreadLocal<Set<SqlSession>> bindedSessions = new ThreadLocal<Set<SqlSession>>();
	private static Logger log = Logger.getLogger(SpringDBUtil.class);
	/**
	 * 获取一个普通SqlSession， 该SqlSession不会自动提交当前事务
	 * 
	 * @author liushuai
	 * @creaetime 2013-6-4 下午2:48:27
	 * @return
	 */
	public static SqlSession getSession() {
		SqlSession session = null;
		if (sessionFactory == null) {
			try {
				sessionFactory = ContextLoader
						.getCurrentWebApplicationContext()
						.getBean(SqlSessionFactoryBean.class).getObject();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		session = sessionFactory.openSession(ExecutorType.BATCH);
		Set<SqlSession> sessions = bindedSessions.get();
		if (sessions == null) {
			sessions = new HashSet<SqlSession>();
			bindedSessions.set(sessions);
		}
		sessions.add(session);
		return (SqlSession) Proxy.newProxyInstance(Thread.currentThread()
				.getContextClassLoader(), new Class[] { SqlSession.class },
				new SqlSessionDelegate(session));
	}
	
	/**
	 * 强制关闭session所有session
	 * @author chenjiacheng
	 * @creaetime Jan 3, 2014 11:38:31 AM
	 * @return
	 */
	public static boolean forceCloseSqlSessions() {
		Set<SqlSession> sessions = bindedSessions.get();
		if (sessions == null)
			return true;
		for(SqlSession session : sessions) {
			try {
				session.close();
			}
			catch(Exception e){
			}
		}
		bindedSessions.set(null);
		return sessions.size() == 0;
	}

	/**
	 * 代理类，针对每个代理对象的调用前后做处理
	 * <p>Title: DBUtil.java</p>
	 * <p>Description: </p>
	 * <p>Copyright:Copyright(c)2014</p>
	 * <p>Company: 成都四方</p>
	 * <p>CreateTime:Jan 3, 2014 11:37:07 AM</p>
	 * @author chenjiacheng
	 * @version 1.0
	 **/
	private static class SqlSessionDelegate implements InvocationHandler {
		private final SqlSession session;

		public SqlSessionDelegate(SqlSession session) {
			this.session = session;
		}

		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			final boolean isClose = "close".equals(method.getName());
			try {
				return method.invoke(session, args);
			} catch (Throwable t) {
				if (isClose) {
					log.error("Close session faild!!!");
				}
				throw t;
			} finally {
				if (isClose) {
					Set<SqlSession> sessions = bindedSessions.get();
					if (sessions != null){
						sessions.remove(session);
					}
				}
			}
		}
	}
}
