/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vocabist.entity.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jn
 */
@Entity
@Table(name = "qa_ext_attrib_md")
@NamedQueries({
    @NamedQuery(name = "QaExtAttribMd.findAll", query = "SELECT q FROM QaExtAttribMd q"),
    @NamedQuery(name = "QaExtAttribMd.findByQaExtAttrId", query = "SELECT q FROM QaExtAttribMd q WHERE q.qaExtAttrId = :qaExtAttrId"),
    @NamedQuery(name = "QaExtAttribMd.findByExtAttrType", query = "SELECT q FROM QaExtAttribMd q WHERE q.extAttrType = :extAttrType"),
    @NamedQuery(name = "QaExtAttribMd.findByExtAttrName", query = "SELECT q FROM QaExtAttribMd q WHERE q.extAttrName = :extAttrName"),
    @NamedQuery(name = "QaExtAttribMd.findByExtAttrValue", query = "SELECT q FROM QaExtAttribMd q WHERE q.extAttrValue = :extAttrValue"),
    @NamedQuery(name = "QaExtAttribMd.findByActive", query = "SELECT q FROM QaExtAttribMd q WHERE q.active = :active")})
public class QaExtAttribMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_ext_attr_id")
    private Integer qaExtAttrId;
    @Size(max = 25)
    @Column(name = "ext_attr_type")
    private String extAttrType;
    @Size(max = 25)
    @Column(name = "ext_attr_name")
    private String extAttrName;
    @Size(max = 25)
    @Column(name = "ext_attr_value")
    private String extAttrValue;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "qa_question_id", referencedColumnName = "qa_question_id")
    @ManyToOne
    private QaQuestionMd qaQuestionId;

    public QaExtAttribMd() {
    }

    public QaExtAttribMd(Integer qaExtAttrId) {
        this.qaExtAttrId = qaExtAttrId;
    }

    public Integer getQaExtAttrId() {
        return qaExtAttrId;
    }

    public void setQaExtAttrId(Integer qaExtAttrId) {
        this.qaExtAttrId = qaExtAttrId;
    }

    public String getExtAttrType() {
        return extAttrType;
    }

    public void setExtAttrType(String extAttrType) {
        this.extAttrType = extAttrType;
    }

    public String getExtAttrName() {
        return extAttrName;
    }

    public void setExtAttrName(String extAttrName) {
        this.extAttrName = extAttrName;
    }

    public String getExtAttrValue() {
        return extAttrValue;
    }

    public void setExtAttrValue(String extAttrValue) {
        this.extAttrValue = extAttrValue;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public QaQuestionMd getQaQuestionId() {
        return qaQuestionId;
    }

    public void setQaQuestionId(QaQuestionMd qaQuestionId) {
        this.qaQuestionId = qaQuestionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qaExtAttrId != null ? qaExtAttrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaExtAttribMd)) {
            return false;
        }
        QaExtAttribMd other = (QaExtAttribMd) object;
        if ((this.qaExtAttrId == null && other.qaExtAttrId != null) || (this.qaExtAttrId != null && !this.qaExtAttrId.equals(other.qaExtAttrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaExtAttribMd[ qaExtAttrId=" + qaExtAttrId + " ]";
    }
    
}
