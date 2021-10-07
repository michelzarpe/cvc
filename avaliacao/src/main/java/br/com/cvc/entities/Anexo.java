package br.com.cvc.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "anexo")
public class Anexo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdAnexo;
	
	private Long IdCliente;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_avaliacao")
	private Avaliacao avaliacao;
	
	private String arquivo;
	
	private String type;

	public Anexo() {}
	
	public Anexo(Long idAnexo, Long idCliente, Avaliacao avaliacao, String arquivo, String type) {
		super();
		IdAnexo = idAnexo;
		IdCliente = idCliente;
		this.avaliacao = avaliacao;
		this.arquivo = arquivo;
		this.type = type;
	}

	public Long getIdAnexo() {
		return IdAnexo;
	}

	public void setIdAnexo(Long idAnexo) {
		IdAnexo = idAnexo;
	}

	public Long getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Long idCliente) {
		IdCliente = idCliente;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IdAnexo, IdCliente, arquivo, avaliacao, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anexo other = (Anexo) obj;
		return Objects.equals(IdAnexo, other.IdAnexo) && Objects.equals(IdCliente, other.IdCliente)
				&& Objects.equals(arquivo, other.arquivo) && Objects.equals(avaliacao, other.avaliacao)
				&& type == other.type;
	}
	
}
