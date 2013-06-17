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
import javax.persistence.Lob;
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
@Table(name = "qa_metadata_md")
@NamedQueries({
    @NamedQuery(name = "QaMetadataMd.findAll", query = "SELECT q FROM QaMetadataMd q"),
    @NamedQuery(name = "QaMetadataMd.findByQaMetadataId", query = "SELECT q FROM QaMetadataMd q WHERE q.qaMetadataId = :qaMetadataId"),
    @NamedQuery(name = "QaMetadataMd.findByActive", query = "SELECT q FROM QaMetadataMd q WHERE q.active = :active")})
public class QaMetadataMd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "qa_metadata_id")
    private Integer qaMetadataId;
    @Lob
    @Column(name = "metadata")
    private byte[] metadata;
    @Size(max = 1)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "qa_question_id", referencedColumnName = "qa_question_id")
    @ManyToOne
    private QaQuestionMd qaQuestionId;

    public QaMetadataMd() {
    }

    public QaMetadataMd(Integer qaMetadataId) {
        this.qaMetadataId = qaMetadataId;
    }

    public Integer getQaMetadataId() {
        return qaMetadataId;
    }

    public void setQaMetadataId(Integer qaMetadataId) {
        this.qaMetadataId = qaMetadataId;
    }

    public byte[] getMetadata() {
        return metadata;
    }

    public void setMetadata(byte[] metadata) {
        this.metadata = metadata;
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
        hash += (qaMetadataId != null ? qaMetadataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaMetadataMd)) {
            return false;
        }
        QaMetadataMd other = (QaMetadataMd) object;
        if ((this.qaMetadataId == null && other.qaMetadataId != null) || (this.qaMetadataId != null && !this.qaMetadataId.equals(other.qaMetadataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vocabist.entity.model.QaMetadataMd[ qaMetadataId=" + qaMetadataId + " ]";
    }
    
}
