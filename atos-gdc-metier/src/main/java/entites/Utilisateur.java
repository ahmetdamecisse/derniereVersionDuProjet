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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateur.findByLocalisation", query = "SELECT u FROM Utilisateur u WHERE u.localisation = :localisation"),
    @NamedQuery(name = "Utilisateur.findByMail", query = "SELECT u FROM Utilisateur u WHERE u.mail = :mail"),
    @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateur.findBySpecialite", query = "SELECT u FROM Utilisateur u WHERE u.specialite = :specialite"),
    @NamedQuery(name = "Utilisateur.findByDateDeNaissance", query = "SELECT u FROM Utilisateur u WHERE u.dateDeNaissance = :dateDeNaissance"),
    @NamedQuery(name = "Utilisateur.findByVersion", query = "SELECT u FROM Utilisateur u WHERE u.version = :version")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUtilisateur")
    private Integer idUtilisateur;
    @Size(max = 350)
    @Column(name = "nom")
    private String nom;
    @Size(max = 350)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 254)
    @Column(name = "localisation")
    private String localisation;
    @Size(max = 350)
    @Column(name = "mail")
    private String mail;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 350)
    @Column(name = "login")
    private String login;
    @Size(max = 350)
    @Column(name = "password")
    private String password;
    @Size(max = 350)
    @Column(name = "specialite")
    private String specialite;
    @Column(name = "dateDeNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "version")
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private List<Administrateur> administrateurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private List<Candidat> candidatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private List<Recruteur> recruteurList;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Administrateur> getAdministrateurList() {
        return administrateurList;
    }

    public void setAdministrateurList(List<Administrateur> administrateurList) {
        this.administrateurList = administrateurList;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    @XmlTransient
    public List<Recruteur> getRecruteurList() {
        return recruteurList;
    }

    public void setRecruteurList(List<Recruteur> recruteurList) {
        this.recruteurList = recruteurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
