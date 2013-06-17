/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vocabist.entity.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "qa_answer_md")
@NamedQueries({
    @NamedQuery(name = "QaAnswerMd.findAll", query = "SELECT q FROM QaAnswerMd q"),
    @NamedQuery(name = "QaAnswerMd.findByQaAnswerId", query = "SELECT q FROM QaAnswerMd q WHERE q.qaAnswerId = :qaAnswerId"),
    @NamedQuery(name = "QaAnswerMd.findByAnswer", query = "SELECT q FROM QaAnswerMd q WHERE q.answer = :answer"),
    @NamedQuery(name = "QaAnswerMd.findByActive", query = "SELECT q FROM QaAnswerMd q WHERE q.active = :active")})
public class QaAnswerMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_answer_id")
    private Integer qaAnswerId;
    @Size(max = 1000)
    @Column(name = "answer")
    private String answer;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qaAnswerId")
    private Collection<QaAnswerExampleMd> qaAnswerExampleMdCollection;
    @JoinColumn(name = "qa_question_id", referencedColumnName = "qa_question_id")
    @ManyToOne
    private QaQuestionMd qaQuestionId;

    public QaAnswerMd() {
    }

    public QaAnswerMd(Integer qaAnswerId) {
        this.qaAnswerId = qaAnswerId;
    }

    public Integer getQaAnswerId() {
        return qaAnswerId;
    }

    public void setQaAnswerId(Integer qaAnswerId) {
        this.qaAnswerId = qaAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Collection<QaAnswerExampleMd> getQaAnswerExampleMdCollection() {
        return qaAnswerExampleMdCollection;
    }

    public void setQaAnswerExampleMdCollection(Collection<QaAnswerExampleMd> qaAnswerExampleMdCollection) {
        this.qaAnswerExampleMdCollection = qaAnswerExampleMdCollection;
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
        hash += (qaAnswerId != null ? qaAnswerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaAnswerMd)) {
            return false;
        }
        QaAnswerMd other = (QaAnswerMd) object;
        if ((this.qaAnswerId == null && other.qaAnswerId != null) || (this.qaAnswerId != null && !this.qaAnswerId.equals(other.qaAnswerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaAnswerMd[ qaAnswerId=" + qaAnswerId + " ]";
    }
    
}
