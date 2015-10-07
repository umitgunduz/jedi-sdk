/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.sdk.metadata.test;

import com.jedi.sdk.metadata.ColumnMetadata;
import com.jedi.sdk.metadata.DatabaseMetadataUtil;
import com.jedi.sdk.metadata.PackageMetadata;
import com.jedi.sdk.metadata.ProcedureMetadata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author umit
 */
public class DatabaseMetadataUtilTest {

    static Connection connection;

    public DatabaseMetadataUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMetadataUtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:oracle:thin:@//192.168.99.100:49161/xe";

        try {
            connection = DriverManager.getConnection(url, "hr", "hr");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMetadataUtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getPackagesTest() throws SQLException {
        List<PackageMetadata> data = DatabaseMetadataUtil.getPackages(connection);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    public void getStoredProceduresTest() throws SQLException {
        List<ProcedureMetadata> data = DatabaseMetadataUtil.getProcedures(connection);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    public void getStoredProceduresWithPackageTest() throws SQLException {
        PackageMetadata packageMetadata = new PackageMetadata();
        packageMetadata.setName("EMP_MGMT");
        List<ProcedureMetadata> data = DatabaseMetadataUtil.getProcedures(connection, packageMetadata);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    public void getProcedureColumnsTest() throws SQLException {
        List<ColumnMetadata> data = DatabaseMetadataUtil.getProcedureColumns(connection, "INCREASE_SAL2");
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }
}
