package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_ACI_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_ACI_USUARIO", allocationSize=1)
public class Usuario {

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario")
	private int id;
	
	@Column(name="nm_usuario", nullable=false, length=64)
	private String nome;

	@Column(name="nr_celular", nullable=false)
	private int celular;
	
	@Column(name="nm_email", nullable=false, length=50)
	private String email;
	
	@Column(name="ds_senha", nullable=false, length=64)
	private String senha;
	
	@Column(name="dt_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="ds_genero", length=15)
	private String genero;
	
	// CascadeType.REMOVE para remover em cascata
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Chuveiro> chuveiros;
	
	public Usuario() {}

	public Usuario(String nome, int celular, String email, String senha, Calendar dataNascimento, String genero) {
		super();
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Usuario(int id, String nome, int celular, String email, String senha, Calendar dataNascimento,
			String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public void addChuveiro(Chuveiro chuveiro) {
		if (getChuveiros() == null)
			setChuveiros(new ArrayList<>());
		
		getChuveiros().add(chuveiro);
		chuveiro.setUsuario(this);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Chuveiro> getChuveiros() {
		return chuveiros;
	}

	public void setChuveiros(List<Chuveiro> chuveiros) {
		this.chuveiros = chuveiros;
	}
	
}
