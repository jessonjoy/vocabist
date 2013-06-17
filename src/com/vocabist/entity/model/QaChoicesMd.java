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
@Table(name = "qa_choices_md")
@NamedQueries({
    @NamedQuery(name = "QaChoicesMd.findAll", query = "SELECT q FROM QaChoicesMd q"),
    @NamedQuery(name = "QaChoicesMd.findByQaChoicesId", query = "SELECT q FROM QaChoicesMd q WHERE q.qaChoicesId = :qaChoicesId"),
    @NamedQuery(name = "QaChoicesMd.findByChoices", query = "SELECT q FROM QaChoicesMd q WHERE q.choices = :choices"),
    @NamedQuery(name = "QaChoicesMd.findByActive", query = "SELECT q FROM QaChoicesMd q WHERE q.active = :active")})
public class QaChoicesMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_choices_id")
    private Integer qaChoicesId;
    @Size(max = 1000)
    @Column(name = "choices")
    private String choices;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "qa_question_id", referencedColumnName = "qa_question_id")
    @ManyToOne
    private QaQuestionMd qaQuestionId;

    public QaChoicesMd() {
    }

    public QaChoicesMd(Integer qaChoicesId) {
        this.qaChoicesId = qaChoicesId;
    }

    public Integer getQaChoicesId() {
        return qaChoicesId;
    }

    public void setQaChoicesId(Integer qaChoicesId) {
        this.qaChoicesId = qaChoicesId;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
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
        hash += (qaChoicesId != null ? qaChoicesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaChoicesMd)) {
            return false;
        }
        QaChoicesMd other = (QaChoicesMd) object;
        if ((this.qaChoicesId == null && other.qaChoicesId != null) || (this.qaChoicesId != null && !this.qaChoicesId.equals(other.qaChoicesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaChoicesMd[ qaChoicesId=" + qaChoicesId + " ]";
    }
    
}
