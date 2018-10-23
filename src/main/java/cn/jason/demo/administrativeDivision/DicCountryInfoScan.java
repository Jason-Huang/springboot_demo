package cn.jason.demo.administrativeDivision;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lij-jiang
 * @ClassName: DicCountryInfoScan.java
 * @Description: 一码付添加区县表
 * @date 2017年06月21日 15:40
 */
@Entity
@Table(name = "DIC_COUNTRY_INFO_SCAN")
public class DicCountryInfoScan implements Serializable {

    private static final long serialVersionUID = 1230891609880471003L;

    @Id
    @Column(name="SQ", unique=true, nullable=false)
    private Long sq;
    @Column(name="CODE")
    private String code;
    @Column(name="CITY_CODE")
    private String cityCode;
    @Column(name="NAME")
    private String name;
    @Column(name="REMARK1")
    private String remark1;
    @Column(name="REMARK2")
    private String remark2;
    @Column(name="REMARK3")
    private String remark3;
    @Column(name="REMARK4")
    private String remark4;
    @Column(name="REMARK5")
    private String remark5;
    @Column(name="DEL_FLAG")
    private Integer delFlag;
    @Column(name="CREATED_TS")
    private Date createdTs;
    @Column(name="LAST_UPD_TS")
    private Date lastUpdTs;
    @Column(name="LAST_UPD_TRANCODE")
    private String lastUpdTranCode;

    public Long getSq() {
        return sq;
    }

    public void setSq(Long sq) {
        this.sq = sq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public Date getLastUpdTs() {
        return lastUpdTs;
    }

    public void setLastUpdTs(Date lastUpdTs) {
        this.lastUpdTs = lastUpdTs;
    }

    public String getLastUpdTranCode() {
        return lastUpdTranCode;
    }

    public void setLastUpdTranCode(String lastUpdTranCode) {
        this.lastUpdTranCode = lastUpdTranCode;
    }
}