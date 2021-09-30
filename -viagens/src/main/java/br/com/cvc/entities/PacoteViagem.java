package br.com.cvc.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pacote_viagem")
public class PacoteViagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacoteViagem;
	

	@ManyToOne(optional = false)
	@JoinColumn(name = "idViagem")
	private Viagem viagem;
	
	private Long idAvaliacao;
	
	@NotEmpty(message = "Descrição não pode ser null ou vazio")
	private String descricao;
	
	private ZonedDateTime dataInicio;
	
	private ZonedDateTime dataFim;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.pacoteViagem", fetch = FetchType.EAGER)
	private List<ClientePacoteViagem> clientePacoteViagems;
 	
	public PacoteViagem() { }
	
	public PacoteViagem(Long idPacoteViagem, 
						Viagem viagem, 
						Long idAvaliacao,
			            String descricao, 
			            ZonedDateTime dataInicio,
			            ZonedDateTime dataFim) {
		super();
		this.idPacoteViagem = idPacoteViagem;
		this.viagem = viagem;
		this.idAvaliacao = idAvaliacao;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

		
	public List<ClientePacoteViagem> getClientePacoteViagems() {
		return clientePacoteViagems;
	}

	public void setClientePacoteViagems(List<ClientePacoteViagem> clientePacoteViagems) {
		this.clientePacoteViagems = clientePacoteViagems;
	}

	public Long getIdPacoteViagem() {
		return idPacoteViagem;
	}

	public void setIdPacoteViagem(Long idPacoteViagem) {
		this.idPacoteViagem = idPacoteViagem;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ZonedDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(ZonedDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public ZonedDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(ZonedDateTime dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(viagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacoteViagem other = (PacoteViagem) obj;
		return Objects.equals(viagem, other.viagem);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PacoteViagem [idPacoteViagem=");
		builder.append(idPacoteViagem);
		builder.append(", viagem=");
		builder.append(viagem);
		builder.append(", idAvaliacao=");
		builder.append(idAvaliacao);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", dataInicio=");
		builder.append(dataInicio);
		builder.append(", dataFim=");
		builder.append(dataFim);
		builder.append("]");
		return builder.toString();
	}
	
}
