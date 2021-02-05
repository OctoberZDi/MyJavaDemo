package com.example.springbootdemotkmybatis.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CG_DATA_SOURCE")
public class CgDataSource {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DS_NAME")
    private String dsName;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "CREATOR_NAME")
    private String creatorName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DB_URL")
    private String dbUrl;

    @Column(name = "DB_TYPE")
    private String dbType;

    @Column(name = "DB_USERNAME")
    private String dbUsername;

    @Column(name = "DB_PASSWORD")
    private String dbPassword;

    @Column(name = "SCHEMA_NAME")
    private String schemaName;

    @Column(name = "REGISTRATION_CENTER_TYPE")
    private String registrationCenterType;

    @Column(name = "REGISTRATION_CENTER_ADDRESS")
    private String registrationCenterAddress;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return DS_NAME
     */
    public String getDsName() {
        return dsName;
    }

    /**
     * @param dsName
     */
    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return CREATOR_NAME
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return DB_URL
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * @param dbUrl
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /**
     * @return DB_TYPE
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * @param dbType
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * @return DB_USERNAME
     */
    public String getDbUsername() {
        return dbUsername;
    }

    /**
     * @param dbUsername
     */
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    /**
     * @return DB_PASSWORD
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * @param dbPassword
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    /**
     * @return SCHEMA_NAME
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * @param schemaName
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * @return REGISTRATION_CENTER_TYPE
     */
    public String getRegistrationCenterType() {
        return registrationCenterType;
    }

    /**
     * @param registrationCenterType
     */
    public void setRegistrationCenterType(String registrationCenterType) {
        this.registrationCenterType = registrationCenterType;
    }

    /**
     * @return REGISTRATION_CENTER_ADDRESS
     */
    public String getRegistrationCenterAddress() {
        return registrationCenterAddress;
    }

    /**
     * @param registrationCenterAddress
     */
    public void setRegistrationCenterAddress(String registrationCenterAddress) {
        this.registrationCenterAddress = registrationCenterAddress;
    }
}