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
@Table(name = "qa_hints_md")
@NamedQueries({
    @NamedQuery(name = "QaHintsMd.findAll", query = "SELECT q FROM QaHintsMd q"),
    @NamedQuery(name = "QaHintsMd.findByQaHintId", query = "SELECT q FROM QaHintsMd q WHERE q.qaHintId = :qaHintId"),
    @NamedQuery(name = "QaHintsMd.findByHint", query = "SELECT q FROM QaHintsMd q WHERE q.hint = :hint"),
    @NamedQuery(name = "QaHintsMd.findByActive", query = "SELECT q FROM QaHintsMd q WHERE q.active = :active")})
public class QaHintsMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_hint_id")
    private Integer qaHintId;
    @Size(max = 1000)
    @Column(name = "hint")
    private String hint;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "qa_question_id", referencedColumnName = "qa_question_id")
    @ManyToOne
    private QaQuestionMd qaQuestionId;

    public QaHintsMd() {
    }

    public QaHintsMd(Integer qaHintId) {
        this.qaHintId = qaHintId;
    }

    public Integer getQaHintId() {
        return qaHintId;
    }

    public void setQaHintId(Integer qaHintId) {
        this.qaHintId = qaHintId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
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
        hash += (qaHintId != null ? qaHintId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaHintsMd)) {
            return false;
        }
        QaHintsMd other = (QaHintsMd) object;
        if ((this.qaHintId == null && other.qaHintId != null) || (this.qaHintId != null && !this.qaHintId.equals(other.qaHintId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaHintsMd[ qaHintId=" + qaHintId + " ]";
    }
    
}
