package br.com.cvc.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.entities.Avaliacao;
import br.com.cvc.entities.AvaliacaoPergunta;
import br.com.cvc.entities.Pergunta;
import br.com.cvc.entities.Anexo;
import br.com.cvc.entities.Resposta;
import br.com.cvc.entities.dto.AnexoDTO;
import br.com.cvc.entities.dto.AvaliacaoDTO;
import br.com.cvc.entities.dto.AvaliacaoPerguntaDTO;
import br.com.cvc.entities.dto.PerguntaDTO;
import br.com.cvc.entities.dto.RespostaDTO;
import br.com.cvc.entities.enuns.Status;
import br.com.cvc.services.impl.AvaliacaoPerguntaService;
import br.com.cvc.services.impl.AvaliacaoService;
import br.com.cvc.services.impl.PerguntaService;

@Component
public class Mappers {
	
	@Autowired
	private PerguntaService perguntaService;

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private AvaliacaoPerguntaService avaliacaoPerguntaService;

	public static Pergunta getPergunta(PerguntaDTO perguntaDto) {
		return new Pergunta(null, perguntaDto.getDescricao());
	}

	public static Avaliacao getAvaliacao(AvaliacaoDTO avaliacaoDto) {
		return new Avaliacao(null, avaliacaoDto.getIdPacoteViagem(), Status.valueOf(avaliacaoDto.getStatus()).toString());
	}

	public Resposta getResposta(RespostaDTO respostaDto) {
		var avaliacaoPergunta = avaliacaoPerguntaService.getById(respostaDto.getIdAvaliacaoPergunta());
		return new Resposta(null,avaliacaoPergunta,respostaDto.getIdCliente(),respostaDto.getNota());
	}

	public AvaliacaoPergunta getAvaliacaoPergunta(AvaliacaoPerguntaDTO avaliacaoPerguntaDto) {
		var pergunta = perguntaService.getById(avaliacaoPerguntaDto.getIdPergunta());
		var avaliacao = avaliacaoService.getById(avaliacaoPerguntaDto.getIdAvaliacao());
		return new AvaliacaoPergunta(null,pergunta,avaliacao);
	}

	public Anexo getAnexo(AnexoDTO anexoDto) {
		var avaliacao = avaliacaoService.getById(anexoDto.getIdAvaliacao());
		return new Anexo(null, anexoDto.getIdCliente(),avaliacao,anexoDto.getArquivo(), "");
	}
}
