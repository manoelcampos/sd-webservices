package com.manoelcampos.correios;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

/**
 *
 * Consulta o endereço a partir de um determinado CEP,
 * utilizando o Web Service gratuito dos Correios.
 * 
 * <p>Todas as classes do pacote {@link br.com.correios} foram
 * geradas automaticamente pelo IDE, a partir da importação
 * de um documento WSDL contendo a descrição do serviço
 * SOAP a ser acessado pela aplicação.
 * O endereço do WSDL utilizado é 
 * <a href="https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl">este</a>.
 * </p>
 * 
 * <p>Tendo o endereço do documento WSDL, no NetBeans, basta acessar o menu
 * File >> New File e depois "Web Services >> Web Service Client" para gerar
 * as classes que permitirão consumir (utilizar) o serviço.
 * Após fazer isso, o NetBeans lê o WSDL e gera um conjunto de classes,
 * salvas na pasta target/generated-sources e acessadas pelo
 * IDE a partir da aba Projects >> Generated Sources.</p>
 * 
 * <p>É importante frisar que você não deve alterar o código das classes nesta pasta,
 * pois se o Web Service for alterado e você tiver que atualizar seu projeto
 * (importando novamente o WSDL como explicado acima), você perderá
 * qualquer alteração que tenha feito nessas classes geradas.</p>
 * 
 * @author Manoel Campos da Silva Filho
 */
public class BuscaCep {
    public static void main(String[] args) {
        try { 
            /*Instancia a classe para permitir o consumo (utilização) do Web Service.
            Para descobrir o nome da classe que dá acesso ao WS, é preciso
            verificar a aba Projects >> Generated Sources e procurar
            por uma classe cujo nome termine em "Service" (normalmente).
            Um WS também deve possuir uma documentação adicional para desenvolvedores,
            apesar de nem sempre existir tal documentação.
            O nome de tal classe deve ser informado lá.
            */
            final AtendeClienteService service = new AtendeClienteService();
            
            /*Obtém uma porta que dá acesso ao Web Service.
            Portas também são chamadas de endpoints e fornecem um
            endereço absoluto para acesso ao serviço.
            A porta é uma URL para o serviço.
            Você pode conferir a URL da porta pesquisando por "<wsdl:port binding"
            dentro do documento WSDL indicado acima.
            Um WS pode ter várias portas, por exemplo, para suportar diferentes
            versões dos SOAP. A documentação também deve indicar como acessar
            uma determinada porta para o serviço.
            Mas em Java, a porta será um método 
            cujo nome segue o padrão getNomeDoServicoPort, como podem
            ver abaixo.
            Assim, basta procurar por um método que tenha a palavra "Port" no nome.
            */
            final AtendeCliente port = service.getAtendeClientePort();
            final String cep = "77022348";

            //A partir da porta então conseguimos chamar os métodos disponibilizados pelo WS
            final EnderecoERP result = port.consultaCEP(cep);
            System.out.println("Endereço: " + result.getEnd());
            System.out.println("Bairro: " + result.getBairro());
            System.out.println("Cidade: " + result.getCidade());
            System.out.println("UF: " + result.getUf());
        } catch (SQLException_Exception | SigepClienteException ex) {
            System.out.println("Erro ao consultar CEP: " + ex.getMessage());
        }
    }
}
