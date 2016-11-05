package relatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Manoel
 */

@Component
public class ServicoRelatorioAnotacao {

	private GeradorRelatorio geradorRelatorio;

	public ServicoRelatorioAnotacao() {

	}

	@Autowired
	public void setGeradorRelatorio(GeradorRelatorio geradorRelatorio) {
		this.geradorRelatorio = geradorRelatorio;
	}

	private ServicoRelatorioAnotacao(int tipo) {
		if (tipo == 1)
			geradorRelatorio = new GeradorRelatorioPdfAnotacao();
		else if (tipo == 2)
			geradorRelatorio = new GeradorRelatorioHtmlAnotacao();
	}

	// ****fim caso 3

	public void geraRelatorioAnual(int ano) {
		String estatisticas = "Estatísticas";
		// Coleta estatisticas do ano
		geradorRelatorio.gerar(estatisticas + " do ano " + ano);
	}

	public void geraRelatorioMensal(int ano, int mes) {
		String estatisticas = "Estatísticas";
		// Coleta estatisticas do mes
		geradorRelatorio.gerar(estatisticas + " do mês " + mes + " de " + ano);
	}

	public void geraRelatorioDiario(int ano, int mes, int dia) {
		String estatisticas = "Estatísticas";
		// Coleta estatisticas do dia
		geradorRelatorio.gerar(estatisticas + " do dia " + dia + " de " + mes + " de " + ano);
	}

	public static ServicoRelatorioAnotacao criaServicoRelatorio(int tipo) {
		return new ServicoRelatorioAnotacao(tipo);
	}

}