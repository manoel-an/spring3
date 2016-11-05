/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinicius
 */
@Component
@Qualifier("pdf")
public class GeradorRelatorioPdfAnotacao implements GeradorRelatorio {

	public void gerar(String relatorio) {
		System.out.println("Relatorio PDF gerado:" + relatorio);
	}

}
