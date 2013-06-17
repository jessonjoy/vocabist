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
@Table(name = "qa_answer_example_md")
@NamedQueries({
    @NamedQuery(name = "QaAnswerExampleMd.findAll", query = "SELECT q FROM QaAnswerExampleMd q"),
    @NamedQuery(name = "QaAnswerExampleMd.findByQaExampleId", query = "SELECT q FROM QaAnswerExampleMd q WHERE q.qaExampleId = :qaExampleId"),
    @NamedQuery(name = "QaAnswerExampleMd.findByExample", query = "SELECT q FROM QaAnswerExampleMd q WHERE q.example = :example"),
    @NamedQuery(name = "QaAnswerExampleMd.findByActive", query = "SELECT q FROM QaAnswerExampleMd q WHERE q.active = :active")})
public class QaAnswerExampleMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_example_id")
    private Integer qaExampleId;
    @Size(max = 1000)
    @Column(name = "example")
    private String example;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "qa_answer_id", referencedColumnName = "qa_answer_id")
    @ManyToOne(optional = false)
    private QaAnswerMd qaAnswerId;

    public QaAnswerExampleMd() {
    }

    public QaAnswerExampleMd(Integer qaExampleId) {
        this.qaExampleId = qaExampleId;
    }

    public Integer getQaExampleId() {
        return qaExampleId;
    }

    public void setQaExampleId(Integer qaExampleId) {
        this.qaExampleId = qaExampleId;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public QaAnswerMd getQaAnswerId() {
        return qaAnswerId;
    }

    public void setQaAnswerId(QaAnswerMd qaAnswerId) {
        this.qaAnswerId = qaAnswerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qaExampleId != null ? qaExampleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaAnswerExampleMd)) {
            return false;
        }
        QaAnswerExampleMd other = (QaAnswerExampleMd) object;
        if ((this.qaExampleId == null && other.qaExampleId != null) || (this.qaExampleId != null && !this.qaExampleId.equals(other.qaExampleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaAnswerExampleMd[ qaExampleId=" + qaExampleId + " ]";
    }
    
}
