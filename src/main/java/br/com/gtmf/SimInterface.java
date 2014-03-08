package br.com.gtmf;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * Definicao da Interface do Servico.
 * 
 * @author Gabriel Tavares
 *
 */
@WebService
//@SOAPBinding(style = Style.RPC)
public interface SimInterface {
	
	/**
	 * Recebe a notificacao de que um novo usuario entrou no bate-papo
	 * e manda a lista com todos os clientes conectados para os usuarios
	 *  
	 * @param nickname
	 * @return error | nickname
	 */
	@WebMethod String login(String nickname);

	/**
	 * Recebe a notificacao de que um novo usuario entrou no bate-papo
	 * e manda a lista com todos os clientes conectados para os usuarios
	 *  
	 * @param nickname
	 * @return error | nickname
	 */
	@WebMethod String logout(String nickname);

	/**
	 * Envia o nickname para iniciar o radar e tambem o 
	 * bate-papo e retorna uma resposta de erro ou sucesso. 
	 * 
	 * @param nickname
	 * @param location
	 * @return error | nickname
	 */
	@WebMethod String startRadar(String nickname, String location);

	/**
	 * Envia o nickname para encerrar o radar e tambem o 
	 * bate-papo e retorna uma resposta de erro ou sucesso. 
	 * 
	 * @param nickname
	 * @param location
	 * @return error | ok
	 */
	@WebMethod String stopRadar(String nickname);

	/**
	 * Salva a mensagem num historico
	 * 
	 * @param from
	 * @param text
	 * @return error | ok
	 */
	@WebMethod String write(String from, String text);	
	
	/**
	 * Salva a mensagem (Recado) para um usuario especifico num historico
	 * 
	 * @param from
	 * @param to
	 * @param message
	 * @return error | ok
	 */
	@WebMethod String writeTo(String from, String to, String message);
	
	/**
	 * Envia a nova localizacao para o servidor no formato
	 * lat,lng. Exemplo: -3,85678,-3898768 
	 * 
	 * @param nickname
	 * @param location
	 * @return Os usuarios que estao mais proximos
	 */
	@WebMethod String changeLocation(String nickname, String location);
	
	/**
	 * Retorna uma lista com os usuarios mais proximos do
	 * usuario passado como parametro
	 * 
	 * @param nickname
	 * @return Os usuarios que estao mais proximos
	 */
	@WebMethod String listNearlyClients(String nickname);

	/**
	 * Recebe a notificacao de que uma nova sala foi adicionada
	 * 
	 * @param roomName
	 * @return
	 */
	@WebMethod String addRoom(String roomName);
	
	/**
	 * Retorna a sala do cliente
	 * 
	 * @param roomName
	 * @return
	 */
	@WebMethod String getRoom(String clientName);
	
	/**
	 * Lista todas as salas que existem
	 * 
	 * @return
	 */
	@WebMethod String listRooms();
	
	/**
	 * Muda a sala do cliente
	 * 
	 * @param clientName
	 * @param roomName
	 * @return
	 */
	@WebMethod String changeClientRoom(String clientName, String roomName);
	
}
