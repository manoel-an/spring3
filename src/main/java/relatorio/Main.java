/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author manoel
 */
public class Main {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/conf/relatorio.xml");

		ServicoRelatorio serRel = (ServicoRelatorio) ctx.getBean("servicoRelatorio");

		serRel.geraRelatorioAnual(2010);
		serRel.geraRelatorioMensal(2010, 04);
		serRel.geraRelatorioDiario(2010, 04, 30);
	}

}
