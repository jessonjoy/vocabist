/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vocabist.entity.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jn
 */
@Entity
@Table(name = "qa_type_md")
@NamedQueries({
    @NamedQuery(name = "QaTypeMd.findAll", query = "SELECT q FROM QaTypeMd q"),
    @NamedQuery(name = "QaTypeMd.findByQaTypeId", query = "SELECT q FROM QaTypeMd q WHERE q.qaTypeId = :qaTypeId"),
    @NamedQuery(name = "QaTypeMd.findByQaTypeShortCd", query = "SELECT q FROM QaTypeMd q WHERE q.qaTypeShortCd = :qaTypeShortCd"),
    @NamedQuery(name = "QaTypeMd.findByQaTypeCategory", query = "SELECT q FROM QaTypeMd q WHERE q.qaTypeCategory = :qaTypeCategory"),
    @NamedQuery(name = "QaTypeMd.findByQaTypeDesc", query = "SELECT q FROM QaTypeMd q WHERE q.qaTypeDesc = :qaTypeDesc"),
    @NamedQuery(name = "QaTypeMd.findByQaTypeInstructions", query = "SELECT q FROM QaTypeMd q WHERE q.qaTypeInstructions = :qaTypeInstructions"),
    @NamedQuery(name = "QaTypeMd.findByActive", query = "SELECT q FROM QaTypeMd q WHERE q.active = :active")})
public class QaTypeMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_type_id")
    private Integer qaTypeId;
    @Size(max = 45)
    @Column(name = "qa_type_short_cd")
    private String qaTypeShortCd;
    @Size(max = 45)
    @Column(name = "qa_type_category")
    private String qaTypeCategory;
    @Size(max = 200)
    @Column(name = "qa_type_desc")
    private String qaTypeDesc;
    @Size(max = 2000)
    @Column(name = "qa_type_instructions")
    private String qaTypeInstructions;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @OneToMany(mappedBy = "qaTypeId")
    private Collection<QaQuestionMd> qaQuestionMdCollection;

    public QaTypeMd() {
    }

    public QaTypeMd(Integer qaTypeId) {
        this.qaTypeId = qaTypeId;
    }

    public Integer getQaTypeId() {
        return qaTypeId;
    }

    public void setQaTypeId(Integer qaTypeId) {
        this.qaTypeId = qaTypeId;
    }

    public String getQaTypeShortCd() {
        return qaTypeShortCd;
    }

    public void setQaTypeShortCd(String qaTypeShortCd) {
        this.qaTypeShortCd = qaTypeShortCd;
    }

    public String getQaTypeCategory() {
        return qaTypeCategory;
    }

    public void setQaTypeCategory(String qaTypeCategory) {
        this.qaTypeCategory = qaTypeCategory;
    }

    public String getQaTypeDesc() {
        return qaTypeDesc;
    }

    public void setQaTypeDesc(String qaTypeDesc) {
        this.qaTypeDesc = qaTypeDesc;
    }

    public String getQaTypeInstructions() {
        return qaTypeInstructions;
    }

    public void setQaTypeInstructions(String qaTypeInstructions) {
        this.qaTypeInstructions = qaTypeInstructions;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Collection<QaQuestionMd> getQaQuestionMdCollection() {
        return qaQuestionMdCollection;
    }

    public void setQaQuestionMdCollection(Collection<QaQuestionMd> qaQuestionMdCollection) {
        this.qaQuestionMdCollection = qaQuestionMdCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qaTypeId != null ? qaTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaTypeMd)) {
            return false;
        }
        QaTypeMd other = (QaTypeMd) object;
        if ((this.qaTypeId == null && other.qaTypeId != null) || (this.qaTypeId != null && !this.qaTypeId.equals(other.qaTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaTypeMd[ qaTypeId=" + qaTypeId + " ]";
    }
    
}
