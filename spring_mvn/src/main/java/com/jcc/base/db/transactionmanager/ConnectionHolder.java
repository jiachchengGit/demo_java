/**
 * 
 */
/*
 * @(#) demo DD.java Aug 16, 2013
 *
 * Copyright 2013 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base.db.transactionmanager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
            
public class ConnectionHolder
{
    private Map<DataSource, Connection> connectionMap = new HashMap<DataSource, Connection>();
            
    public Connection getConnection(DataSource dataSource) throws SQLException
    {
        Connection connection = connectionMap.get(dataSource);
        if (connection == null || connection.isClosed())
        {
            connection = dataSource.getConnection();
            connectionMap.put(dataSource, connection);
        }
            
        return connection;
    }
            
    public void removeConnection(DataSource dataSource)
    {
        connectionMap.remove(dataSource);
    }
}