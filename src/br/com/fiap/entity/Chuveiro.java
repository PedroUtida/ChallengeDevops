package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="T_ACI_CHUVEIRO")
@SequenceGenerator(name="chuveiro", sequenceName="SQ_T_ACI_CHUVEIRO", allocationSize=1)
public class Chuveiro {

	@Id
	@Column(name="id_chuveiro")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="chuveiro")
	private int id;
	
	@Column(name="ds_pressao", nullable=false, length=15)
	private String pressao;
	
	@Column(name="ds_temperatura", nullable=false)
	private int temperatura;
	
	@Column(name="ds_duracao")
	private double duracao;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Chuveiro() {}
	
	public Chuveiro(String pressao, int temperatura, double duracao) {
		super();
		this.pressao = pressao;
		this.temperatura = temperatura;
		this.duracao = duracao;
	}

	public Chuveiro(int id, String pressao, int temperatura, double duracao) {
		super();
		this.id = id;
		this.pressao = pressao;
		this.temperatura = temperatura;
		this.duracao = duracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
