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
@Table(name = "qa_question_md")
@NamedQueries({
    @NamedQuery(name = "QaQuestionMd.findAll", query = "SELECT q FROM QaQuestionMd q"),
    @NamedQuery(name = "QaQuestionMd.findByQaQuestionId", query = "SELECT q FROM QaQuestionMd q WHERE q.qaQuestionId = :qaQuestionId"),
    @NamedQuery(name = "QaQuestionMd.findByQuestion", query = "SELECT q FROM QaQuestionMd q WHERE q.question = :question"),
    @NamedQuery(name = "QaQuestionMd.findByActive", query = "SELECT q FROM QaQuestionMd q WHERE q.active = :active")})
public class QaQuestionMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_question_id")
    private Integer qaQuestionId;
    @Size(max = 250)
    @Column(name = "question")
    private String question;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @OneToMany(mappedBy = "qaQuestionId")
    private Collection<QaChoicesMd> qaChoicesMdCollection;
    @OneToMany(mappedBy = "qaQuestionId")
    private Collection<QaExtAttribMd> qaExtAttribMdCollection;
    @OneToMany(mappedBy = "qaQuestionId")
    private Collection<QaHintsMd> qaHintsMdCollection;
    @OneToMany(mappedBy = "qaQuestionId")
    private Collection<QaAnswerMd> qaAnswerMdCollection;
    @JoinColumn(name = "qa_type_id", referencedColumnName = "qa_type_id")
    @ManyToOne
    private QaTypeMd qaTypeId;
    @OneToMany(mappedBy = "qaQuestionId")
    private Collection<QaMetadataMd> qaMetadataMdCollection;

    public QaQuestionMd() {
    }

    public QaQuestionMd(Integer qaQuestionId) {
        this.qaQuestionId = qaQuestionId;
    }

    public Integer getQaQuestionId() {
        return qaQuestionId;
    }

    public void setQaQuestionId(Integer qaQuestionId) {
        this.qaQuestionId = qaQuestionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Collection<QaChoicesMd> getQaChoicesMdCollection() {
        return qaChoicesMdCollection;
    }

    public void setQaChoicesMdCollection(Collection<QaChoicesMd> qaChoicesMdCollection) {
        this.qaChoicesMdCollection = qaChoicesMdCollection;
    }

    public Collection<QaExtAttribMd> getQaExtAttribMdCollection() {
        return qaExtAttribMdCollection;
    }

    public void setQaExtAttribMdCollection(Collection<QaExtAttribMd> qaExtAttribMdCollection) {
        this.qaExtAttribMdCollection = qaExtAttribMdCollection;
    }

    public Collection<QaHintsMd> getQaHintsMdCollection() {
        return qaHintsMdCollection;
    }

    public void setQaHintsMdCollection(Collection<QaHintsMd> qaHintsMdCollection) {
        this.qaHintsMdCollection = qaHintsMdCollection;
    }

    public Collection<QaAnswerMd> getQaAnswerMdCollection() {
        return qaAnswerMdCollection;
    }

    public void setQaAnswerMdCollection(Collection<QaAnswerMd> qaAnswerMdCollection) {
        this.qaAnswerMdCollection = qaAnswerMdCollection;
    }

    public QaTypeMd getQaTypeId() {
        return qaTypeId;
    }

    public void setQaTypeId(QaTypeMd qaTypeId) {
        this.qaTypeId = qaTypeId;
    }

    public Collection<QaMetadataMd> getQaMetadataMdCollection() {
        return qaMetadataMdCollection;
    }

    public void setQaMetadataMdCollection(Collection<QaMetadataMd> qaMetadataMdCollection) {
        this.qaMetadataMdCollection = qaMetadataMdCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qaQuestionId != null ? qaQuestionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaQuestionMd)) {
            return false;
        }
        QaQuestionMd other = (QaQuestionMd) object;
        if ((this.qaQuestionId == null && other.qaQuestionId != null) || (this.qaQuestionId != null && !this.qaQuestionId.equals(other.qaQuestionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaQuestionMd[ qaQuestionId=" + qaQuestionId + " ]";
    }
    
}
