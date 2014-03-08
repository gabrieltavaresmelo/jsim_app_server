######################################################################
# Curso: Engenharia de Computação
# Disciplina: Programação Paralela e Distribuída
# Trabalho: Sistema de Interação Móvel (SIM)
# Aluno: Gabriel Tavares [https://github.com/gabrieltavaresmelo]
##########
#
# Aplicação: WebService utilizando JAX-WS
#
# Acesse o browser na seguinte URL:
# http://localhost:8080/ws/sim?wsdl
#
#
#
##########
# Este script gera os client stubs.
#
#
# Obs.: Antes de rodar este script, mande iniciar a aplicação 
# 	MainAppPublisher.java
#
######################################################################


# O que segue após o -d é a localização do diretório source de sua app para ler (Origem)
# O que segue após o -s é a localização do diretório source de sua app para salvar (Destino)
# O que segue após o -p é a estrutura de pacotes a qual as classes serão armazenadas 
# O que segue entre aspas é a localização de sua WSDL que no meu caso já esta publicando servidor

wsimport -d /opt/gabriel/computacao/desenvolvimento/workspace/workspace_java/ifce/jsim_app_server/src/main/java -s /opt/gabriel/computacao/desenvolvimento/workspace/workspace_java/ifce/jsim_app_middle/src/main/java -p br.com.gtmf.wsdl "http://localhost:8080/ws/sim?wsdl"
