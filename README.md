# Arquitetura

### Requisitos: 
	● Ao ser finalizada a viagem, ou seja, um dia após a data final do pacote que foi adquirido, deve ser enviado um e-mail aos viajantes com um link onde é possível realizar a avaliação;
	● Um sistema de avaliação, com notas que variam de 0 a 10, onde a área de negócio pode cadastrar os itens que serão avaliados para aquele pacote de viagem. Por exemplo, em um pacote de viagem para uma praia, pode ser avaliado companhia aérea, hotel, da mesma forma que para um pacote de viagens para a Disney, podem ser avaliados outros itens mais específicos, como os passeios, traslado e etc.;
	● Deverá existir um sistema de curadoria dessas avaliações, onde uma pessoa da área de negócios pode excluir determinada avaliação caso esta não esteja de acordo com os termos de uso;
	● Podem ser anexadas nas avaliações fotos e vídeos da viagem;
	● O cliente deve ter acesso às avaliações de sua viagem, podendo removê-las a qualquer tempo;
	● Deve existir um sistema de busca nas avaliações por palavra, por exemplo, o cliente pode pesquisar em todas as avaliações daquele pacote pela palavra “café”.
	● Após aprovadas, as avaliações deverão ser exibidas no site ao ser consultado o pacote.
  
  
  ### Stack para projeto em equipe:

	1. CI/CD: Github -> AWS (Code Buid, Code Pipeline, ECS, Cloud Watch(logs de deploy e das aplicações rodando no ECS)): Lançar alterações automáticas para DEV e HML quando PR's aprovada. PRD deve ser lançado manualmente.
	2. GitHub: Repositório com branchs DEV, HML, PRD: merge apenas por pull requests com duas aprovações sem ser quem desenvolveu.
	3. Fluxo do desenvolvimento (JIRA): desenvolvendo → code review  → dev → hml → prd
	4. Linguagem de programação: Java 11
	5. Banco de dados: relacional (postgresql).
	6. Framework: Spring (boot, cloud, não usei o webflux mas podeira)
	7. Logs: Clout Watch
	8. Cloud: AWS (Code Pipeline, ECS, Cloud Watch)
	9. Monitoramento: DataDog
	10. Testes: Postman + Newman, Junit e Mockito 
	11. Documentação End-Point: Swagger (OpenAPI)
	12. Mensageria: RabbitMQ
	13. Virtualização: Docker

### Arquitetura e microsserviços:  
![Alt text](cvc-microserviços.png?raw=true "Arquitetura")

### Importar Postman  
Na raiz do projeto tem um arquivo exportado do postman (cvc.postman_collection.json) com todos os endpoints mapeados para executar.

### Endpoint por microsserviços:
1. ???-cliente:  
    	● Inserir/Alterar/Retornar/Excluir Cliente  
    	● Retornar pacotes finalizados do cliente  

2. ???-viagens:  
    	● Inserir/Alterar/Excluir/Retornar Viagem  
    	● Inserir/Alterar/Excluir/Retornar pacote por viagem  
    	● Inserir/Alterar/Excluir/Retornar Pacote de viagem para cliente      
    	● Retornar pacotes finalizados por clientes   
      
3. ???-disparador-email:  
    	● Enviar email para cada pacote de viagem com avaliação

4. ???-avaliacao:  
    	● Inserir/Alterar/Excluir/Retornar Avaliação para pacote de viagem  
    	● Inserir/Alterar/Excluir/Retornar Anexo para uma avaliação  
    	● Inserir/Alterar/Retornar/Excluir Pergunta para uma avaliação  
    	● Alterar/Retornar/Excluir/Inserir Resposta da Pergunta de uma avaliação  
    	● Retornar Avaliação por palavra da descrição da pergunta de um pacote  
    	● Retornar Avaliação por status  
    	● Retornar Anexos das avaliações por viagens  
      
### Ordem de execução: 
	1. Na raiz do projeto tem arquivo docker-compose.yml executar: docker-compose up -d
	2. Importar todos os projetos na IDE preferida.
	3. Compilar o projeto: librabbitmq. Lib de uma classe para serialização e deserialização.
	4. Executar uma vez o projeto: ???-config-server
	5. Executar uma vez o projeto: ???-eureka-service
	6. Executar uma vez o projeto: ???-api-gateway-zuul
	7. Executar uma vez o varias instâncias do projeto: ???-rabbitmq, ???-disparador-email, ???-viagens, ???-cliente, ???-avaliacao
 
  
  #### Observação: Não foi projetado servidor de autenticação (Oauth2) para colocar como clientes os micro serviços e ter usuários com perfis/permissão. 
  #### Cada microsserviço que contem as regras de negócio poder ser iniciado varias instâncias, pois é gerado um novo id e porta para inserir no ???-eureka-server;
  
