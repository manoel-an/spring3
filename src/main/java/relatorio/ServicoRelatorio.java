package relatorio;

/**
 *
 * @author Manoel
 */
// ****Caso 1 - dependência por meio de um método de atribuição (setter)
public class ServicoRelatorio {

	private GeradorRelatorio geradorRelatorio;

	/**
	 * @param geradorRelatorioPdf
	 */
	public void setGeradorRelatorio(GeradorRelatorioPdf geradorRelatorioPdf) {
		this.geradorRelatorio = geradorRelatorioPdf;
	}

	public ServicoRelatorio() {

	}
	// ****fim caso 1

	// ****Caso 2 - dependência pelo construtor com parâmetro.
	/*
	 * public ServicoRelatorio(int tipo){ // péssima prática if(tipo == 1)
	 * geradorRelatorio = new GeradorRelatorioPdf(); else if(tipo == 2)
	 * geradorRelatorio = new GeradorRelatorioHtml(); }
	 */
	// ****fim caso 2

	// ******Caso 3 - dependência por meio de um factory-method juntamente com
	// um construtor privado (com parâmetro)

	private ServicoRelatorio(int tipo) {
		if (tipo == 1)
			geradorRelatorio = new GeradorRelatorioPdf();
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

	public static ServicoRelatorio criaServicoRelatorio(int tipo) {
		return new ServicoRelatorio(tipo);
	}

}