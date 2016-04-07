/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByIdNotification", query = "SELECT n FROM Notification n WHERE n.idNotification = :idNotification"),
    @NamedQuery(name = "Notification.findByDestinateur", query = "SELECT n FROM Notification n WHERE n.destinateur = :destinateur"),
    @NamedQuery(name = "Notification.findByDestinataire", query = "SELECT n FROM Notification n WHERE n.destinataire = :destinataire"),
    @NamedQuery(name = "Notification.findByDateNotification", query = "SELECT n FROM Notification n WHERE n.dateNotification = :dateNotification")})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotification")
    private Integer idNotification;
    @Size(max = 350)
    @Column(name = "destinateur")
    private String destinateur;
    @Size(max = 350)
    @Column(name = "destinataire")
    private String destinataire;
    @Lob
    @Size(max = 16777215)
    @Column(name = "corpsMessage")
    private String corpsMessage;
    @Column(name = "dateNotification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNotification;
    @ManyToMany(mappedBy = "notificationList")
    private List<Candidat> candidatList;
    @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")
    @ManyToOne(optional = false)
    private Recruteur idRecruteur;

    public Notification() {
    }

    public Notification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getDestinateur() {
        return destinateur;
    }

    public void setDestinateur(String destinateur) {
        this.destinateur = destinateur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getCorpsMessage() {
        return corpsMessage;
    }

    public void setCorpsMessage(String corpsMessage) {
        this.corpsMessage = corpsMessage;
    }

    public Date getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    public Recruteur getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(Recruteur idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Notification[ idNotification=" + idNotification + " ]";
    }
    
}
