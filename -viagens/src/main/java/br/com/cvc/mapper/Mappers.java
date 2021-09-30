package br.com.cvc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.entities.ClientePacoteViagem;
import br.com.cvc.entities.ClientePacoteViagemId;
import br.com.cvc.entities.PacoteViagem;
import br.com.cvc.entities.Viagem;
import br.com.cvc.entities.dto.ClientePacoteViagemDTO;
import br.com.cvc.entities.dto.PacoteViagemDTO;
import br.com.cvc.entities.dto.ViagemDTO;
import br.com.cvc.services.IPacoteViagemService;
import br.com.cvc.services.IViagemService;

@Component
public class Mappers {
	
	@Autowired
	private IViagemService viagemService;
	
	@Autowired
	private IPacoteViagemService pacoteViagemService;
	
	
	public static Viagem getViagem(ViagemDTO objDTO) {
		return new Viagem(null, objDTO.getDescricao());
	}

	public PacoteViagem getPacoteViagem(PacoteViagemDTO objDto) {
		return new PacoteViagem(null,
				viagemService.getById(objDto.getIdViagem()),
				objDto.getIdAvaliacao(),
				objDto.getDescricao(),
				objDto.getDataInicio(),
				objDto.getDataFim());
	}

	public ClientePacoteViagemId getClientePacoteViagemId(Long idCliente, Long IdPacoteViagem) {
		return new ClientePacoteViagemId(idCliente, pacoteViagemService.getById(IdPacoteViagem));
	}
	
	public ClientePacoteViagem getClientePacoteViagem(ClientePacoteViagemDTO objDto) {
		return new ClientePacoteViagem(this.getClientePacoteViagemId(objDto.getIdCliente(), objDto.getIdPacoteViagem()));
	}
}
